<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="model.Bands"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<title>View All Bands</title>
<style>
table, td, th {


	border: 1px solid black;
	border-collapse: separate;
	border-spacing: 2px;
	padding: 2px;
}
h2 {
  color: green;
  
}  

</style>
</head>
<body>
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSIDkTGd_S3ZmR2iWlJIDM5vUg7xALhA2fmZXqm2bvJu28xgLjg" align="middle">
<h2> View List of Concert Bands</h2>
	<form method="post" action="editConcertBandServlet">
		<table>
			<tr>
				<th> </th>
				<th>Name of Band</th>
				<th>Number of Members</th>
				<th>Location Of Band</th>
				<th>Cost of Participation</th>
				<th>Level of Band</th>

			</tr>

			<c:forEach items="${requestScope.allBands}" var="currentBand">
				<tr>
					<td><input type="radio" name="bandId"
						value="${currentBand.bandId}"></td>
					<td>${currentBand.nameOfBand}</td>
					<td>${currentBand.numberOfMembers}</td>
					<td>${currentBand.locationOfBand}</td>
					<td>
					<fmt:formatNumber value="${currentBand.costOfParticipation}" type="currency" />
					</td>
					<td>${currentBand.getLevelOfBand()}</td>
				</tr>
			</c:forEach>
		</table>
		<br /> 
			<input type="submit"
			value="Add New Concert Band" name="doThisToConcertBand"> <br /> <br /> 
			<input type="submit"
			value="Edit Selected Concert Band" name="doThisToConcertBand"> <br /> <br /> 
			<input type="submit" value="Delete Selected Concert Band"
			name="doThisToConcertBand"><br /> <br /> 
	</form>
	<br />
	<a href="index.html">Return to Main Menu</a>
	
</body>
</html>