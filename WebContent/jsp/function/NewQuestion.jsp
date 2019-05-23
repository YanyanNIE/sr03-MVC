<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <form action="/EvaluationSite/CreerUnQuestion" method="post">
 	<div class="form-row">
    	<div class="form-group col-md-6">
	      <input type="text" class="form-control" id="sujetQnaire" name="Questionnaire sujet" value="${param.qnaire}" readonly>
	    </div>
    </div>
    <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputSujet">Sujet</label>
	      <input type="text" class="form-control" id="sujetQn" name="Question sujet">
	    </div>   
    </div>

    <div class="form-row">
    	<div class="form-group col-md-6">
		    <label for="inputStat">Stat</label>
			    <div class="input-group">
				  <select class="custom-select" id="inputGroupSelectStat" name="Question stat">
				    <option selected>Choose...</option>
			    	<option value="inactif">inactif</option>
				     <option value="actif">actif</option>
				  </select>
			  </div>
		 </div>
    </div>
  </br>

  <button type="submit" class="btn btn-dark" value="Submit">Add</button>
</form>