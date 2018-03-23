<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="myStyleSheet.css">
<title>Edit Marching Band</title>
</head>
<body>
<h2> Edit Marching Band</h2>
<form action="updateMarchingBandServlet" method="post">
		
		Band Name: <input type="text" name="nameOfBand" value="${marchingBandToEdit.nameOfBand }"> <br />
 		Band Location: <input type="text" name="locationOfBand"	value="${marchingBandToEdit.locationOfBand }"> <br />
		Type of Props: <input type="text" name="typesOfProps" value="${marchingBandToEdit.typesOfProps }"> <br />
		
		Color Guard: <select name="hasColorGuard">
			<option value="false">No</option>
			<option value="true">Yes</option>
		</select>
		 <br />
	   
		
		
 		 Number of Members: <input type="text" name="numberOfMembers"	value="${marchingBandToEdit.numberOfMembers }"> <br />
 	
 		
 			Level Of Band <select name="levelOfBand">
		
		   <option value=1>Elementary</option>
         <option value=2>Junior High</option> 
             <option value=3>High School</option> 
		  </select>
	   
	   <br></br>
	   <input	type="hidden" name="bandId" value="${marchingBandToEdit.bandId }"> <br />
		<input type="submit" value="Save Edited Marching Band">
	 <br></br>
			<br><a href="index.html"> Back to Main Menu</a></br>
	</form>
</body>
</html>