package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.MarchingBand;

/**
 * Servlet implementation class updateMarchingBandServlet
 */
@WebServlet("/updateMarchingBandServlet")
public class updateMarchingBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateMarchingBandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MarchingBandHelper dao = new MarchingBandHelper();
		String nameOfBand = request.getParameter("nameOfBand");
		String locationOfBand = request.getParameter("locationOfBand");
	
		String typesOfProps = request.getParameter("typesOfProps");
	
		boolean hasColorGuard = Boolean.parseBoolean(request.getParameter("hasColorGuard"));
		System.out.println(" to update props " + typesOfProps + " name: " + nameOfBand + " location: " + locationOfBand);
		
		String stringBandId = request.getParameter("bandId");
		System.out.println(" to update3 " + stringBandId);
		String stringNumberOfMembers = request.getParameter("numberOfMembers");
		try { 
	        Integer.parseInt(stringNumberOfMembers); 
	    } catch(NumberFormatException e) { 
	    	getServletContext().getRequestDispatcher("/marchingBandNumericError.jsp").forward(request, response);
	    } catch(NullPointerException e) {
	    	getServletContext().getRequestDispatcher("/marchingBandNumericError.jsp").forward(request, response);
	    }
		Integer numberOfMembers = Integer.parseInt(request.getParameter("numberOfMembers"));
		Integer levelOfBand = Integer.parseInt(request.getParameter("levelOfBand"));
		
		Integer tempId = Integer.parseInt(request.getParameter("bandId"));
		System.out.println(" to update 2 " + tempId);
		MarchingBand marchingBandToUpdate = dao.searchForMarchingBandById(tempId);
		marchingBandToUpdate.setNameOfBand(nameOfBand);
		marchingBandToUpdate.setLocationOfBand(locationOfBand);
		
		marchingBandToUpdate.setTypesOfProps(typesOfProps);
		marchingBandToUpdate.setNumberOfMembers(numberOfMembers);
		marchingBandToUpdate.setLevelOfBand(levelOfBand);
		marchingBandToUpdate.setCostOfParticipation(numberOfMembers, levelOfBand);
		marchingBandToUpdate.setNumberOfBuses(typesOfProps,hasColorGuard);
		System.out.println(" to update 3 " + tempId);
//		bandToUpdate.setNumberOfMembers(numberOfMembers);
		dao.updateMarchingBand(marchingBandToUpdate);
		getServletContext().getRequestDispatcher("/viewMarchingBandServlet").forward(request, response);
	}

}
