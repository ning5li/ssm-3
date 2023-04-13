<%--
  Created by IntelliJ IDEA.
  User: 李宁
  Date: 2023/3/29
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        input[type=text], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }


    </style>
</head>
<body>
<h1>添加课程信息</h1>

<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data" >
    <input type="hidden" name="id" >
    <label for="name">Course Name</label>
    <input type="text" id="name" name="name" placeholder="Course name.." >

    <div id="div"></div>

    <label for="hours">hours</label>
    <input type="text" id="hours" name="hours" placeholder="course hours">

    <label for="sid">学院名称</label>
    <input type="text" id="sid" name="sid" placeholder="sid">

    <label for="file">课程封面</label>
    <input type="file" id="file" name="file" >

    <input type="submit" value="Add" >
</form>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/vue.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/axios.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jQuery.js"></script>
<script>
    $(function() {
        $("#name").blur(function() {
            $.post("${pageContext.request.contextPath}/check", {
                name : $(this).val()
            }, function(data) {
                if (data =="true") {
                    $("#div").html("课程名已存在！");
                    $(this).select();
                }else{
                    $("#div").html("ok！");
                }
            });
        });
    });
</script>

</body>
</html>
