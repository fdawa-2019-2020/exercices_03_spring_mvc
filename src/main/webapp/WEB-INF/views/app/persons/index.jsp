<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Spring MVC 101</title>
	<jsp:include page="../../fragments/declaration.jsp"/>
</head>
<body>
	<jsp:include page="../../fragments/header.jsp"/>
	<main role="main">
		<div class="container">
			<div class="row">
				<h1>Page des personnes</h1>
				<div class="row col-md-12 jumbotron">
					Les personnes sont gérées d'ici.
				</div>
				<div class="row">
					<div class="col-md-12">
					<h2>Actions</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<ul>
						<s:url var="personsBase" value="/app/persons"/>
						<li><a href="${personsBase}/list">Lister les personnes</a></li>
						<li><a href="${personsBase}/edit">Créer une personne</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</main>
	<jsp:include page="../../fragments/footer.jsp"/>
</body>
</html>