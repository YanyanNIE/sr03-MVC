<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
 <title>Create new question</title>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel="stylesheet" type="text/css" href="/EvaluationSite/style/style.css">
 </head>
 <body>
 <div>Add a new question</div>
 <form action="/EvaluationSite/CreerUnQuestion" method="post">
 <label> Description </label>
 <input type="text" id="description" name="Question description"/>
 <br>

 <input type="submit" value="Submit">
 </form>

 </body>
</html>