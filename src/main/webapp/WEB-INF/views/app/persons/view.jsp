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
				<div class="col-md-offset-2 col-md-8">
					<h2>Edition</h2>
					<div class="row">
						<s:url var="editPersonUrl" value="/app/persons/edit"></s:url>
						<table class="table table-striped">
							<tbody>
								<tr>
									<td><b>Id</b></td>
									<td>${person.id}</td>
								</tr>

								<tr>
									<td><b>Login</b></td>
									<td>${person.login}</td>
								</tr>
								<tr>
									<td><b>First Name</b></td>
									<td>${person.firstname}</td>
								</tr>
								<tr>
									<td><b>Last Name</b></td>
									<td>${person.lastname}</td>
								</tr>
								<tr>
									<td><b>Projets</b></td>
									<td>
										<c:if test="${empty person.participationPerProjectName}">
											Aucun projet associé
										</c:if> 
										<c:if test="${not empty person.participationPerProjectName}">
											<ol>
												<c:forEach items="${person.participationPerProjectName}"
													var="project">
													<li>${project.key}-${project.value}</li>
												</c:forEach>
											</ol>
										</c:if>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</main>
	<jsp:include page="../../fragments/footer.jsp" />
</body>
</html>