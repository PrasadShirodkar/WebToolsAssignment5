<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tld/rssutils.tld" prefix="rss" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>
			<spring:message code="label.assignmentDescription" />
		</title>
		<link rel="stylesheet" type="text/css" href="css/style.css" />		
	</head>
	<body>
		<div class="loginDiv" style="background-color:#eBeefa;">
			<h2><spring:message code="label.assignmentDescription" /></h2>
			
			<form:form method="post" action="Search.html">
				<table class="center" border="0">
					<tr>
						<td>
							<form:label for="searchText" path="searchText">
								<spring:message code="label.medicalTerm" />
							</form:label>							
						</td>
						<td>
							<form:input path="searchText" maxlength="40" size="30" />
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							<form:errors path="searchText" cssClass="error" />
						</td>
					</tr>
					<tr>
						<td colspan="2" class="center">
							<input type="submit" value='<spring:message code="button.search" />'/>
						</td>
					</tr>
				</table>
			</form:form>
			
			<c:if test="${searchResults != null}">
			<ul>			
			<c:forEach items="${searchResults}" var="searchResult">
				<li>
					${searchResult.description}
				</li>
				<br>
			</c:forEach>			
			</ul>
			</c:if>
			<c:if test="${requestScope.noSearchResults != null}">
				<h2 class="noResults"><spring:message code="text.noSearchResultsFound" /></h2>
			</c:if>			
		</div>
	</body>
</html>