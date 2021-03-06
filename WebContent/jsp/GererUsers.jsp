<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gererusers</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<!-- header -->
<%@ includefile="include/header.jsp"%>

<!--modalNewUser start -->
<div class="modal" id="modalNewUser">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
            	<h5 class="modal-title" id="modalNewUserLabel"> Add a new user</h5>
		    	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
            </div>

            <div class="modal-body">
                <%@ includefile="function/NewUser.jsp"%>
            </div>

            <div class="modal-footer">
                <button class="btn btn-dark" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<!--modalNewUser end -->


<div class="container">
</br>

<%@ includefile="function/showAllUsers.jsp"%> 


<!-- modal button start -->
</br>
<button class="btn btn-dark" data-toggle="modal" data-target="#modalNewUser">Add users</button>
</br>
<!-- modal button end -->

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