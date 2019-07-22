<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XingYu Yi
  Date: 2019/5/16
  Time: 8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href=bootstrap/css/bootstrap.min.css>
    <script src="js/jquery-2.0.3.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<c:choose>
    <c:when test="${not empty msg}">
        <script type="text/javascript">
            alert("${msg.info}")
            var path = "${msg.path}";
            if (path==""){
                history.back();
            }
            location.replace("${pageContext.request.contextPath}/${msg.path}")
        </script>
    </c:when>
</c:choose>

</body>
</html>
<script type="text/javascript">

</script>
