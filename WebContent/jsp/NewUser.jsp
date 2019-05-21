<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <form action="/EvaluationSite/CreerUnUtilisateur" method="post">
  <div class="form-row" >
	    <div class="form-group col-md-6">
	      <label for="inputEmail4">Email</label>
	      <input type="email" class="form-control" id="email" placeholder="example@gmail.com" name="User login">
	    </div>
	    <div class="form-group col-md-6">
	      <label for="inputPassword4">Password</label>
	      <input type="password" class="form-control" id="pwd" placeholder="Password" name="User password">
	    </div>
    </div>
    <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputFname">First Name</label>
	      <input type="test" class="form-control" id="fname" name="User first name">
	    </div>
	    <div class="form-group col-md-6">
	      <label for="inputLname">Last Name</label>
	      <input type="test" class="form-control" id="lname" name="User last name">
	    </div>
    </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputSociety">Society</label>
      <input type="text" class="form-control" id="society" name="User society">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPhone">Phone</label>
      <input type="text" class="form-control" id="phone" name="User phone">
    </div>
    <div class="form-row">
      	<div class="custom-control custom-radio custom-control-inline">
		  <input type="radio" id="actif" name="User stat" class="custom-control-input" value="actif">
		  <label class="custom-control-label" for="actif">Actif</label>
		</div>
		<div class="custom-control custom-radio custom-control-inline">
		  <input type="radio" id="inactif" name="User stat" class="custom-control-input" value="inactif">
		  <label class="custom-control-label" for="inactif">Inactif</label>
		</div>  
		
		<div class="custom-control custom-radio custom-control-inline">
		  <input type="radio" id="admin" name="User identity" class="custom-control-input" value="admin">
		  <label class="custom-control-label" for="admin">admin</label>
		</div>
		<div class="custom-control custom-radio custom-control-inline">
		  <input type="radio" id="intern" name="User identity" class="custom-control-input" value="intern">
		  <label class="custom-control-label" for="intern">intern</label>
		</div>  
    </div>
  </div>
  </br>

  <button type="submit" class="btn btn-dark" value="Submit">Sign in</button>
</form>