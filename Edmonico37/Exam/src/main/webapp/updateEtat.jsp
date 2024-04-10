<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><% HttpSession %>
	<form action="checkingTable.jsp" method="post">
		<input type="submit" name="etat" value="P">
		<input type="submit" name="etat" value="A">
	</form>
</body>
</html>