<%@ page import="com.revature.connection.DbCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.revature.model.*"%>
<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}
%>
<!DOCTYPE html>
<html>
<head>
<title>Orders</title>
<%@ include file="includes/head.jsp" %>


</head>
<body>
	<%@ include file="includes/footer.jsp"%>
	<%@ include file="includes/navbar.jsp"%>
</body>
</html>