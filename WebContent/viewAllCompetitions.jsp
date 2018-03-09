<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Competitions</title>
</head>
<body>
	<form method="post" action="editCompetitionServlet">
		<table>
		<tr> 
			<th> </th>
			<th>Competition Name</th>
			<th>Band ID</th> 
		</tr>
			<c:forEach items="${requestScope.allCompetitions}" var="currentitem">
				<tr>
					<td><input type="radio" name="competitionId" value="${currentitem.competitionId}"></td>
					<td>${current.getCompetitionName()}</td>
					<td>${currentitem.getBandName()}</td> 
				</tr>
			</c:forEach>
		</table>
		<br /> <input type="submit" value="Add Band to Competition"
			name="doThisToCompetition"><br /> <br />
	</form>
	<br />
	<a href="index.html">Main Menu</a>
</body>
</html>