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
    <script type="text/javascript">

        function save_param(shxm_id, shxzh_id, shx_mch) {
            $("#paramArea").append("<input name='shxparam' type='text' value='{\"shxm_id\":" + shxm_id + ",\"shxzh_id\":" + shxzh_id + "}'>" + shx_mch);
            // alert("保存参数");
            //调用ajax异步请求
            get_list_by_attr();
        }

        function get_list_by_attr() {
            //获取参数
            // var attrJson = {};
            var jsonStr = "flbh2="+${flbh2};
            $("#paramArea input[name='shxparam']").each(function (i, data) {
                var json = $.parseJSON(data.value);
                // attrJson["list_attr[" + i + "].shxm_id"] = json.shm_id;
                // attrJson["list_attr[" + i + "].shxzh_id"] = json.shxzh_id;
                //attrJson["flbh2"]=${flbh2};

                jsonStr = jsonStr + "&list_attr[" + i + "].shxm_id=" + json.shxm_id +
                    "&list_attr[" + i + "].shxzh_id=" + json.shxzh_id;
            });

            // alert(jsonStr);

            //刷新商品列表
            $.get("get_list_by_attr.do", jsonStr, function (data) {
                $("#skuListInner").html(data);
            });
        }
    </script>
</head>
<body>
<div id="paramArea">
</div>
<hr>
属性列表:<br>
<c:forEach items="${list_attr}" var="attr">
    ${attr.shxm_mch}:
    <c:forEach items="${attr.list_value}" var="val">
        <a href="javascript:save_param(${attr.id},${val.id},'${val.shxzh}${val.shxzh_mch}');">${val.shxzh}${val.shxzh_mch}</a>
    </c:forEach>
    <br>
</c:forEach>
</body>
</html>
