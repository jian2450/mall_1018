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
    <script type="text/javascript">
        function goto_check(){
            $("#goto_check").submit();
        }
    </script>
</head>
<body>
<div class="Cbox">
    <table class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <th>商品图片</th>
            <th>商品名称</th>
            <th>商品属性</th>
            <th>商品价格</th>
            <th>商品数量</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list_cart}" var="cart">
            <tr>
                <td><input onclick="change_shfxz(this.checked,${cart.sku_id})"
                           type="checkbox" ${cart.shfxz=="1"?"checked":""}/>${cart.shfxz}
                    <img src="upload/image/${cart.shp_tp}" alt="" width="80px"></td>
                <td>${cart.sku_mch}</td>
                <td>
                    颜色：<span style='color:#ccc'>白色</span><br>
                    尺码：<span style='color:#ccc'>L</span>
                </td>
                <td>${cart.sku_jg}</td>
                <td><input type="text" name="min" value="${cart.tjshl}" style="width:50px;text-align:center"></td>
                <td>删除</td>
            </tr>
        </c:forEach>

        <div class="Cprice">
            <form id="goto_check" action="goto_checkOrder.do">

                <div class="price">总价：${sum}</div>
                <div class="jiesuan" onclick="goto_check()">结算</div>
            </form>
        </div>

        </tbody>
    </table>
</div>
</body>
</html>
