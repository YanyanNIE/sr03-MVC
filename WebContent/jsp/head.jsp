<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">EvaluationSite</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item dropdown" >
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
          <img src="/EvaluationSite/style/icon/user.svg" width="30" height="30" class="d-inline-block align-top" alt="">
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/EvaluationSite/jsp/profile.jsp">profile</a>
          <div class="dropdown-divider"></div>
          <!-- <a class="dropdown-item" href="/EvaluationSite/src/LoginOut">Login out</a> -->
          <form action="/EvaluationSite/LoginOut" method="post">
	          <div class="form-group">
	          <button type="submit" class="btn btn-light" value="loginout" >Login out</button>
	          </div>
          </form>
        </div>
      </li>
    </ul>
  </div>
</nav>