<%--
  Created by IntelliJ IDEA.
  User: jian
  Date: 2022/7/13
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>硅谷商城</title>
</head>
<body>
    <h1>添加商品属性</h1>
    <hr>
    <form action="attr_add.do">
        <input type="text" value="${flbh2}" name="flbh2">
        <table border="1" width="800px">
            <tr><td>属性名：<input type="text" name="list_attr[0].shxm_mch"></td><td></td><td>添加属性值</td></tr>
            <tr><td>属性值：<input type="text" name="list_attr[0].list_value[0].shxzh"></td><td>单位：<input type="text" name="list_attr[0].list_value[0].shxzh_mch"></td><td>删除</td></tr>
            <tr><td>属性值：<input type="text" name="list_attr[0].list_value[1].shxzh"></td><td>单位：<input type="text" name="list_attr[0].list_value[1].shxzh_mch"></td><td>删除</td></tr>
        </table>
        <table border="1" width="800px">
            <tr><td>属性名：<input type="text" name="list_attr[1].shxm_mch"></td><td></td><td>添加属性值</td></tr>
            <tr><td>属性值：<input type="text" name="list_attr[1].list_value[0].shxzh"></td><td>单位：<input type="text" name="list_attr[1].list_value[0].shxzh_mch"></td><td>删除</td></tr>
            <tr><td>属性值：<input type="text" name="list_attr[1].list_value[1].shxzh"></td><td>单位：<input type="text" name="list_attr[1].list_value[1].shxzh_mch"></td><td>删除</td></tr>
        </table>
        添加：<input type="submit" value="提交">
    </form>

</body>
</html>
