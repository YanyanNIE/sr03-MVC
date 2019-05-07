<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminpage</title>
<!--  <link rel="stylesheet" type="text/css" href="/EvaluationSite/style/style.css"> -->
  <link rel="stylesheet" type="text/css" href="/EvaluationSite/style/bootstrap-4.3.1-dist/css/bootstrap.min.css">
</head>
<body>
 <div class="container">
<%
 	String fname = (String)request.getAttribute("User fname");
	String lname = (String)request.getAttribute("User lname");
%>

<h3>
  <small class="text-muted">Bienvenue </small>
    <%=fname %> <%=lname %>
</h3>
	<ul class="nav flex-column">
	 	
	  <li class="nav-item">
	    <a class="nav-link active" href="/EvaluationSite/jsp/NewUser.jsp">
	    	<span class="d-block p-2 bg-dark text-white">
	    		creer un nouveau utilisateur
	    	</span>		
   		</a>
	  </li>
	  
	  <li class="nav-item">
	    <a class="nav-link" href="/EvaluationSite/jsp/NewAnswer.jsp">
	    	<span class="d-block p-2 bg-dark text-white">
	    		creer une nouvelle answer
   			</span>
   		</a>
	  </li>
	  
	  <li class="nav-item">
	    <a class="nav-link" href="/EvaluationSite/jsp/NewCompetence.jsp">
	    	<span class="d-block p-2 bg-dark text-white">
	    		creer une nouvelle competence
   			</span>
   		</a>
	  </li>
	  
	  <li class="nav-item">
	    <a class="nav-link" href="/EvaluationSite/jsp/NewQuestion.jsp">
	    	<span class="d-block p-2 bg-dark text-white">
	    		creer un nouveau question
	    	</span>
	    </a>
	  </li>
	  
	  <li class="nav-item">
	    <a class="nav-link" href="/EvaluationSite/jsp/NewQuestionnaire.jsp">
	    	<span class="d-block p-2 bg-dark text-white">
	    		creer un nouveau questionnaire
    		</span>
   		</a>
	  </li>
	  
	  <!-- <li class="nav-item">
	    <a class="nav-link" href="/EvaluationSite/jsp/GererQR.jsp">Gerer Questions</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="/EvaluationSite/jsp/GererQQ.jsp">Gerer Questionnaires</a>
	  </li> -->
	</ul>
</div>
</body>
</html>