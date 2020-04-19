<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setAttribute("ctx", request.getContextPath());%>
<html>
<head>
    <title>Title</title>
</head>

<link href="${ctx}/core/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/core/css/table.css" rel="stylesheet">
<link rel="stylesheet" href="${ctx}/core/layui/css/layui.css" media="all">
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form id="form" action="${ctx}/role/add.do">
                <div class="form-group">
                    <label>主键</label><input type="number" class="form-control" name="id" value="111"/>
                </div>
                <div class="form-group">
                    <label>主要信息</label><input class="form-control" type="email" name="rolename" value="baichoulishang@163.com"/>
                </div>
                <div class="form-group">
                    <label>备注</label><input class="form-control" name="note" value="shit"/>
                </div>
                <button type="submit" class="btn btn-default">提交</button>
                <button type="reset" class="btn btn-block">重置</button>
            </form>
        </div>
    </div>
</div>


<table class="gridtable">
    <tr id="firstTr">
        <th>Info Header 1</th>
        <th>Info Header 2</th>
        <th>Info Header 3</th>
    </tr>
    <tr>
        <td id="testClick">点击我有惊喜哦！！</td>
        <td id="testChange">监听div内容变化</td>
        <td>Text 1C</td>
    </tr>
    <tr>
        <td>Text 2A</td>
        <td>Text 2B</td>
        <td>Text 2C</td>
    </tr>
</table>

<table class="layui-hide" id="test"></table>

<div class="layui-row layui-col-space15">
    <div class="layui-col-xs12 beforeLoading">
        <div id="container" style="min-width:400px;height:400px"></div>
    </div>

</div>

</body>

<script src="${ctx}/core/js/jquery-3.3.1.min.js"></script>
<script src="${ctx}/core/js/bootstrap.js"></script>
<script src="${ctx}/core/layui/layui.all.js" charset="utf-8"></script>
<script src="${ctx}/core/js/SKU算法.js" charset="utf-8"></script>


<script>
    $(function () {
        $('#testClick').on('click', function () {
            var str = $('#form').serialize();
            $.ajax({
                type: "GET",
                url: "${ctx}/role/getList.do",
                data: str,
                dataType: "text",
                success: function (data) {
                    // 把后台传过来的json字符串进行解析
                    data = JSON.parse(data);
                    var tableData = data.data.list;
                    layui.use('table', function () {
                        var table = layui.table;
                        table.render({
                            elem: '#test'
                            , data: tableData
                            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                            , cols: [[
                                {field: 'id', width: '20%', title: 'ID', sort: true}
                                , {field: 'rolename', width: '50%', title: '用户名'}
                                , {field: 'note', width: '30%', title: '性别', sort: true}
                            ]]
                            , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                                //,curr: 5 //设定初始在第 5 页
                                , groups: 5 //只显示 1 个连续页码
                                , first: true //不显示首页
                                , last: true //不显示尾页

                            }
                        });
                    });
                },
                error: function (res) {
                    console.log("难道是出错了？？？");
                }
            });
        });

        <%--$(".btn-default").on('click', function () {--%>
        <%--    var str = $('#form').serialize();--%>
        <%--    $.ajax({--%>
        <%--        type: "GET",--%>
        <%--        url: "${ctx}/role/add.do",--%>
        <%--        data: str,--%>
        <%--        dataType: "text",--%>
        <%--        success: function (data) {--%>
        <%--            layer.msg("添加成功啦");--%>
        <%--        },--%>
        <%--        error: function (res) {--%>
        <%--            console.log("难道是出错了？？？");--%>
        <%--        }--%>
        <%--    });--%>
        <%--});--%>
        console.log("由$定义的");

        $('.gridtable').on('click', function (e) {
            debugger;
        });

    });

    window.onscroll = function (ev) {
        console.log("检测到了滚动");
    };

    window.onload = function (ev) {
        console.log("哈哈哈");
        var script = document.createElement("script");
        script.onload = function (ev1) {
            console.log("加载成功啦");
        };
        document.body.appendChild(script);
        script.src = "${ctx}/core/js/test.js";
    };

    window.onunload = function (ev) {
        alert("触发了onunload");
        console.log("触发了onunload");
    };

    window.onresize = function (ev) {
        console.log("大小发生了变化");
    };


    // 下载图片的方法.这个方法适用于已经进入了阅读页面
    function downloadPic() {
        var _src = $('.lazy_img:eq(0)').attr('src'),// 原始地址
            _src = _src.substr(0, _src.lastIndexOf('/')),// 切除页数之后
            _picNums = $('#pageselect').children().length;// 先获取一共有多少张图片
        for (let i = 1; i < _picNums; i++) {
            $('body').append($('<img src="' + _src + '/' + ('0000' + i).slice(-5) + '.jpg">'));
        }
        // 移除所有原来的图片,防止保存的时候混淆
        $('.lazy_img ').remove();
    }

    // 这个方法适用于在目录层下载
    function downloadAlbums(list) {
        var _src = 'https://cdn-msp.18comic.site/media/photos',// 原始地址,切除了目录名称和页数
            _picNums = 300,// 最大限度假设
            _last = _picNums;// 用来计数用
        list.forEach(e => {
            for (let i = 1; i < _picNums; i++) {
                $('body').append($('<img src="' + _src + '/' + e + '/' + ('0000' + i).slice(-5) + '.jpg">'));
            }
        });
        // 移除所有原来的图片,防止保存的时候混淆
        $('.lazy_img ').remove();
    }

    var album = $('.dropdown-toggle.btn.btn-primary');
    if (album.length) {
        album = album.eq(0).attr('href').split('/')[2];
        downloadAlbums([album]);
    } else {
        downloadPic();
    }


    $('.combo-menu-wrapper.show li')
        .attr('data-value', 'Consolas')
        .find('span')
        .css('font-family', 'Consolas')
        .text('Consolas');
    $('.note-view-wrapper').on('keyup', () => $('span').css('font-family', 'Consolas'));


</script>
<%--<script src="${ctx}/core/js/test.js"></script>--%>
</html>
