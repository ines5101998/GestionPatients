<%@page import="com.epi.gestionPatient.gestionPatient.entity.Patient"%>
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
<%@ include file="navbarP.html" %>
<br>

<div class=container>
<div class="card m-5 p-2">
  <div class="card-header">
  <c:if test="${patient != null}">
<h2>Edit patients</h2>
</c:if>
<c:if test="${patient == null}">
<h2>Add patient</h2>
</c:if>
<c:if test="${message!=null}">
<div class="alert alert-success" role="alert">
<c:out value="${message}"></c:out>
${patient=null}
</div>
</c:if>
</div>
 <div class="card-body"> 
<form action="/apiPatient/addP" method=post enctype="multipart/form-data">
   
  <div class="mb-3 mt-3">
    <label for="nom" class="form-label">Nom:</label>
    <input type=text class="form-control" id="nom"  name="nom" value="${patient.nom}">
  </div>
  <div class="mb-3">
    <label for="prix" class="form-label">Prenom:</label>
    <input type="text" class="form-control" id="prenom"  name="prenom" value="${patient.prenom}" >
  </div>
    <div class="mb-3">
    <label for="prix" class="form-label">Numero:</label>
    <input type="number" class="form-control" id="numtel"  name="numtel" value="${patient.numtel}" >
  </div>
  
    <div class="mb-3">
    <label for="photo" class="form-label">Photos:</label>
     <input type=hidden name=photo value="${patient.photo}">
    <input type="file" class="form-control" id="file"  name="file"  accept="image/png,image/jpg">
  </div>
  
  <div>
    <label for="quantite" class="form-label  mb-3">Service:</label>
  <select name="idService" >
  <option selected hidden>Choose here</option>
  <c:forEach items="${services}" var="cc">
  <option value="${cc.id }"<c:if test="${patient.service.id==cc.id }">selected="true"</c:if>>${cc.nom}</option>
  </c:forEach>
</select>
</div>

  <div>
    <label for="quantite" class="form-label  mb-3">Adresse:</label>
  <select name="adresse">
  <option selected hidden>Choose here</option>
  <c:forEach items="${adresses}" var="aa">
  <option value="${aa.id}"<c:if test="${patient.adresse.id==aa.id }">selected="true"</c:if>>${aa.codepostal} ${aa.rue} ${aa.ville}</option>
  </c:forEach>
</select>
</div>
  
        <input type="hidden" class="form-control" id="id" name="id" value="${patient.id}">

     <c:if test="${patient != null}">
		<button type="submit" class="btn btn-outline-dark mt-2" >Modifier</button>
		</c:if>
	<c:if test="${patient == null}">
		<button type="submit" class="btn btn-outline-dark mt-2" >Ajouter</button>
	</c:if>
	
</form>
</div>
  
</div>
</div>


</body>
</html>