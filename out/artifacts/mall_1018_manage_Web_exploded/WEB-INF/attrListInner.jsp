<%--
  Created by IntelliJ IDEA.
  User: jian
  Date: 2022/7/14
  Time: 2:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<html>
<head>
    <title>硅谷商城</title>
    <base href="<%=basePath %>">
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
</head>
<body>
    属性列表内嵌页<br>
    <c:forEach items="${list_attr}" var="attr">
        ${attr.shxm_mch}:
        <c:forEach items="${attr.list_value}" var="val">
            ${val.shxzh}:${val.shxzh_mch}
        </c:forEach>
        <br>
    </c:forEach>
</body>
</html>
