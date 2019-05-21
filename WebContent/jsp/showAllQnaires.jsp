<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<sql:setDataSource var="allUsers" driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://localhost/sr02?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false"
     user="sr02"  password="sr02sr02"/>
<sql:query dataSource="${allUsers}" var="result">select * from users;</sql:query>


	<table class="table table-striped">
		<thead>
			<tr>
				<th>Email</th>
				<th>first name</th>
				<th>last name</th>
				<th>identity</th>
				<th>society</th>
				<th>phone</th>
				<th>date of creation</th>
				<th>stat</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.login}"/></td>
				<td><c:out value="${row.fname}"/></td>
				<td><c:out value="${row.lname}"/></td>
				<td><c:out value="${row.ident}"/></td>
				<td><c:out value="${row.society}"/></td>
				<td><c:out value="${row.phone}"/></td>
				<td><c:out value="${row.cdate}"/></td>
				<td><c:out value="${row.stat}"/></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
