<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<sql:setDataSource var="allUsers" driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://localhost/sr02?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false"
     user="sr02"  password="sr02sr02"/>
<sql:query dataSource="${allUsers}" var="result">select * from questionnaire;</sql:query>


	<table class="table table-striped">
		<thead>
			<tr>
				<th>Sujet</th>
				<th>stat</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.sujet}"/></td>
				<td><c:out value="${row.stat}"/></td>
				<td>
					 <a href="/EvaluationSite/jsp/QnairePage.jsp?qnaire=${row.sujet}" class="btn btn-dark">Edit</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
