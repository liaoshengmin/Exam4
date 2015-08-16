<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%= request.getContextPath() %>/LoginServlet"
		method="post" name="LoginForm">
		<table border="1" cellspacing="0" cellpadding="5" bordercolor="silver"
			align="center">
			<tr>
				<td colspan="2" align="center" bgcolor="#E8E8E8">用户登陆</td>
			</tr>
			<tr>
				<td>First_Name：</td>
				<td><input type="text" name="fname" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" /> <input
					type="reset" name="reset" /></td>
			</tr>
		</table>

	</form>
</body>
</html>