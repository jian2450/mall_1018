<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<!DOCTYPE html>
<html>
<head>
    <title>硅谷商城</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/css.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="searchArea.jsp"></jsp:include>
    ${keywords}
    <hr>
   <c:forEach items="${list_sku}" var="sku">
        <div style="margin-left: 10px;margin-top: 10px; float: left;border: 1px red solid;width: 250px;height: 250px">
            <img src="upload/image/${sku.shp_tp}" style="margin-top: 5px;margin-left: 5px" width="150px" height="150px"><br>
           <a href="goto_sku_detail.do?sku_id=${sku.id}&spu_id=${sku.shp_id}" target="_blank"> ${sku.sku_mch}<br></a>
            库存：${sku.kc}<br>
            ￥${sku.jg}.00<br>
        </div>
    </c:forEach>

</body>
</html>
