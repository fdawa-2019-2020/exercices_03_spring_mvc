<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Spring MVC 101</title>
	<jsp:include page="fragments/declaration.jsp"/>
</head>
<body>
	<jsp:include page="fragments/header.jsp"/>
	<main role="main">
		<div class="container">
			<div class="row">
				<h1>Welcome</h1>
				<p>${welcome_message}</p>
			</div>
		</div>
	</main>
	<jsp:include page="fragments/footer.jsp"/>
</body>
</html>