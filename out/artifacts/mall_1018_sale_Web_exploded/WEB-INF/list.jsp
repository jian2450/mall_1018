<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath %>">
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <title>硅谷商城</title>
</head>
<body>
    <jsp:include page="attrList.jsp"></jsp:include>
    <hr>
    <div id="skuListInner">
        <jsp:include page="skuList.jsp"></jsp:include>
    </div>
</body>
</html>
