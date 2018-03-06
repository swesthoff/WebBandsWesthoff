<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateMarchingBandServlet" method="post">
		
		Band Name: <input type="text" name="nameOfBand" value="${marchingBandToEdit.nameOfBand }"> 
 		Band Location: <input type="text" name="locationOfBand"	value="${marchingBandToEdit.locationOfBand }"> 
		Type of Props: <input type="text" name="typesOfProps" value="${marchingBandToEdit.typesOfProps }"> 
 		 
	   
	   
	   <input	type="hidden" name="bandId" value="${marchingBandToEdit.bandId }"> <br />
		<input type="submit" value="Save Edited Marching Band">
	</form>
</body>
</html>