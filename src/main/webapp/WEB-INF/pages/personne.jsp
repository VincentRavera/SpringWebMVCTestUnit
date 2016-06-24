<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="page.title" /></title>
</head>
<body>

	<form:form action="add.html" commandName="personne" method="POST">
		<form:hidden path="id" />
		<form:label path="nom">Nom</form:label>
		<form:input path="nom" id="nom" />
		<form:errors path="nom" cssclass="error"></form:errors>
        <form:label path="prenom">Prenom</form:label>
		<form:input path="prenom" id="nom" />
<%-- 		<form:errors path="prenom" cssclass="error"></form:errors> --%>
		<p />
		<input type="submit" value="valider" />
	</form:form>
<a href="list.html">Annuler </a>

</body>
</html>