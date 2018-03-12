<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="model.Bands"%>
<%@ page import="model.PepBand"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="myStyleSheet.css">
<title>Pep Band</title>
<style>
table, td, th {
	border: 1px solid black;
	border-collapse: separate;
	border-spacing: 2px;
	padding: 2px;
}

</style>
</head>
<body>
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSIvuRNXGuo1wGw-Cp4RtCkbf2l2s1lqr3Ku04bPjQwBLlxCbvr7A"> 
<h2> View List of Pep Bands</h2>
	<form method="post" action="editPepBandServlet">
		<table>
			<tr>
				<th> </th>
				<th>Name of Band</th>
				<th>Number of Members</th>
				<th>Location Of Band</th>
				<th>Cost of Participation</th>
				<th>Level of Band</th>
				<th>Event Name</th>
				<th>Playing Position</th>
				
				

			</tr>

			<c:forEach items="${requestScope.allPepBands}" var="currentPepBand">
				<tr>
					<td><input type="radio" name="bandId"
						value="${currentPepBand.bandId}"></td>
					<td>${currentPepBand.nameOfBand}</td>
					<td>${currentPepBand.numberOfMembers}</td>
					<td>${currentPepBand.locationOfBand}</td>
					<td>
					<fmt:formatNumber value="${currentPepBand.costOfParticipation}" type="currency" />
					</td>
					<td>${currentPepBand.getLevelOfBand()}</td>
					<td>${currentPepBand.getEventName()}</td>
					<td>${currentPepBand.playingPosition}</td>
				
				</tr>
			</c:forEach>
		</table>
		<br />  
			 
			<input type="submit"
			value="Add New Pep Band" name="doThisToPepBand"><br /> <br />
			<input type="submit"
			value="Edit Selected Pep Band" name="doThisToPepBand">
			<br /> <br />
<input type="submit" value="Delete Selected Pep Band"
			name="doThisToPepBand"><br /> <br />
			
	</form>
	<br />
	<a href="index.html">Return to Main Menu</a>
	


</body>
</html>