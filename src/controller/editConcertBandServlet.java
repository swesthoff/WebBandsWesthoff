package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Bands;


/**
 * Servlet implementation class editConcertBandServlet
 */
@WebServlet("/editConcertBandServlet")
public class editConcertBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editConcertBandServlet() {
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
		String act = request.getParameter("doThisToConcertBand");
		 System.out.println("in Edit Concert Band Servlet: " + act);
		BandHelper bh = new BandHelper();
//		PlayerHelper ph = new PlayerHelper();
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewConcertBandServlet").forward(request, response);
		} else if (act.equals("Edit Selected Concert Band")) {
			 System.out.println("in edit selected band");
			
			 Integer tempId = Integer.parseInt(request.getParameter("bandId"));
			 System.out.println("ParseINT: " + tempId);
			 Bands bandToEdit = bh.searchForBandById(tempId);
		 System.out.println("Concert Band to Edit: " + bandToEdit);
			request.setAttribute("concertBandToEdit", bandToEdit);
			getServletContext().getRequestDispatcher("/editConcertBand.jsp").forward(request, response);
		} else if (act.equals("Delete Selected Concert Band")) {
			Integer tempId = Integer.parseInt(request.getParameter("bandId"));
			Bands bandToDelete = bh.searchForBandById(tempId);

			System.out.println(" to delete: before all players on team " + bandToDelete);
  
           bh.deleteBand(bandToDelete);
			getServletContext().getRequestDispatcher("/viewConcertBandServlet").forward(request, response);

		} else if (act.equals("Add New Concert Band")) {
			System.out.println(" Add New Cnocert Band " );
			  
			getServletContext().getRequestDispatcher("/addConcertBand.html").forward(request, response);
		}
	}

}
