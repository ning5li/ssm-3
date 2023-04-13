<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 李宁
  Date: 2023/3/29
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #courseTable {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 70%;
        }

        #courseTable td, #courseTable th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #courseTable tr:nth-child(even){background-color: #f2f2f2;}

        #courseTable tr:hover {background-color: #ddd;}

        #courseTable th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: center;
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>


<table id="courseTable" border="1" cellspacing="0" cellpadding="0" style="text-align: center" align="center">

    <tr>
        <th colspan="5">Course Info</th>
    </tr>

    <tr>
        <th>id</th>
        <th>name</th>
        <th>hours</th>
        <th>sid</th>
        <th>options(<a href="${pageContext.request.contextPath}/toAdd">add</a>)</th>
    </tr>

<%--    <tr th:each="course : ${courses}">--%>
<%--        <td th:text="${course.id}"></td>--%>
<%--        <td th:text="${course.name}"></td>--%>
<%--        <td th:text="${course.hours}"></td>--%>
<%--        <td th:text="${course.sid}"></td>--%>
<%--        <td>--%>

        <c:forEach items="${courses}" var="course">
            <tr>
            <td>${course.id}</td>
            <td>
                <img  src="${pageContext.request.contextPath}/${course.image}" width="50" height="50" />
                    ${course.name}
            </td>
            <td>${course.hours}</td>
            <td>${course.sid}</td>

            <td>
            <a  @click="deleteCourse" href="${pageContext.request.contextPath}/course/${course.id}">delete</a>
            <!--                <a  @click="deleteCourse(scope.row)" >delete</a>-->
            <a href="${pageContext.request.contextPath}/course/${course.id}">update</a>
            </td>
            </tr>
        </c:forEach>
        <br>

</table>

<form id="deleteForm" method="post">
    <input type="hidden" name="_method" value="delete">
</form>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/vue.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/axios.min.js"></script>
<script type="text/javascript">

    var vue = new Vue({
        el: "#courseTable",
        methods: {
            deleteCourse: function (event) {
                var result=confirm("确认删除此条信息？");
                event.preventDefault();
                if(result==true) {
                    var deleteForm = document.getElementById("deleteForm");
                    deleteForm.action = event.target.href;
                    deleteForm.submit();

                }
            }
        }

    });

    <%--window.onload=function(){--%>
    <%--    var url="${pageContext.request.contextPath}/getUser";--%>
    <%--    $.get(url,function (respronse) {--%>
    <%--        ${"email"}.text(respronse.email);--%>
    <%--    })--%>
    <%--}--%>
</script>

</body>
</html>


