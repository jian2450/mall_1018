<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<% String ran = System.currentTimeMillis()+""; %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath %>">
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <title>硅谷商城</title>
    <script type="text/javascript">
        $(function (){
            $("#a").submit();
        });
    </script>
</head>
<body>
    <form id="a" action="http://localhost:58080/payservice/payment"  method="POST" target="_blank">
        <input type="hidden" name="trade_no" id="out_trade_no" value="硅谷商城订单<%=ran%>">
        <input type="hidden" name="total_fee" value="0.01">
        <input type="hidden" name="busi_return_url" value="http://localhost:38080/order_test/order_success.do">
        <input type="hidden" name="busi_notify_url" value="http://localhost:8080/mall_1018_sale/real_pay_success.do">
        <input type="hidden" name="subject" value="尚硅谷支付测试专用">
        <input type="hidden" name="body" value="即时到账测试">
    </form>
</body>
</html>
