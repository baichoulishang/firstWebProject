<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/core/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<form action="${pageContext.request.contextPath}/file/uploadMultipartFile.do"
      method="post" enctype="multipart/form-data">
    <input type="file" name="upload_avatar">
    <input type="submit" value="提交">
</form>
<script src="${pageContext.request.contextPath}/core/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/core/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>

    $(function () {
        layui.use('upload', function(){
            var $ = layui.jquery
                ,upload = layui.upload;
            //指定允许上传的文件类型
            upload.render({
                elem: '#file'
                ,url: '${pageContext.request.contextPath}/file/upload.do'
                ,accept: 'file' //普通文件
                ,done: function(res){
                    console.log(res)
                }
            });

        });
    });
</script>

</body>
</html>