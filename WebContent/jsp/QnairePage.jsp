<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

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
<title>QnairePage</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>

<%@ includefile="head.jsp"%>

 <div class="container">

<h3>
<c:out value = "${param.qnaire}" />
</h3>
<!--modal start -->
<div class="modal" id="modalNewQuestion">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                Add a new question
            </div>

            <div class="modal-body">
                <%@ includefile="NewQuestion.jsp"%>
            </div>

            <div class="modal-footer">
                <button class="btn btn-dark" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<!--modal end -->

<!--modal start -->
<div class="modal" id="modalNewAnswer">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                Add a new answer
            </div>

            <div class="modal-body">
                <%@ includefile="NewAnswer.jsp"%>
            </div>

            <div class="modal-footer">
                <button class="btn btn-dark" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<!--modal end -->

<c:forEach var="rowqq" items="${resultqq.rows}">
  <div class="card">
	    <div class="card-body">
		    <h2><c:out value="${rowqq.orders}"/> : <c:out value="${rowqq.sujetQn}"/></h2>
			<sql:query dataSource="${qqa}" var="resultqa">
			 select * from qa where sujetQ =?;
			 <sql:param value="${rowqq.sujetQn}" />
			</sql:query> 
			
			<c:forEach var="rowqa" items="${resultqa.rows}">
					<c:out value="${rowqa.orders}"/> :
					<c:out value="${rowqa.sujetA}"/> #
					<c:out value="${rowqa.canswer}"/>
				</br>
			</c:forEach>
			</br>
			<button class="btn btn-dark" data-toggle="modal" data-target="#modalNewAnswer">Add answer</button>
		</div>
	</div>
	</br>
</c:forEach>
<button class="btn btn-dark" data-toggle="modal" data-target="#modalNewQuestion">Add question</button>



</div>

<%@ includefile="footer.jsp"%>

</body>
</html>
