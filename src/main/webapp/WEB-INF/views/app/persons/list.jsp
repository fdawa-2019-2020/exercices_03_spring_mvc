<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Spring MVC 101</title>
<jsp:include page="../../fragments/declaration.jsp" />
</head>
<body>
	<jsp:include page="../../fragments/header.jsp" />
	<main role="main">
		<div class="container">
			<div class="row">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Login</th>
							<th>First name</th>
							<th>Last name</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
					<c:forEach items="${persons}" var="person">
						<tr>
							<td>${person.id}</td>
							<td>${person.login}</td>
							<td>${person.firstname}</td>
							<td>${person.lastname}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

	</main>
	<jsp:include page="../../fragments/footer.jsp" />
</body>
</html>