<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<link href="${pageContext.request.contextPath}/core/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/core/css/table.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/core/layui/css/layui.css" media="all">
<style>
    .grid-demo,.grid-demo>div{height: 500px}
</style>
<body>

<div class="layui-row layui-col-space10">
    <div class="layui-col-xs12">
        <div class="grid-demo grid-demo-bg1 layui-anim layui-anim-scale">
            <div id="container"></div>
        </div>
    </div>
</div>
<div class="layui-row layui-col-space10">
    <div class="layui-col-xs12">
        <div class="grid-demo grid-demo-bg1 layui-anim layui-anim-scale">
            <button type="button" class="layui-btn layui-btn-lg layui-btn-radius" id="resetButton">
                <i class="layui-icon">&#xe63d;</i>重置图表
            </button>
        </div>
    </div>
</div>
</body>

<script src="${pageContext.request.contextPath}/core/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/core/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/core/layui/layui.all.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/core/js/echarts.js" charset="utf-8"></script>

<script>

    function initCharts() {
        var dom = document.getElementById("container");
        var myChart = echarts.init(dom);
        var app = {};
        var option = null;
        var arr = [1,2,3,4,5,6,7];
        arr.sort(function () {

            return 0.5 - Math.random();

        });
        option = {
            xAxis: {
                type: 'category',
                data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
            },
            yAxis: {
                type: 'value'
            },

            series: [{
                data: arr,
                type: 'line'
            }]
        };
        if (option && typeof option === "object") {
            myChart.setOption(option, true);
            myChart.on('finished', function () {
                layer.msg("渲染完成了");
            });
        }
    }

    $(function () {
        initCharts();
        $("#resetButton").on('click', function () {
            initCharts();
        });

        $('.grid-demo').on('DOMNodeInserted', function () {
            layer.msg("检测到了");
        });
    })
</script>
</html>
