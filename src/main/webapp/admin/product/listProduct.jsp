<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../../include/admin/adminHeader.jsp"%>
<%@include file="../../include/admin/adminNavigator.jsp"%>

<script>
    $(function() {
        $("#addForm").submit(function() {
            if (!checkEmpty("name", "产品名称"))
                return false;
            if (!checkEmpty("subTitle", "小标题"))
                return false;
            if (!checkNumber("originalPrice", "原价格"))
                return false;
            if (!checkNumber("promotePrice", "优惠价格"))
                return false;
            if (!checkInt("stock", "库存"))
                return false;
            return true;
        });
    });
</script>

<br><br>
<br><br>

<title>产品管理</title>
<div class="workingArea">
    <ol class="breadcrumb">
        <li class="active">产品管理</li>
    </ol>

    <div class="listDataTableDiv">
        <table
                class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
            <tr class="success">
                <th>ID</th>
                <th>产品类别</th>
                <th>产品名称</th>
                <th>产品小标题</th>
                <th width="53px">原价格</th>
                <th width="80px">优惠价格</th>
                <th width="80px">库存数量</th>
                <th width="80px">图片管理</th>
                <th width="80px">设置属性</th>
                <th width="42px">编辑</th>
                <th width="42px">删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="p">
                <tr>
                    <td>${p.id}</td>                
                    <td>${p.category.name}</td>
                    <td>${p.name}</td>
                    <td>${p.subTitle}</td>
                    <td>${p.originalPrice}</td>
                    <td>${p.promotePrice}</td>
                    <td>${p.stock}</td>
                    <td><a href="admin_productImage_list?product.id=${p.id}"><span
                            class="glyphicon glyphicon-picture"></span></a></td>
                    <td><a href="admin_propertyValue_edit?product.id=${p.id}"><span
                            class="glyphicon glyphicon-th-list"></span></a></td>
                    <td><a  href="product/edit?id=${p.id}"><span
                            class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a deleteLink="true"
                           href="product/deleteProduct.action?id=${p.id}"><span
                            class="     glyphicon glyphicon-trash"></span></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
	<% String reqUri="product/list"; %>
    <div class="pageDiv">
        <%@include file="../../include/admin/adminPage.jsp"%>
    </div>

</div>

<%@include file="../../include/admin/adminFooter.jsp"%>