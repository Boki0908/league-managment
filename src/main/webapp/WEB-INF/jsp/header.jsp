<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Balkan F1 Esports League</title>
<link rel="shortcut icon" type="image/png" href="${contextPath}/resources/images/logo.png">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<link href="${contextPath}/resources/css/style.css" rel="stylesheet">

</head>
<body>

<nav class="custom-nvbar navbar navbar-expand-lg navbar-light bg-light">
  <a class="custom-nav" href="/">
  <img style="max-width:100px; margin-top: -7px;"
             src="${contextPath}/resources/images/bf1el-logo.png"></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="custom-nav navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="custom-nav" href="/drivers">Drivers</a>
      </li>
      <li class="nav-item">
        <a class="custom-nav" href="/teams">Teams</a>
      </li>
      <li class="nav-item dropdown">
        <a class="custom-nav dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Standings
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
      
          <a class="dropdown-item" href="/driver_standings">Driver Standings</a>
           <a class="dropdown-item" href="/team_standings">Team Standings</a>
        </div>
      </li>
     <li class="nav-item">
        <a class="custom-nav" href="/rules">Rules</a>
      </li>
      <li class="nav-item">
        <a class="custom-nav" href="/history">History</a>
      </li>
      <li class="nav-item">
        <a class="custom-nav" href="/contact">Contact</a>
      </li>
    </ul>
     <form method="get" action="/login" class="form-inline my-2 my-lg-0">
      <button class="lg-btn btn btn-outline-success my-2 my-sm-0" type="submit">LOGIN</button>
      
    </form>
    <form method="get" action="/registration" class="form-inline my-2 my-lg-0">
      <button class="lg-btn btn btn-outline-success my-2 my-sm-0" type="submit">Registration</button>
    </form>
  </div>
</nav>