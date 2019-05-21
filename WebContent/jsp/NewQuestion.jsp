<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <form action="/EvaluationSite/CreerUnQuestion" method="post">
 	<div class="form-row">
    	<div class="form-group col-md-6">
	      <input type="test" class="form-control" id="sujetQnaire" name="Questionnaire sujet" value="${param.qnaire}" readonly>
	    </div>
    </div>
    <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputFname">Sujet</label>
	      <input type="test" class="form-control" id="sujetQn" name="Question sujet">
	    </div>
	    
    </div>

    <div class="form-row">
      	<div class="custom-control custom-radio custom-control-inline">
		  <input type="radio" id="actif" name="Question stat" class="custom-control-input" value="actif">
		  <label class="custom-control-label" for="actif">Actif</label>
		</div>
		<div class="custom-control custom-radio custom-control-inline">
		  <input type="radio" id="inactif" name="Question stat" class="custom-control-input" value="inactif">
		  <label class="custom-control-label" for="inactif">Inactif</label>
		</div>  
    </div>
  </br>

  <button type="submit" class="btn btn-dark" value="Submit">Add</button>
</form>