package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bands;


/**
 * Servlet implementation class updateConcertBandServlet
 */
@WebServlet("/updateConcertBandServlet")
public class updateConcertBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateConcertBandServlet() {
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
		BandHelper dao = new BandHelper();
		String nameOfBand = request.getParameter("nameOfBand");
		String locationOfBand = request.getParameter("locationOfBand");
		String stringNumberOfMembers = request.getParameter("numberOfMembers");
//		System.out.println("String nmbr of mumber: " + stringNumberOfMembers);
		try { 
	        Integer.parseInt(stringNumberOfMembers); 
	    } catch(NumberFormatException e) { 
	    	getServletContext().getRequestDispatcher("/concertBandNumericError.jsp").forward(request, response);
	    } catch(NullPointerException e) {
	    	getServletContext().getRequestDispatcher("/concertBandNumericError.jsp").forward(request, response);
	    }
		int numberOfMembers = Integer.valueOf(stringNumberOfMembers);
	//	Integer numberOfMembers = Integer.parseInt(request.getParameter("numberOfMembers"));
		Integer levelOfBand = Integer.parseInt(request.getParameter("levelOfBand"));
	//	String levelOfBand = request.getParameter("levelOfBand");
		Integer tempId = Integer.parseInt(request.getParameter("bandId"));
		Bands bandToUpdate = dao.searchForBandById(tempId);
		
		bandToUpdate.setNameOfBand(nameOfBand);
		bandToUpdate.setLocationOfBand(locationOfBand);
		bandToUpdate.setNumberOfMembers(numberOfMembers);
		bandToUpdate.setLevelOfBand(levelOfBand);
		bandToUpdate.setCostOfParticipation(numberOfMembers, levelOfBand);
//		bandToUpdate.setNumberOfMembers(numberOfMembers);
		dao.updateBand(bandToUpdate);
		getServletContext().getRequestDispatcher("/viewConcertBandServlet").forward(request, response);
	}

}
