package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bands;


/**
 * Servlet implementation class addConcertBandServlet
 */
@WebServlet("/addConcertBandServlet")
public class addConcertBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addConcertBandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

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
	//	String bandType = request.getParameter("bandType");
	
		
//		String stringValue = request.getParameter("value");
//		double value = Double.valueOf(stringValue);
//		System.out.println("in doPost - addArtworkItemServlet " + value);
//		System.out.println("artistname: " + artistName);
//		System.out.println("Title: " + title);
//		System.out.println("media: " + media);
//		System.out.println("year: " + year);
		
		Bands band = new Bands(numberOfMembers, nameOfBand, locationOfBand, levelOfBand);
		BandHelper dao = new BandHelper();

		dao.insertBands(band);

//		dao.insertItem(team);


		getServletContext().getRequestDispatcher("/addConcertBand.html").forward(request, response);
	}

}
