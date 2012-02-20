<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main page</title>
</head>
<body>

<h1>Welcome user!</h1>
<table>
	<tr>
	<td>Login</td> <td>${sessionScope.user.login}</td>
	</tr>
	<tr>
	<td>Password</td> <td>${sessionScope.user.password}</td>
	</tr>
	<tr>
	<td>Session</td> <td>${sessionScope.user.session}</td>
	</tr>
</table>

<form action="logout.do">
<input type="submit" value="Logout">
</form>

</body>
</html>