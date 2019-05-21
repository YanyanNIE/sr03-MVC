<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:out value="${rowqq.sujetQn}"/>
 <form action="/EvaluationSite/CreerUneReponse" method="post">
 	<%-- <div class="form-row">
    	<div class="form-group col-md-6">
	      <input type="test" class="form-control" id="sujetQn" name="Question sujet" value="${rowqq.sujetQn}" readonly>
	    </div>
    </div>  --%>
    <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputFname">Sujet</label>
	      <input type="test" class="form-control" id="sujetA" name="Answer sujet">
	    </div>
    </div>

    <div class="form-row">
      	<div class="custom-control custom-radio custom-control-inline">
		  <input type="radio" id="actif" name="Answer stat" class="custom-control-input" value="actif">
		  <label class="custom-control-label" for="actif">Actif</label>
		</div>
		<div class="custom-control custom-radio custom-control-inline">
		  <input type="radio" id="inactif" name="Answer stat" class="custom-control-input" value="inactif">
		  <label class="custom-control-label" for="inactif">Inactif</label>
		</div>  
		
		<div class="custom-control custom-radio custom-control-inline">
		  <input type="radio" id="actif" name="Answer result" class="custom-control-input" value="TRUE">
		  <label class="custom-control-label" for="actif">TRUE</label>
		</div>
		<div class="custom-control custom-radio custom-control-inline">
		  <input type="radio" id="inactif" name="Answer result" class="custom-control-input" value="FALSE">
		  <label class="custom-control-label" for="inactif">FALSE</label>
		</div>  
    </div>
  </br>

  <button type="submit" class="btn btn-dark" value="Submit">Add</button>
</form>