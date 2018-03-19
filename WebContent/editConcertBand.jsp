<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Concert Band</title>
</head>
<body>
	<form action="updateConcertBandServlet" method="post">
		Band Name: <input type="text" name="nameOfBand" value="${concertBandToEdit.nameOfBand }"> <br />
 		Band Location: <input type="text" name="locationOfBand"	value="${concertBandToEdit.locationOfBand }"> <br />
 		Number of Members: <input type="text" name="numberOfMembers"	value="${concertBandToEdit.numberOfMembers }"> <br />
 	
 		
 			Level Of Band <select name="levelOfBand">
		
		   <option value=1>Elementary</option>
         <option value=2>Junior High</option> 
             <option value=3>High School</option> 
		  </select>
		
		
		
		LEVEL OF BAND: <select name="levelOfBand1">
    <c:forEach items="${levelOfBand2}" var="levelOfBand2">
        <option value="${levelOfBand2}" ${levelOfBand2 == selectedLevelOfBand ? 'selected' : ''}>${levelOfBand2}</option>
    </c:forEach>
		</select>
		
	
	LEVEL: <select name='selectedLevelOfBand'>
    <option value="${selected}" selected>${selected}</option>
    <c:forEach items="${selectedLevelOfBand1}" var="selectedLevelOfBand">
        <c:if test="${selectedLevelOfBand != selected}">
            <option value="${selectedLevelOfBand}">${selectedLevelOfBand}</option>
        </c:if>
    </c:forEach>
</select>	
		
<!--			<select name='role'>
    <option value="${selected}" selected>${selected}</option>
    <c:forEach items="${roles}" var="role">
        <c:if test="${role != selected}">
            <option value="${role}">${role}</option>
        </c:if>
    </c:forEach>
</select>
	-->	
		
<!--		<select name="roleName">
    <c:forEach items="${roleNames}" var="role">
        <option value="${role}" ${role == selectedRole ? 'selected' : ''}>${role}</option>
    </c:forEach>
-->

</select>
		
		
 		<br />
	   <input	type="hidden" name="bandId" value="${concertBandToEdit.bandId }"> <br /><br />
		<input type="submit" value="Save Edited Concert Band">
	</form>
</body>
</html>