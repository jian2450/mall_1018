<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>

    <link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
    <script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
</head>
<body class="easyui-layout">

    <div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">
        <h1>Hello,World!!!</h1>
    </div>
    <div data-options="region:'west',split:true,title:'West'" style="width:150px;padding:10px;">west content</div>
    <div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>
    <div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
    <div data-options="region:'center',title:'Center'"></div>
</body>
</html>
