<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Pep Band </title>
</head>
<body>
<form action="updatePepBandServlet" method="post">
		Playing Position: <input type="text" name="playingPosition" value="${pepBandToEdit.playingPosition }"> 
 		 
	     Type of Event: <select name="eventId">
         <option value="1">Girl's Basketball</option>
         <option value="2">Boy's Basketball</option> 
         <option value="3">Football</option>
         <option value="4">Wrestling</option>
         <option value="5">Homecoming</option>
         <option value="6">District Finals</option>
         <option value="7">Red Ribbon Week</option>
     
        </select>
	   
	   <input	type="hidden" name="bandId" value="${pepBandToEdit.bandId }"> <br />
		<input type="submit" value="Edit Selected Pep Band">
	</form>
</body>
</html>