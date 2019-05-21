<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
 <title>Create new competence</title>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel="stylesheet" type="text/css" href="/EvaluationSite/style/style.css">
 </head>
 <body>
 <div>Add a new Skill</div>
 <form action="/EvaluationSite/CreerUnSkill" method="post">
 <label> skill </label>
 <input type="text" id="skill" name="Skill description"/>
 <br>

 <input type="submit" value="Submit">
 </form>

 </body>
</html>