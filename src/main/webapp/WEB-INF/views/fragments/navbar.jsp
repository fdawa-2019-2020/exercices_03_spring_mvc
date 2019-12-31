<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<header class="navbar navbar-default">
	<nav>
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="/index">Spring MVC 101</a>
	</nav>
	<div class="container">
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
			
				<s:url var="projectsUrl" value="/app/projects"/>
				<s:url var="personsUrl" value="/app/persons"/>
			
				<li><a href="${projectsUrl}">Projects</a></li>
				<li><a href="${personsUrl}">Persons</a></li>
			</ul>
		</div>
	</div>
</header>