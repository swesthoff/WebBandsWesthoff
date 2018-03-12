package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.MarchingBand;

/**
 * Servlet implementation class addMarchingBandServlet
 */
@WebServlet("/addMarchingBandServlet")
public class addMarchingBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addMarchingBandServlet() {
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
		
		String nameOfBand = request.getParameter("nameOfBand");
		System.out.println("Name of Band: " + nameOfBand);
		
		String stringNumberOfMembers = request.getParameter("numberOfMembers");
		System.out.println("String nmbr of mumber: " + stringNumberOfMembers);
		
		try { 
	        Integer.parseInt(stringNumberOfMembers); 
	    } catch(NumberFormatException e) { 
	    	getServletContext().getRequestDispatcher("/marchingBandNumericError.jsp").forward(request, response);
	    } catch(NullPointerException e) {
	    	getServletContext().getRequestDispatcher("/marchingBandNumericError.jsp").forward(request, response);
	    }
		int numberOfMembers = Integer.valueOf(stringNumberOfMembers);
		String locationOfBand = request.getParameter("locationOfBand");
		System.out.println("Location: " + locationOfBand);
//		String stringCostOfParticipation = request.getParameter("stringCostOfParticipation");
//		double costOfParticipation = Double.valueOf(stringCostOfParticipation);
		String stringLevelOfBand = request.getParameter("levelOfBand");
		System.out.println("Level: " + stringLevelOfBand);
		int levelOfBand = Integer.valueOf(stringLevelOfBand);
		
		
		String stringHasProps = request.getParameter("hasProps");
		System.out.println("Has Props: " + stringHasProps);
		boolean hasProps = Boolean.getBoolean(stringHasProps); 
		
		
		String typesOfProps = request.getParameter("typesOfProps");
		
//		if (hasProps == "2") {
//			String typesOfProps = request.getParameter("typesOfProps");
//		}else {
//			String typesOfProps = " ";
//		}
		
		String stringHasColorGuard = request.getParameter("hasColorGuard");
		System.out.println("has color guard: " + stringHasColorGuard);
		boolean hasColorGuard = Boolean.getBoolean(stringHasColorGuard); 
//		String stringCostOfParticipation = request.getParameter("stringCostOfParticipation");
//		double costOfParticipation = Double.valueOf(stringCostOfParticipation);
	//	int levelOfBand = Integer.valueOf(stringLevelOfBand);
	//	String bandType = request.getParameter("bandType");
		
		
	
		MarchingBand marchingBand = new MarchingBand(numberOfMembers, nameOfBand, locationOfBand, levelOfBand,hasProps, typesOfProps, hasColorGuard);
		MarchingBandHelper dao = new MarchingBandHelper();

		dao.insertMarchingBand(marchingBand);

		getServletContext().getRequestDispatcher("/addMarchingBand.html").forward(request, response);
	}

}
