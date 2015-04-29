<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/style.css" />
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
	</head>
	<body>
		<table class="bodyTable">
			<tr>
				<td class="header">
					<tiles:insertAttribute name="header" />
				</td>
			</tr>
			<tr>
				<td>
					<tiles:insertAttribute name="body" />
				</td>
			</tr>
			<tr>
				<td align="center">
					<tiles:insertAttribute name="footer" />
				</td>
			</tr>
		</table>
	</body>
</html>