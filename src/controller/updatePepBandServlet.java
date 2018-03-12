package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.PepBand;

/**
 * Servlet implementation class updatePepBandServlet
 */
@WebServlet("/updatePepBandServlet")
public class updatePepBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatePepBandServlet() {
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
		PepBandHelper dao = new PepBandHelper();
		
		String nameOfBand = request.getParameter("nameOfBand");
		String locationOfBand = request.getParameter("locationOfBand");
		
		String playingPosition = request.getParameter("playingPosition");
		System.out.println(" to update  " + playingPosition);
		Integer eventId = Integer.parseInt(request.getParameter("eventId"));
		
		String stringNumberOfMembers = request.getParameter("numberOfMembers");
		System.out.println("String nmbr of mumber: " + stringNumberOfMembers);
		
		try { 
	        Integer.parseInt(stringNumberOfMembers); 
	    } catch(NumberFormatException e) { 
	    	getServletContext().getRequestDispatcher("/pepBandNumericError.jsp").forward(request, response);
	    } catch(NullPointerException e) {
	    	getServletContext().getRequestDispatcher("/pepBandNumericError.jsp").forward(request, response);
	    }
		int numberOfMembers = Integer.valueOf(stringNumberOfMembers);
		
		Integer levelOfBand = Integer.parseInt(request.getParameter("levelOfBand"));
		Integer tempId = Integer.parseInt(request.getParameter("bandId"));
		System.out.println(" to update 2 " + tempId);
		PepBand pepBandToUpdate = dao.searchForPepBandById(tempId);
	//	pepBandToUpdate.setEventId(eventId);
		System.out.println(" to update 3 " + tempId);
//		bandToUpdate.setNumberOfMembers(numberOfMembers);
		pepBandToUpdate.setPlayingPosition(playingPosition);
		pepBandToUpdate.setEventId(eventId);
		pepBandToUpdate.setNameOfBand(nameOfBand);
		pepBandToUpdate.setLocationOfBand(locationOfBand);
		pepBandToUpdate.setNumberOfMembers(numberOfMembers);
		pepBandToUpdate.setLevelOfBand(levelOfBand);
		pepBandToUpdate.setCostOfParticipation(numberOfMembers, levelOfBand);
		dao.updatePepBand(pepBandToUpdate);
		getServletContext().getRequestDispatcher("/viewPepBandServlet").forward(request, response);
	}

}
