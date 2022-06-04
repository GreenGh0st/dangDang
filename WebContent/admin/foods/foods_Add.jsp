<%@ page language="java" import="java.util.*,java.sql.*,entity.*,Dao.*" pageEncoding="utf-8" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">

	<title>My JSP 'foods_Update.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="admin/css/style.css"/>

</head>

<body>


<div class="main foodIndo">
	<div class="title">
		<h2>
			<img src="admin/images/ibg1.jpg"/>
			<span>添加商品信息</span>
		</h2>

	</div>

	<form action="admin/foods/check_Add.jsp" method="post">
		<table class="food" cellSpacing="1" cellPadding="5" width="50%" align="center" bgColor="#eeeeee"
			   style="border: 1px solid #8ba7e3" border="0">
			<td>商品种类</td>
			<td>
				<select name="type">
					<option value="硬盘">硬盘</option>
					<option value="电源">电源</option>
					<option value="显卡">显卡</option>
					<option value="处理器">处理器</option>
					<option value="外设">外设</option>
					<option value="内存">内存</option>
					<option value="主板">主板</option>
				</select>
			</td>
			</tr>

			<tr>
				<td>商品名称</td>
				<td><input type="text" name="name"/>
				</td>
			</tr>


			<tr>
				<td>商品简介</td>
				<td>
					<input type="text" name="jj"/>
				</td>
			</tr>

			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price"/></td>
			</tr>


			<tr>
				<td width="200px;"></td>
				<td align="left">
					<input class="btnbg" onclick="return checkForm()" style="margin-left: 300" type="submit"
						   value="确认修改">
					<input class="button_ok" onclick="history.go(-1);" style="margin-left: 150" type="button"
						   value="返回"/>
				</td>
			</tr>

		</table>
	</form>
</div>
<script type="text/javascript">
	function checkForm() {
		var name = updateBook.name.value;
		var type = updateBook.type.value;
		var remark = updateBook.remark.value;
		var price = updateBook.price.value;
		if (name == "" || name == null) {
			alert("请输入商品名");
			updateBook.name.focus();
			return false;
		} else if (type == "" || type == null) {
			alert("请输入商品类别");
			updateBook.type.focus();
			return false;
		} else if (remark == "" || remark == null) {
			alert("请输入商品介绍");
			updateBook.remark.focus();
			return false;
		} else if (price == "" || price == null) {
			alert("请输入商品价格");
			updateBook.price.focus();
			return false;

			alert('添加成功！');
			return true;
		}
	}
</script>
</body>
</html>
