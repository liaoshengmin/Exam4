<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/AddServlet"
		method="post">
		<table border="1" cellspacing="0" cellpadding="5" bordercolor="silver"
			align="center">
			<tr>
				<td>film_id</td>
				<td>title</td>
				<td>description</td>
				<td>language</td>
			</tr>
			<tr>
				<td><input type="text" name="film_id" /></td>
				<td><input type="text" name="title" /></td>
				<td><input type="text" name="description" /></td>
				<td><input type="text" name="language_name" /></td>
			</tr>
			<th></th>
			<th></th>
			<th><input type="submit" value="提交" /></th>
			<th><input type="reset" name="reset" /></th>
			<!--  -->

	</form>

</body>
</html>