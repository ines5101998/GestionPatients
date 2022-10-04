<%@page import="com.epi.gestionPatient.gestionPatient.entity.Service"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des etudiants</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
	   <script src="https://kit.fontawesome.com/45e38e596f.js" crossorigin="anonymous"></script>
	
</head>
<body>
<%@ include file="navbarS.html" %>
<br>

<div class=container>
<div class="card m-5 p-2">
  <div class="card-header">
   <c:if test="${service != null}">
<h2>Edit services</h2>
</c:if>
<c:if test="${service == null}">
<h2>Add service</h2>
</c:if>
</div>
 <div class="card-body"> 
<form action="/apiservice/add" method=post>
   
  <div class="mb-3 mt-3">
    <label for="nom" class="form-label">Nom:</label>
    <input type=text class="form-control" id="nom"  name="nom" value="${service.nom }">
  </div>

  
       <input type="hidden"  name="id" value="${service.id }">

  
 <c:if test="${service != null}">
		<button type="submit" class="btn btn-outline-dark mt-2" >Modifier</button>
		</c:if>
	<c:if test="${service == null}">
		<button type="submit" class="btn btn-outline-dark mt-2" >Ajouter</button>
	</c:if>
	</form>
</div>
  
</div>
</div>


</body>
</html>