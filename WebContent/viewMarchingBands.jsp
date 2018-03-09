<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Marching Band</title>
<style>
table, td, th {
	border: 1px solid black;
	border-collapse: separate;
	border-spacing: 2px;
	padding: 2px;
}
h2 {
  color: red;
  
}  

</style>
</head>
<body>
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3ABOPsjdTWnipQQ0c4HaieQ4FdBhIw4Iqu6nQKGjeB6YE-X2kJQ"> 
<h2 > View List of Marching Bands</h2>
	<form method="post" action="editMarchingBandServlet">
		<table>
			<tr>
				<th> </th>
				<th>Name of Band</th>
				<th>Number of Members</th>
				<th>Location Of Band</th>
				<th>Cost of Participation</th>
				<th>Level of Band</th>
				<th>Type of Props</th>
				<th>Number of Buses</th>
				<th>Has Color Guard</th>
				
				

			</tr>

			<c:forEach items="${requestScope.allMarchingBands}" var="currentMarchingBand">
				<tr>
					<td><input type="radio" name="bandId"
						value="${currentMarchingBand.bandId}"></td>
					<td>${currentMarchingBand.nameOfBand}</td>
					<td>${currentMarchingBand.numberOfMembers}</td>
					<td>${currentMarchingBand.locationOfBand}</td>
					<td>
					<fmt:formatNumber value="${currentMarchingBand.costOfParticipation}" type="currency" />
					</td>
					<td>${currentMarchingBand.getLevelOfBand()}</td>
					<td>${currentMarchingBand.typesOfProps}</td>
					<td>${currentMarchingBand.numberOfBuses}</td>
					<td>${currentMarchingBand.hasColorGuard}</td>
				</tr>
			</c:forEach>
		</table>
		<br /> 
			<input type="submit"
			value="Add New Marching Band" name="doThisToMarchingBand"> <br /> <br /> 
			<input type="submit"
			value="Edit Selected Marching Band" name="doThisToMarchingBand"><br /> <br /> 
			<input type="submit" value="Delete Selected Marching Band"
			name="doThisToMarchingBand"><br /> <br /> 
	</form>
	<br />
	<a href="index.html">Return to Main Menu</a>
	
</body>
</html>