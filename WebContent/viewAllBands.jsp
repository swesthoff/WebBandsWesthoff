<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Bands</title>
</head>
<body>
	<form method="post" action="editConcertBandServlet">
		<table>
			<tr>
				<th>Band Id</th>
				<th>Name of Band</th>
				<th>Number of Members</th>
				<th>Location Of Band</th>
				<th>Cost of Participation</th>
				<th>Level of Band</th>

			</tr>

			<c:forEach items="${requestScope.allBands}" var="currentBand">
				<tr>
					<td><input type="radio" name="bandId"
						value="${currentBand.bandId}">${currentBand.bandId}</td>
					<td>${currentBand.nameOfBand}</td>
					<td>${currentBand.numberOfMembers}</td>
					<td>${currentBand.locationOfBand}</td>
					<td>${currentBand.costOfParticipation}</td>
					<td>${currentBand.levelOfBand}</td>
				</tr>
			</c:forEach>
		</table>
		<br /> <input type="submit" value="Delete Selected Concert Band"
			name="doThisToConcertBand"><br /> <br /> 
			<input type="submit"
			value="Add New Concert Band" name="doThisToConcertBand">
			<input type="submit"
			value="Edit Selected Concert Band" name="doThisToConcertBand">
	</form>
	<br />
	<a href="index.html">Return Home</a>
	<br />
	<a href="viewConcertBandServlet">View Concert Band</a>
</body>
</html>