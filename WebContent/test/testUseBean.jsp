<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<jsp:useBean id="User" scope="page" class="model.User"/>
<jsp:setProperty name="User" property="fname" value="test"/>
<body>
<p> Nom: <jsp:getProperty property="fname" name="User"/></p>

</body>
</html>