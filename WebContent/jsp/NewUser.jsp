<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
 <title>Create new user</title>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel="stylesheet" type="text/css" href="/EvaluationSite/style/style.css">
 </head>
 <body>
 <div>Add a new user</div>
 <form action="/EvaluationSite/CreerUnUtilisateur" method="post">
 
 <label> Email </label>
 <input type="email" id="email" name="User login"/>
 <br>
 
 <label> First name </label>
 <input type="text" id="fname" name="User first name"/>
 <br>
 
 <label> Family name </label>
 <input type="text" id="lname" name="User familly name"/>
 <br>
 

 <label> Password </label>
 <input type="password" id="pwd" name="User password"/>
 <br>
 
 <label> admin </label>
 <input type="radio" id="admin" name="User identity" value="admin" checked/>
 <br>
 <label> stagiaire </label>
 <input type="radio" id="intern" name="User identity" value="intern"/>
 <br>
 
 <label> Society </label>
 <input type="text" id="society" name="User society"/>
 <br>
 
  <label> Phone number </label>
 <input type="text" id="phone" name="User phone"/>
 <br>
 
 <label> Actif </label>
 <input type="radio" id="actif" name="User stat" value="actif" checked/>
 <br>
 <label> Inactif </label>
 <input type="radio" id="inactif" name="User stat" value="inactif"/>
 <br>
 


 <input type="submit" value="Submit">
 </form>

 </body>
</html>