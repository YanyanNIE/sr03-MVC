<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!-- SQL get all Questions by Questionnaire sujet -->
<sql:setDataSource var="qqa" driver="com.mysql.cj.jdbc.Driver" 
    url="jdbc:mysql://localhost/sr02?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false"
     user="sr02"  password="sr02sr02"/>
<sql:query dataSource="${qqa}" var="resultqq">
select * from qq where sujetQnaire =?;
 <sql:param value="${param.qnaire}" />
</sql:query> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DoQuiz</title>
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
		<%-- <c:out value = "${Timestamp(System.currentTimeMillis())}" /> --%>
		
		</h3>
	</center>
	</br>
	<form action="/EvaluationSite/CheckQuiz" method="post">
	<input type="hidden" value="${param.qnaire}" name="Questionnaire sujet">
	<input type="hidden" value="${user.login}" name="User login">
	<input type="hidden" value="${Timestamp(System.currentTimeMillis())}" name="Course begin time">
	<c:forEach var="rowqq" items="${resultqq.rows}">
		<div class="card">
		    <div class="card-body">
					<h2 class="card-title"><c:out value="${rowqq.orders}"/>: <c:out value="${rowqq.sujetQn}"/> </h2> 
					
				<!-- SQL get all answers by question -->
				<sql:query dataSource="${qqa}" var="resultqa">
				 select * from qa, answer where qa.sujetQ=? and answer.sujet=qa.sujetA;
				 <sql:param value="${rowqq.sujetQn}" />
				</sql:query> 
				
				<!-- show all Answers -->
				<table class="table">
					<tbody>
						<c:forEach var="rowqa" items="${resultqa.rows}">
							<sql:query dataSource="${qqa}" var="AnswerStat">
							 select stat from question where sujet =?;
							 <sql:param value="${rowqq.sujetQn}" />
							</sql:query> 
							<tr>
								<td>
							      <div class="form-check">
									  <input class="form-check-input" type="radio" name="${rowqq.sujetQn}" id="${rowqq.sujetQn}" value="${rowqa.sujetA}" checked>
									  <label class="form-check-label" for="exampleRadios1">
									    <c:out value="${rowqa.sujetA}"/> 
									  </label>
									</div>
							    </div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</br>
			</div>
		</div>
		</br>
	</c:forEach>
	<button type="submit" class="btn btn-dark" value="Submit">Submit</button>
	<input type="hidden" value="${Timestamp(System.currentTimeMillis())}" name="Course end time">
	</form>


</div>

<!-- footer -->
<%@ includefile="include/footer.jsp"%>

<!-- Script start -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<!-- Script end -->
<script>
$('.carousel').carousel('pause');
</script>

</body>
</html>
