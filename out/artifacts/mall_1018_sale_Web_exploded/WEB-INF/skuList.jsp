<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<!DOCTYPE html>
<html>
<head>
    <title>硅谷商城</title>
    <base href="<%=basePath%>">
</head>
<body>
<c:forEach items="${list_sku}" var="sku">
    <div style="margin-left: 10px;margin-top: 10px; float: left;border: 1px red solid;width: 250px;height: 250px">
            <img src="upload/image/${sku.spu.shp_tp}" style="margin-top: 5px;margin-left: 5px" width="150px" height="150px"><br>
           <a href="goto_sku_detail.do?sku_id=${sku.id}&spu_id=${sku.shp_id}" target="_blank"> ${sku.spu.shp_mch}<br></a>
            ${sku.sku_mch}<br>
            ${sku.jg}<br>
    </div>
</c:forEach>
</body>
</html>
