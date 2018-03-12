<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Pep Band </title>
</head>
<body>
<form action="updatePepBandServlet" method="post">
	
	Band Name: <input type="text" name="nameOfBand" value="${pepBandToEdit.nameOfBand }"> <br />
 		Band Location: <input type="text" name="locationOfBand"	value="${pepBandToEdit.locationOfBand }"> <br />
	
		 Number of Members: <input type="text" name="numberOfMembers"	value="${pepBandToEdit.numberOfMembers }"> <br />
 	
 		
 			Level Of Band <select name="levelOfBand">
		
		   <option value=1>Elementary</option>
         <option value=2>Junior High</option> 
             <option value=3>High School</option> 
		  </select>
	   
	
		Playing Position: <select name="playingPosition">
		
		   <option value="Standing">Standing</option>
         <option value="Sitting">Sitting</option> 
		  </select><br />
		
 		 <select name='playingPosition'>
    <option value="${selected}" selected>${selected}</option>
    <c:forEach items="${playingPosition}" var="playingPosition">
        <c:if test="${playingPosition != selected}">
            <option value="${playingPosition}">${playingPosition}</option>
        </c:if>
    </c:forEach>
</select><br />
 		 
 		 
 		 
 		 
 		 
	     Type of Event: <select name="eventId">
         <option value="1">Girl's Basketball</option>
         <option value="2">Boy's Basketball</option> 
         <option value="3">Football</option>
         <option value="4">Wrestling</option>
         <option value="5">Homecoming</option>
         <option value="6">District Finals</option>
         <option value="7">Red Ribbon Week</option>
     
        </select><br />
	   <br />
	   <input	type="hidden" name="bandId" value="${pepBandToEdit.bandId }"> <br />
		<input type="submit" value="Edit Selected Pep Band">
	</form>
</body>
</html>