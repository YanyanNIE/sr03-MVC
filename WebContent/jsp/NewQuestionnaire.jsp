<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <form action="/EvaluationSite/CreerUnQuestionnaire" method="post">
    <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputFname">Sujet</label>
	      <input type="test" class="form-control" id="sujetQnaire" name="Questionnaire sujet">
	    </div>
    </div>

    <div class="form-row">
      	<div class="custom-control custom-radio custom-control-inline">
		  <input type="radio" id="actif" name="Questionnaire stat" class="custom-control-input" value="actif">
		  <label class="custom-control-label" for="actif">Actif</label>
		</div>
		<div class="custom-control custom-radio custom-control-inline">
		  <input type="radio" id="inactif" name="Questionnaire stat" class="custom-control-input" value="inactif">
		  <label class="custom-control-label" for="inactif">Inactif</label>
		</div>  
    </div>
  </br>

  <button type="submit" class="btn btn-dark" value="Submit">Add</button>
</form>