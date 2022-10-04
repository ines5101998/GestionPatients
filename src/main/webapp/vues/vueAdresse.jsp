<%@page import="com.epi.gestionPatient.gestionPatient.entity.Adresse"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion Des Adresses</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>
<body>

<%@ include file="navbarA.html" %>
<br>
<br>
<br>
<div class="container">
<c:if test="${msg!=null }">
<div class="alert alert-danger" role="alert">${msg}</div>
</c:if>
<c:if test="${msg==null }">

<table  class="table">
<thead class="table-dark">
<tr>
<th >Id</th>
<th>code postal</th>
<th>rue</th>
<th>ville</th>
<th>actions</th>
</tr>
</thead>

<c:forEach items="${listeAdresse}" var="a">
<tr>
<td>${a.id }</td>
<td>${a.codepostal }</td>
<td>${a.rue }</td>
<td>${a.ville }</td>
<td><a href="/apiadresse/delete/${a.id}" onclick="return confirm('voulez vous supprimer cette adresse ?')"class="btn btn-danger" ><span class="fa fa-trash"></span></a>
<a href="/apiadresse/update/${a.id}" class="btn btn-warning"><span class="fa fa-edit"></a></td>

</tr>
</c:forEach>
</table>
</c:if>
</div>
</body>
</html>