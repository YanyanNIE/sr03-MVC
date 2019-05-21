<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gererusers</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>

<%@ includefile="head.jsp"%>

<!--modal start -->
<div class="modal" id="modalNewUser">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                Creer un nouveau utilisateur
            </div>

            <div class="modal-body">
                <%@ includefile="NewUser.jsp"%>
            </div>

            <div class="modal-footer">
                <button class="btn btn-dark" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<!--modal end -->

<!-- modal button start -->
<ul class="nav flex-column">
	<li class="nav-item">
	   	<span class="d-block p-2 bg-dark text-white">
	   		<button class="btn btn-dark" data-toggle="modal" data-target="#modalNewUser">new users</button>
	   	</span>		
	 </li> 
</ul>
</br>
<!-- modal button end -->

<div class="container">

<%@ includefile="showAllUsers.jsp"%> 

</div>

<%@ includefile="footer.jsp"%>

</body>
</html>