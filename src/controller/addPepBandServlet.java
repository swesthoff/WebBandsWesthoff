package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.PepBand;

/**
 * Servlet implementation class addPepBandServlet
 */
@WebServlet("/addPepBandServlet")
public class addPepBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPepBandServlet() {
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
		int numberOfMembers = Integer.valueOf(stringNumberOfMembers);
		
		
		String locationOfBand = request.getParameter("locationOfBand");
		System.out.println("Location: " + locationOfBand);
//		String stringCostOfParticipation = request.getParameter("stringCostOfParticipation");
//		double costOfParticipation = Double.valueOf(stringCostOfParticipation);
		String stringLevelOfBand = request.getParameter("levelOfBand");
		System.out.println("Level: " + stringLevelOfBand);
		int levelOfBand = Integer.valueOf(stringLevelOfBand);
		
		
		String stringEventId = request.getParameter("eventId");
		System.out.println("event id: " + stringEventId);
		int eventId = Integer.valueOf(stringEventId);
		
		
		String playingPosition = request.getParameter("playingPosition");
		

	
		
	
		PepBand pepBand = new PepBand(numberOfMembers, nameOfBand, locationOfBand, levelOfBand, eventId, playingPosition);
		PepBandHelper dao = new PepBandHelper();

		dao.insertPepBand(pepBand);

		getServletContext().getRequestDispatcher("/addPepBand.html").forward(request, response);
	}

}
