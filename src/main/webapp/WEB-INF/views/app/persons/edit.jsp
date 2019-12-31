<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
						<form:form action="${editPersonUrl}" method="POST"
							modelAttribute="person">
							<div class="form-group">
								<form:label path="login">Login</</form:label>
								<form:input class="form-control" path="login" readonly="true"></form:input>
								<form:errors path="login" cssClass="error" />

							</div>
							<div class="form-group">
								<form:label path="firstname">First name</</form:label>
								<form:input class="form-control" path="firstname"></form:input>
								<form:errors path="firstname" cssClass="error" />

							</div>
							<div class="form-group">
								<form:label path="lastname">Last name</</form:label>
								<form:input class="form-control" path="lastname"></form:input>
								<form:errors path="lastname" cssClass="error" />

							</div>
							<div class="form-group">
								<input type="submit" value="Submit" />
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</main>
	<jsp:include page="../../fragments/footer.jsp" />
</body>
</html>