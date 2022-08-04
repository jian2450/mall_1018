<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>硅谷商城</title>
    <base href="<%=basePath %>">
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
    <script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
    <script>

        $(function (){
            var url = "${url}";
            var title = "${title}";
            if(url != null && title !=""){
                add_tab(url,title);
            }
        });

        function add_tab(url,title){

            var b =  $('#tt').tabs('exists',title);
            if (!b){
                $('#tt').tabs('add',{
                    title:title,
                    href:url,
                    closable:true,
                    tools:[{
                        iconCls:'icon-mini-refresh',
                        handler:function(){
                            alert('refresh');
                        }
                    }]
                });
            }else {
                $('#tt').tabs('select',title);
            }

        }
    </script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>
    <div data-options="region:'west',split:true,title:'West'" style="width:180px;padding:10px;">
        <div class="easyui-accordion" style="width:160px;">
            <div title="About" data-options="iconCls:'icon-ok'">
                <ul>
                    <li><a href="javascript:add_tab('goto_spu.do','商品信息管理')">商品信息管理</a><br></li>
                    <li><a href="javascript:add_tab('goto_attr.do','商品属性管理')">商品属性管理</a><br></li>
                    <li><a href="javascript:add_tab('goto_sku.do','商品库存管理')">商品库存管理</a><br></li>
                </ul>
            </div>
            <div title="About" data-options="iconCls:'icon-ok'">
                <ul>
                    <li>商品缓存管理<br></li>
                </ul>
            </div>
        </div>
    </div>
    <div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>
    <div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
    <div data-options="region:'center',title:'Center'">
        <div id="tt" class="easyui-tabs" style="height: 800px">

        </div>
    </div>



</body>
</html>