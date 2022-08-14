<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath %>">
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/css.css">
    <link rel="stylesheet" href="css/style.css">
    <title>硅谷商城</title>
    <script type="text/javascript">
        // $(function (){
        //     $(":checkbox").each(function (i,json){
        //         var shfxz = json.value;
        //         if (shfxz == "1"){
        //             $(json).attr("checked",true);
        //         }
        //     });
        // });

        function change_shfxz(checked,sku_id) {
            var shfxz = "0";
            if (checked) {
                shfxz = "1";
            }
            $.post("change_shfxz.do", {sku_id: sku_id, shfxz: shfxz}, function (data) {
                $("#cartListInner").html(data);
            });
        }

    </script>
</head>
<body>

    <jsp:include page="header.jsp"></jsp:include>

    <div class="top_img">
        <img src="./images/top_img.jpg" alt="">
    </div>
    <div class="search">
        <div class="logo"><a href="index.do"><img src="./images/logo.jpg" alt=""></a></div>
        <div class="search_on">
            <div class="se">
                <input type="text" name="search" class="lf">
                <input type="submit" class="clik" value="搜索" style="height: 32px;">
            </div>
            <div class="se">
                <a href="">取暖神奇</a>
                <a href="">1元秒杀</a>
                <a href="">吹风机</a>
                <a href="">玉兰油</a>
            </div>
        </div>
    </div>

    <div id="cartListInner">
        <jsp:include page="cartListInner.jsp"></jsp:include>
    </div>

    <div class="footer">
        <div class="top"></div>
        <div class="bottom"><img src="images/foot.jpg" alt=""></div>
    </div>
</body>
</html>
