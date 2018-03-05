package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class viewConcertBandServlet
 */
@WebServlet("/viewConcertBandServlet")
public class viewConcertBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewConcertBandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BandHelper bh = new BandHelper();
		request.setAttribute("allBands", bh.showAllBands());
		System.out.println("viewallBandsServlet - allBands 1");
		if(bh.showAllBands().isEmpty()) {
			getServletContext().getRequestDispatcher("/addConcertBand.html").forward(request, response);
			System.out.println("viewallBandsServlet - allBands - empty");
		}
		System.out.println("viewConcertBandServlet - allTeams 2" + bh.showAllBands());
		getServletContext().getRequestDispatcher("/viewAllBands.jsp").forward(request, response);
		System.out.println("viewConcertBandServlet - after");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
