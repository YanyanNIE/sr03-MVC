<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!-- SQL get all Questions by Questionnaire sujet -->
<sql:setDataSource var="esdb" driver="com.mysql.cj.jdbc.Driver" 
    url="jdbc:mysql://localhost/sr02?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false"
     user="sr02"  password="sr02sr02"/>
<sql:query dataSource="${esdb}" var="resultcc">
select * from course, choixqa where course.id=choixqa.id and course.sujetQnaire=?;
 <sql:param value="${param.qnaire}" />
</sql:query> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DoneQnairePage</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<!-- header -->
<%@ includefile="include/header.jsp"%>

<div class="container">
	</br>
	<center>
		<h3>
		<c:out value = "${param.qnaire}" />
		</h3>
	</center>
	</br>
	
<!-- show Questions and Answers -->
	<c:forEach var="rowcc" items="${resultcc.rows}">
	  <div class="card">
		    <div class="card-body">
		    	<!-- show Quesion and stat -->
		    	<h2 class="card-title"><c:out value="${rowcc.sujetQ}"/> </h2>
				
				<table class="table">
					<tbody>
					<tr>
					<td>
					    <div class="input-group">
						  <div class="input-group-prepend">
						    <div class="input-group-text">
						   <%--  <c:if test="${rowcc.canswer=true }"> --%>
						       <input type="radio" checked>
						    </div>
						  </div>
						  <input type="text" class="form-control" value="${ rowcc.sujetA}" readonly>
						  <div class="input-group-append">
						    <!-- <span class="input-group-text" id="basic-addon2">@example.com</span> -->
						     <c:if test="${rowcc.canswer==true }">
						    	<img src="/EvaluationSite/style/icon/true.png" width="55" height="38" class="input-group-text" >
					    	</c:if>
					    	 <c:if test="${rowcc.canswer==false }">
						    	<img src="/EvaluationSite/style/icon/false.png" width="55" height="38" class="input-group-text" >
					    	</c:if>
						  </div>
						</div>
					  </td>
					</tr>
					</tbody>
				</table>
				
				<br>
			</div>
		</div>
		<br>
	</c:forEach>

</div>

<!-- footer -->
<%@ includefile="include/footer.jsp"%>

<!-- Script start -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>
