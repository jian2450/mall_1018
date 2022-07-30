<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath %>">
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <title>$Title$</title>
</head>
<body>

    <h6>最新加入的商品</h6>
    <c:forEach items="${list_cart}" var="cart">
        <div class="one">
            <img src="upload/image/${cart.shp_tp}" width="80px" />
            <span class="one_name">
                ${cart.sku_mch}
            </span>
            <span class="one_prece">
             <b>￥${cart.sku_jg}</b><br/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;删除
            </span>
        </div>
    </c:forEach>


    <div class="gobottom">
        共<span>${list_cart.size()}</span>件商品&nbsp;&nbsp;&nbsp;&nbsp;
        共计￥<span>20000</span>
        <button class="goprice">去购物车</button>
    </div>

</body>
</html>
