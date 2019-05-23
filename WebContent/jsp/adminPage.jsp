<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gererusers</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<!-- header -->
<%@ includefile="include/header.jsp"%>

<div class="container">

	<h2>
	  <small class="text-muted">Bienvenue </small>
	    ${user.fname}
	    ${user.lname}
	    
	</h2>
	<br>
	
	<div class="row">
	  <div class="col-sm-6">
	    <div class="card">
	      <div class="card-body">
	        <h5 class="card-title">Gérer des utilisateurs</h5>
	        <p class="card-text">Vous pouvez les ajouter, les supprimer...</p>
	        <a href="/EvaluationSite/jsp/GererUsers.jsp" class="btn btn-dark"> Go </a>
	      </div>
	    </div>
	  </div>
	  <div class="col-sm-6">
	    <div class="card">
	      <div class="card-body">
	        <h5 class="card-title">Gérer des questionnaires</h5>
	        <p class="card-text">Créer des questionnaire maintenant!</p>
	        <a href="/EvaluationSite/jsp/GererQnaire.jsp" class="btn btn-dark"> Go </a>
	      </div>
	    </div>
	  </div>
	</div>

</div>

<!-- footer -->
<%@ includefile="include/footer.jsp"%>

<!-- Script start -->

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<!-- Script end -->

</body>
</html>
