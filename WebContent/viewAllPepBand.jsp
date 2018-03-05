<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pep Band</title>
</head>
<body>
	<form method="post" action="editPepBandServlet">
		<table>
			<tr>
				<th>Band Id</th>
				<th>Name of Band</th>
				<th>Number of Members</th>
				<th>Location Of Band</th>
				<th>Cost of Participation</th>
				<th>Level of Band</th>
				<th>Event Id</th>
				<th>Playing Position</th>
				
				

			</tr>

			<c:forEach items="${requestScope.allPepBands}" var="currentPepBand">
				<tr>
					<td><input type="radio" name="id"
						value="${currentPepBand.bandId}">${currentPepBand.bandId}</td>
					<td>${currentPepBand.nameOfBand}</td>
					<td>${currentPepBand.numberOfMembers}</td>
					<td>${currentPepBand.locationOfBand}</td>
					<td>${currentPepBand.costOfParticipation}</td>
					<td>${currentPepBand.levelOfBand}</td>
					<td>${currentPepBand.eventId}</td>
					<td>${currentPepBand.playingPosition}</td>
				
				</tr>
			</c:forEach>
		</table>
		<br /> <input type="submit" value="Delete Selected Pep Band"
			name="doThisToPepBand"><br /> <br /> <input type="submit"
			value="Add New Pep Band" name="doThisToPepBand">
			<br /> 
			<input type="submit"
			value="Add New Pep Band" name="doThisToPepBand">
			
	</form>
	<br />
	<a href="index.html">Return Home</a>
	<br />
	<a href="viewPepBandServlet">View Pep Band</a>


</body>
</html>