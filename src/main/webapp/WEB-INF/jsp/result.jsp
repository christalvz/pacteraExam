<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Pactera Exam</title>
</head>
<body>
	<div align="center" id="cityForm">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<form:form method="GET" modelAttribute="cityForm" action="/PacteraExamWeather/weather/result">
					<td><label for="city"><spring:message
								code="label.city" /></label></td>
					<td><form:select path="city">
							<form:options items="${cityList}" />
						</form:select></td>
					<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
			<tr><td><form:errors path="city" cssClass="error" /></td></tr>
			</form:form>
		</table>
	</div>
	<div align="center" id="cityForm">
		<table align="center" width="500px" border=1>
			<tr>
				<td colspan="2" align="center" width="30%"><spring:message code="weather.header" /></td>
			</tr>
			<tr>
				<td><spring:message code="weather.label.city" /></td>
				<td>${weatherDetails.name}</td>
			</tr>
			<tr>
				<td><spring:message code="weather.label.UpdatedTime" /></td>
				<td><fmt:formatDate pattern="EEE h:mm a" value="${weatherDetails.dt}" /></td>
			</tr>
			<tr>
				<td><spring:message code="weather.label.weather" /></td>
				<td>${weatherDetails.weather[0].description}</td>
			</tr>
			<tr>
				<td><spring:message code="weather.label.temperature" /></td>
				<td>
					<fmt:formatNumber type="number" maxFractionDigits="2" value="${weatherDetails.main.temp - 273}" />
					<spring:message code="weather.celcius"/></td>
			</tr>
			<tr>
				<td><spring:message code="weather.label.wind"/></td>
				<td>${weatherDetails.wind.speed}<spring:message code="weather.speed"/></td>
			</tr>
		</table>
	</div>
</body>
</html>