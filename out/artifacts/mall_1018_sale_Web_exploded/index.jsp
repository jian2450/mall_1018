<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>硅谷商城</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
        function b(){
            //表单序列化
            var form = $("#loginForm").serialize();

            $.get("login1.do",form,function (data){
               alert(data);
            });
        }
    </script>
</head>
<body>
    异步登录表单测试
    <hr>
    <form id="loginForm">
        username:<input type="text" name="yh_mch"><br>
        password:<input type="text" name="yh_mm"><br>
        shxmid:<input type="text" name="list_attr[0].shxm_id"><br>
        login:<input type="button" onclick="b()" value="test">

    </form>
</body>
</html>
