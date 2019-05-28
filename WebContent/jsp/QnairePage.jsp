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
select * from qq, question where qq.sujetQnaire =? and qq.sujetQn=question.sujet;
 <sql:param value="${param.qnaire}" />
</sql:query> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnairePage</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<!-- header -->
<%@ includefile="include/header.jsp"%>

<!--modalNewQuestion start -->
<div class="modal" id="modalNewQuestion">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
            	<h5 class="modal-title" id="modalNewQuestionLabel">Add a new question</h5>
		    	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>  
            </div>

            <div class="modal-body">
                <%@ includefile="function/NewQuestion.jsp"%> 
            </div>
            
            <div class="modal-footer">
                <button class="btn btn-dark" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<!--modalNewQuestion end -->


<!--modalNewAnswer start -->
<div class="modal fade" id="modalNewAnswer" tabindex="-1" role="dialog" aria-labelledby="modalNewAnswerLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add a new answer</h5>
    	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>    
      </div>

      <div class="modal-body">    
               <form action="/EvaluationSite/CreerUneReponse" method="post">
				 	<div class="form-row">
				    	<div class="form-group col-md-6">
					      <input type="text" class="form-control" id="sujetQn" name="Question sujet"  readonly>
					    </div>
				    </div>
				    <div class="form-row">
					    <div class="form-group col-md-6">
					      <label for="inputSujet">Sujet</label>
					      <input type="text" class="form-control" id="sujetA" name="Answer sujet">
					    </div>
				    </div>
				
				    <div class="form-row">
						<div class="form-group col-md-6">
						    <label for="inputStat">Stat</label>
							    <div class="input-group">
								  <select class="custom-select" id="inputGroupSelectStat" name="Answer stat">
								    <option selected>Choose...</option>
							    	<option value="inactif">inactif</option>
								     <option value="actif">actif</option>
								  </select>
							  </div>
						 </div>
						 <div class="form-group col-md-6">
						    <label for="inputResult">Result</label>
							    <div class="input-group">
								  <select class="custom-select" id="inputGroupSelectResult" name="Answer result">
								    <option selected>Choose...</option>
							    	<option value="TRUE">TRUE</option>
								     <option value="FALSE">FALSE</option>
								  </select>
							  </div>
						 </div>
				    </div>
			  <button type="submit" class="btn btn-dark" value="Submit">Add</button>
			</form>
      </div>

      <div class="modal-footer">
        <button class="btn btn-dark" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<!--modalNewAnswer end -->


<div class="container">
	</br>
	<center>
		<h3>
		<c:out value = "${param.qnaire}" />
		</h3>
	</center>
	</br>
	
<!-- show Questions and Answers -->
	<c:forEach var="rowqq" items="${resultqq.rows}">
	  <div class="card">
		    <div class="card-body">
		    	<!-- show Quesion and stat -->
		    	<table class="table">
					<tbody>
					<tr>
					    <td><h2 class="card-title"><c:out value="${rowqq.orders}"/> </h2> </td>
					    <td> <h2 class="card-title"><c:out value="${rowqq.sujetQn}"/> </h2></td>
					    <td>
				    	<form action="/EvaluationSite/UpdateQuestionStat" method="post">
							<div class="form-group">
								<input type="hidden" value="${rowqq.sujetQn}" name="Question sujet">
							    <div class="input-group">
								  <select class="custom-select" id="inputGroupSelectStat" name="Question stat">
								    <option selected>${rowqq.stat}</option>
								    <c:if test="${rowqq.stat == 'actif'}">
								    	<option value="inactif">inactif</option>
								    </c:if>
								    <c:if test="${rowqq.stat == 'inactif'}">
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
					</tr>
					</tbody>
				
				<!-- SQL get all answers by question -->
				<sql:query dataSource="${qqa}" var="resultqa">
				 select * from qa, answer where qa.sujetQ=? and answer.sujet=qa.sujetA;
				 <sql:param value="${rowqq.sujetQn}" />
				</sql:query> 
				
				<!-- show all Answers and stats -->
				<table class="table">
					<tbody>
						<c:forEach var="rowqa" items="${resultqa.rows}">
						<sql:query dataSource="${qqa}" var="AnswerStat">
						 select stat from question where sujet =?;
						 <sql:param value="${rowqq.sujetQn}" />
						</sql:query> 
						<tr>
							<th scope="row"><c:out value="${rowqa.orders}"/></th>
							<td><c:out value="${rowqa.sujetA}"/> </td>
							<td><c:out value="${rowqa.canswer}"/> </td>
							<td>
								<form action="/EvaluationSite/UpdateAnswerStat" method="post">
									<div class="form-group">
									    <input type="hidden" value="${rowqa.sujetA}" name="Answer sujet"> 
									    <div class="input-group">
										  <select class="custom-select" id="inputGroupSelectStat" name="Answer stat">
										    <option selected>${rowqa.stat}</option>
										    <c:if test="${rowqa.stat == 'actif'}">
										    	<option value="inactif">inactif</option>
										    </c:if>
										    <c:if test="${rowqa.stat == 'inactif'}">
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
						</tr>
						</c:forEach>
					</tbody>
				</table>
				</br>
			</div>
			<button class="btn btn-dark" data-toggle="modal" data-target="#modalNewAnswer" data-whatever="${rowqq.sujetQn}">Add answer</button>
		</div>
		</br>
	</c:forEach>
	
	<button class="btn btn-dark" data-toggle="modal" data-target="#modalNewQuestion" >Add question</button>

</div>

<!-- footer -->
<%@ includefile="include/footer.jsp"%>

<!-- Script start -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<script>
$('#modalNewAnswer').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget) // Button that triggered the modal
  var recipient = button.data('whatever') // Extract info from data-* attributes
  var modal = $(this)/* 
  modal.find('.modal-title').text('Add a new answer ' + recipient) */
  modal.find('.modal-body input[name="Question sujet"]').val(recipient)
}) 

</script>
<!-- Script end -->

</body>
</html>
