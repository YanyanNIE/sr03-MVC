<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>profile</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<!-- sql start -->
<sql:setDataSource var="getProfile" driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://localhost/sr02?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false"
     user="sr02"  password="sr02sr02"/>
<sql:query dataSource="${getProfile}" var="result">
 select * from users where login =?;
 <sql:param value="${user.login}" />
</sql:query>

<!-- sql end -->

<!-- header -->
<%@ includefile="include/header.jsp"%>
</br>

<div class="container">

 <c:forEach var="row" items="${result.rows}">
 <form action="/EvaluationSite/UpdateProfile" method="post">

  <div class="form-row" >
	    <div class="form-group col-md">
	      <label for="inputEmail4">Email</label>
	      <input type="email" class="form-control" id="email" placeholder="${row.login}" name="User login" value="${row.login}" readonly>
	    </div>
   </div>
   
   <div class="form-row" >
	    <div class="form-group col-md">
	      <label for="inputPassword4">Password</label>
	      <input type="password" class="form-control" id="pwd" name="User password" value="${row.pwd}">
	    </div>
    </div>
    
    <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputFname">First Name</label>
	      <input type="test" class="form-control" id="fname" name="User first name" value="${row.fname}">
	    </div>
    
	    <div class="form-group col-md-6">
	      <label for="inputLname">Last Name</label>
	      <input type="test" class="form-control" id="lname" name="User last name" value="${row.lname}">
	    </div>
    </div>
  	
  	<div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputSociety">Society</label>
	      <input type="text" class="form-control" id="society" name="User society" value="${row.society}">
	    </div>
    
	    <div class="form-group col-md-6">
	      <label for="inputPhone">Phone</label>
	      <input type="text" class="form-control" id="phone" name="User phone" value="${row.phone}">
	    </div>
    </div>
    
    
    <div class="form-row">
      <div class="form-group col-md-6">
    	<label for="inputIdentity">Identity</label>
	    <div class="input-group">
		  <select class="custom-select" id="inputGroupSelectIdentity" name="User identity">
		    <option selected>${row.ident}</option>
		    <c:if test="${row.ident == 'admin'}">
		    	<option value="intern">intern</option>
		    </c:if>
		    <c:if test="${row.ident == 'intern'}">
		     <option value="admin">admin</option>
	     	</c:if>
		  </select>
	    </div>
 	  </div> 
	  <div class="form-group col-md-6">
	    <label for="inputStat">Stat</label>
		    <div class="input-group">
			  <select class="custom-select" id="inputGroupSelectStat" name="User stat">
			    <option selected>${row.stat}</option>
			    <c:if test="${row.stat == 'actif'}">
			    	<option value="inactif">inactif</option>
			    </c:if>
			    <c:if test="${row.stat == 'inactif'}">
			     <option value="actif">actif</option>
		     	</c:if>
			  </select>
		  </div>
	   </div> 
   </div>
  </br>

  <button type="submit" class="btn btn-dark" value="Update">Update</button>
</form>
</c:forEach>


</div>

<!-- footer -->
<%@ includefile="include/footer.jsp"%>


<!-- Script start -->

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<!-- Script end -->
</body>
</html>