<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<sql:setDataSource var="esdb" driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://localhost/sr02?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false"
     user="sr02"  password="sr02sr02"/>
<sql:query dataSource="${esdb}" var="course">
select * from course;
</sql:query>

<h4>Questionnaire Done</h4>
<table class="table table-striped">
	<thead>
		<tr>
			<th>Sujet</th>
			<th>score</th>
			<th>duration</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="rowCourse" items="${course.rows}">
		<tr>
			<td><c:out value="${rowCourse.sujetQnaire}"/></td>
			<td><c:out value="${rowCourse.scores}"/></td>
			<td><c:out value="${rowCourse.duration}"/></td>
			<td>
				 <a href="/EvaluationSite/jsp/DoneQnairePage.jsp?qnaire=${rowCourse.sujetQnaire}" class="btn btn-dark">Detail</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>



