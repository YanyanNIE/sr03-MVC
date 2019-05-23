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


<table class="table">
	<thead class="thead-dark">
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
			<td>
				<form action="/EvaluationSite/UpdateUserStat" method="post">
				<div class="form-group">
				    <!-- <label for="statSelect">Example select</label> -->
				    <input type="hidden" value="${row.login}" name="User login"> 
				    <%-- <input type="text" class="form-control" placeholder="${row.stat}" name="User stat"> --%>
				    <div class="input-group">
					  <select class="custom-select" id="inputGroupSelectStat" name="User stat">
					    <option selected>${row.stat}</option>
					    <c:if test="${row.stat == 'actif'}">
					    	<option value="inactif">inactif</option>
					    </c:if>
					    <c:if test="${row.stat == 'inactif'}">
					     <option value="actif">actif</option>
				     	</c:if>
					  </select>
					  <div class="input-group-append">
					    <button class="btn btn-outline-secondary" type="submit" value="Update">update</button>
					  </div>
					</div>
 					</div>
 					<!-- <button type="submit" class="btn btn-dark" value="Update" >update</button> -->
 					</form>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>


