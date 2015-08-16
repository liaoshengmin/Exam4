<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
ArrayList listname1 = new ArrayList();
listname1 =(ArrayList) session.getAttribute("listname1");
%>

<form action="<%=request.getContextPath()%>/AddServlet"
		method="post">
		<table border="1" cellspacing="0" cellpadding="5" bordercolor="silver"
			align="center">
			<tr>
				<td>title</td>
				<td>description</td>
				<td>language</td>
			</tr>
			<tr>
				<td><input type="text" name="title" /></td>
				<td><input type="text" name="description" /></td>
				<td> <select name="language_name">
					<%for(int i=0;i<listname1.size();i++){ %>
					    <option><%=listname1.get(i)%></option>
					    <%} %>
					</select>
					</td>
			</tr>
			<th></th>
			<th></th>
			<th><input type="submit" value="提交" /></th>
			<th><input type="reset" name="reset" /></th>
			<!--  -->

	</form>

</body>
</html>