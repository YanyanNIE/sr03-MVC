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
    	<div class="form-group col-md-6">
		    <label for="inputStat">Stat</label>
			    <div class="input-group">
				  <select class="custom-select" id="inputGroupSelectStat" name="Questionnaire stat">
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