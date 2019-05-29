<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<sql:setDataSource var="esdb" driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://localhost/sr02?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false"
     user="sr02"  password="sr02sr02"/>
<sql:query dataSource="${esdb}" var="questionnaire">
select * from questionnaire;
</sql:query>


<c:if test="${user.identity == 'admin'}">
<table class="table table-striped">
	<thead>
		<tr>
			<th>Sujet</th>
			<th>stat</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="rowQnaire" items="${questionnaire.rows}">
		<tr>
			<td><c:out value="${rowQnaire.sujet}"/></td>
			<td>
				<form action="/EvaluationSite/UpdateQnaireStat" method="post">
				<div class="form-group">
				    <input type="hidden" value="${rowQnaire.sujet}" name="Qnaire sujet"> 
				    <div class="input-group">
					  <select class="custom-select" id="inputGroupSelectStat" name="Qnaire stat">
					    <option selected>${rowQnaire.stat}</option>
					    <c:if test="${rowQnaire.stat == 'actif'}">
					    	<option value="inactif">inactif</option>
					    </c:if>
					    <c:if test="${rowQnaire.stat == 'inactif'}">
					     <option value="actif">actif</option>
				     	</c:if>
					  </select>
					  <div class="input-group-append">
					    <button class="btn btn-outline-secondary" type="submit" value="Update">update</button>
					  </div>
					</div>
 					</div>
 					</form>
			</td>
			<td>
				 <a href="/EvaluationSite/jsp/QnairePage.jsp?qnaire=${rowQnaire.sujet}" class="btn btn-dark">Edit</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</c:if>

<!-- Page pour Intern  -->
<c:if test="${user.identity == 'intern'}">
<h4>All Questionnaires</h4>
<table class="table table-striped">
	<thead>
		<tr>
			<th>Sujet</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="rowQnaire" items="${questionnaire.rows}">
		<tr>
			<c:if test="${ rowQnaire.stat == 'actif'}">	
				<td><c:out value="${rowQnaire.sujet}"/></td>
				<td><a href="/EvaluationSite/jsp/DoQuiz.jsp?qnaire=${rowQnaire.sujet}" class="btn btn-dark">DoQuiz</a></td>
			</c:if>
		</tr>
		</c:forEach>
	</tbody>
</table>
</c:if>



