<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Hello World</title>
</head>
<body>
	<div align="center" id="cityForm">
		<table>
			<tr>
				<form:form method="GET" modelAttribute="cityForm" action="/PacteraExamWeather/weather/result">
					<td><label for="city"><spring:message
								code="label.city" /></label></td>
					<td><form:select path="city">
							<form:option value="NONE" label="--- Select ---" />
							<form:options items="${cityList}" />
						</form:select></td>
					<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
			<tr>
				<td><form:errors path="city" cssClass="error" /></td>
			</tr>
			</form:form>
		</table>
	</div>
</body>
</html>