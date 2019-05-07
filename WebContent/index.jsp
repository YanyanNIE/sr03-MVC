<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
 <head>
 <title>Login</title>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 
 <!--  <link rel="stylesheet" type="text/css" href="/EvaluationSite/style/style.css"> -->
  <link rel="stylesheet" type="text/css" href="/EvaluationSite/style/bootstrap-4.3.1-dist/css/bootstrap.min.css">

 </head>
 
 <body>
 <div class="container">
 
 <h3>
  <small class="text-muted">BIENVENUS </small>
   Evaluation Site
</h3>
 <br>

	<form action="/EvaluationSite/CheckLogin" method="post">
		 <div class="form-group">
			 <label> Login </label>
			 <input type="text" class="form-control" id="login" name="User Login"/>
			 <br>
			
			 <label> Password </label>
			 <input type="password" class="form-control" id="psw" name="User password"/>
			 <br>
			
			 <!--  <input type="submit" value="Submit"/> -->
			 <button type="submit" class="btn btn-secondary" value="Submit">Submit</button>
		 </div>
	 </form>
 </div>
 </body>
 
</html>