<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Marching Band</title>
</head>
<body>
	<form method="post" action="editMarchingBandServlet">
		<table>
			<tr>
				<th>Band Id</th>
				<th>Name of Band</th>
				<th>Number of Members</th>
				<th>Location Of Band</th>
				<th>Cost of Participation</th>
				<th>Level of Band</th>
				<th>Type of Props</th>
				<th>Number of Buses</th>
				<th>Had Color Guard</th>
				
				

			</tr>

			<c:forEach items="${requestScope.allMarchingBands}" var="currentMarchingBand">
				<tr>
					<td><input type="radio" name="bandId"
						value="${currentMarchingBand.bandId}">${currentMarchingBand.bandId}</td>
					<td>${currentMarchingBand.nameOfBand}</td>
					<td>${currentMarchingBand.numberOfMembers}</td>
					<td>${currentMarchingBand.locationOfBand}</td>
					<td>${currentMarchingBand.costOfParticipation}</td>
					<td>${currentMarchingBand.levelOfBand}</td>
					<td>${currentMarchingBand.typesOfProps}</td>
					<td>${currentMarchingBand.numberOfBuses}</td>
					<td>${currentMarchingBand.hasColorGuard}</td>
				</tr>
			</c:forEach>
		</table>
		<br /> <input type="submit" value="Delete Selected Marching Band"
			name="doThisToMarchingBand"><br /> <br /> 
			<input type="submit"
			value="Add New Marching Band" name="doThisToMarchingBand">
			<input type="submit"
			value="Edit Selected Marching Band" name="doThisToMarchingBand">
	</form>
	<br />
	<a href="index.html">Return Home</a>
	<br />
	<a href="viewMarchingBandServlet">View Marching Band</a>
</body>
</html>