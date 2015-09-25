<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
table {
	border: 1px solid #99bbe8;
	border-collapse: collapse;
	width: 80%;
}

table td {
	border: 1px solid #B3D8EA;
	text-align: left;
	width: 16%;
	font: 宋体;
	font-size: 13px;
	padding: 7px;
}
a{
	text-decoration: none;
}

.title{
	text-align: right;
	background-color: #F1F9FC;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<table>
		<tr>
			<td class="title">拍卖编号</td>
			<td></td>
			<td class="title">拍卖名称</td>
			<td></td>
			<td class="title">拍卖状态</td>
			<td></td>
		</tr>
		<tr>
			<td class="title">保证金订单编号</td>
			<td></td>
			<td class="title">保证金金额</td>
			<td></td>
			<td class="title">保证金状态</td>
			<td></td>
		</tr>
		<tr>
			<td class="title">该保证金相关拍卖订单</td>
			<td colspan="5">
				<a href="#">查看</a>
			</td>
		</tr>
	</table>
</body>
</html>