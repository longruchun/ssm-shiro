<%@page import="com.eshop.model.shopPet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/share/head.jsp"%>
<!DOCTYPE html>
<html>
<head>

<title>宠物添加</title>

<style type="text/css">
tr {
	vertical-align: middle;
}

th {
	text-align: center;
}

input.wd66 {
	width: 66px;
}
</style>


</head>

<body>
	<form action="${pageContext.request.contextPath}/pet/add" method="post" enctype="multipart/form-data">
		<table style="width: 60%; margin: 10px auto;"
			class="table table-bordered table-condensed table-hover table-responsive table-striped ">
			<caption class="text-center">增加宠物</caption>

			<tr>
                <td>Id：</td>
				<td><input class="wd66" type="text" name="id"	 placeholder="输入id" /></td>
			</tr>

			<tr>
                <td>名称：</td>
				<td><input class="wd66" type="text" name="name"	 placeholder="输入名称" /></td>
			</tr>
			<tr>
			    <td>类型名称：</td>
				<td><input class="wd66" type="text" name="typename"  placeholder="输入类型名称" /></td>
			</tr>
			<tr>
				<td>健康值 ：</td>
				<td><input class="wd66" type="text" name="health"  placeholder="输入健康值" /></td>
			</tr>
			<tr>
			    <td>亲密度:</td>
				<td><input class="wd66" type="text" name="love"  placeholder="输入亲密度" /></td>
			</tr>
			<tr>
			    <td>日期:</td>
				<td><input type="text" name="birthday"  placeholder="输入日期" /></td>
			</tr>
			<tr>
				<td>主人:</td>
				<td><input type="text" name="ownerId"  /></td>
			</tr>
			<tr>
				<td>店:</td>
				<td><input type="text" name="storeId" /></td>
			</tr>
			<tr>
				<td>价格:</td>
				<td><input type="text" name="price" /></td>
			</tr>
			
			<tr>
				<td>photo:</td>
				
				<td>
				   <input type="file" name="photo_1" />
				</td>
			</tr>
			
			<tr>
                 <td colspan="2">
                    <input type="submit" value="提交" />
                 </td>
             </tr>
		</table>

	</form>
</body>
</html>