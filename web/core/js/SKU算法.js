// 自定义排序规则进行排序
var sortRule = {
    "caseywlb": 1,
    "caseywlxjb": 2,
    "bjblx": 3,
    "casesftcxfjb": 4
};

function mySort(a, b) {
    return sortRule[a.split("_")[0]] - sortRule[b.split("_")[0]];
}


var bjblx = ['3501|3502', '3501', '3502', ''],
    caseywlxjb = ['15', '16', '30', ''],
    caseywlb = ['0305'],
    casesftcxfjb = ['1', '0'],
    casejjrsfyzjcl = ['1', '0'];
// var sortStr = ["bjblx", "casesftcxfjb", "caseywlb", "caseywlxjb"];
// sortStr.sort(mySort);
// var sortObj = [caseywlb, caseywlxjb, bjblx, casesftcxfjb];
// getMutualData(sortObj);


// sortStr = ["casesftcxfjb", "caseywlb", "caseywlxjb"];
// sortStr.sort(mySort);
// var sortObj = [caseywlb, caseywlxjb, casesftcxfjb];
// getMutualData(sortObj);


sortStr = ["caseywlb", "casejjrsfyzjcl"];
sortStr.sort(mySort);
var sortObj = [caseywlb, casejjrsfyzjcl];
getMutualData(sortObj);


function getMutualData(_objArr) {
    var _log_arr = [], _log_str = "";
    digui(_objArr[0]);
    _log_arr = Array.from(new Set(_log_arr));
    _log_arr.forEach(e => {
        _log_str += e;
    });
    console.log(_log_str.slice(0, -2));


    /**
     * 递归函数,用来将所有的元素们交叉穷举
     * @param curEle
     * @param param
     */
    function digui(curEle, ...param) {
        var _index = getIndex(curEle);
        for (let i = 0; i < curEle.length; i++) {
            let e = curEle[i];
            if (_index === sortObj.length - 1) {
                // 如果已经递归到最后一个元素了,那么准备输出结果
                // 深拷贝一份.可以试着自己写一份高级点的深拷贝,但是这种基本的场景没必要
                let copyPayam = JSON.parse(JSON.stringify(param));
                // 添加最后一个元素
                copyPayam.push(sortStr[_index] + (e ? ("_" + e) : ""));
                // 先对结果进行排序,这里用到的比较器必须用自定义的
                copyPayam.sort(mySort);
                console.log("原始数据:" + copyPayam);
                // 用来存放下面这个步骤的结果
                // 只有按照顺序能够到达的元素才放进去
                var _result_arr = [copyPayam[0]];
                // 对这些数据进行处理,假如b无法由他的父元素通过交互展示出来,那么在我们需要的数据中,就只需要他的父元素,还有根节点
                // 从1开始.没必要从0开始
                for (let _arr_index = 1, _arr_length = copyPayam.length; _arr_index < _arr_length; _arr_index++) {
                    let _ele_now = copyPayam[_arr_index],
                        _ele_parent = copyPayam[_arr_index - 1],
                        _parent_ele = _ele_parent.split('_'),
                        _parent_obj;
                    if (_parent_ele.length === 2) {
                        _parent_obj = originalData[_parent_ele[0]][_parent_ele[1]];
                    } else {
                        _parent_obj = originalData[_parent_ele[0]][""];
                    }
                    if (Object.keys(_parent_obj).includes(_ele_now.split('_')[0])) {
                        _result_arr.push(_ele_now);
                    } else {
                        break;
                    }
                }
                _result_arr.sort(mySort);
                console.log("整理之后的数据" + _result_arr);
                // 从原始数据中,把copyPayam中的key对应的值取出来,合并放进一个对象中
                let _newObj = {};
                for (let i = _result_arr.length - 1; i >= 0; i--) {
                    let _result = _result_arr[i].split("_");
                    if (_result.length === 2) {
                        _newObj = $.extend(_newObj, originalData[_result[0]][_result[1]]);
                    } else {
                        _newObj = $.extend(_newObj, originalData[_result[0]][""]);
                    }
                }
                // 将原始数据转换成我们需要的格式
                _log_arr.push("\"" + _result_arr.sort(mySort).join("__") + "\":" + JSON.stringify(_newObj) + ",\n");
                // console.log(_result.slice(0, -2));
            } else {
                // 传入展开操作符,展开参数
                if (param.length) {
                    digui(sortObj[_index + 1], sortStr[_index] + (e ? ("_" + e) : ""), ...param);
                } else {
                    digui(sortObj[_index + 1], sortStr[_index] + (e ? ("_" + e) : ""));
                }
            }
        }
    }

    function getIndex(str) {
        for (let i = sortObj.length - 1; i >= 0; i--) {
            if (sortObj[i] == str) {
                return i;
            }
        }
    }
}
