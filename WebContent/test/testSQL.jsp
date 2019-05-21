<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testSQL</title>
</head>
<body>

<c:out value="testSQL"/>
<sql:setDataSource var="allUsers" driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://localhost/sr02?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false"
     user="sr02"  password="sr02sr02"/>
<sql:query dataSource="${allUsers}" var="result">SELECT * FROM users;</sql:query>

<div class="container">
			<c:forEach var="row" items="${result.rows}">
				<c:out value="${row.login}"/>
				<c:out value="${row.fname}"/>
				<c:out value="${row.lname}"/>
				<c:out value="${row.ident}"/>
				<c:out value="${row.society}"/>
				<c:out value="${row.phone}"/>
				<c:out value="${row.cdate}"/>
				<c:out value="${row.stat}"/>
			</c:forEach>

</div>


</body>
</html>