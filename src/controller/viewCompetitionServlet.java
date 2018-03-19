package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewCompetitionServlet
 */
@WebServlet("/viewCompetitionServlet")
public class viewCompetitionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewCompetitionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CompetitionHelper ch = new CompetitionHelper();
		request.setAttribute("allCompetitions", ch.showAllCompetitions());
		System.out.println("View Competition before IF"  );
		if(ch.showAllCompetitions().isEmpty()) {
			System.out.println("Competition - empty!!!");
		//	getServletContext().getRequestDispatcher("/addCompetition.html").forward(request, response);
			
		}
		
		BandHelper bh = new BandHelper();
		request.setAttribute("allMarchingBands", bh.showAllMarchingBands());
//		request.setAttribute("allPartBands", bh.showAllPartBands());

		System.out.println("View Competition search for band name PART BANDS"  );
	//	if(bh.showAllPartBands().isEmpty()) {
		if(bh.showAllMarchingBands().isEmpty()) {
				
			System.out.println("Competition - band name empty!!!");
			
		}
		
		
		System.out.println("Competition -  2" + ch.showAllCompetitions());
		System.out.println("Competition -  search for 2" + bh.showAllMarchingBands());
		//System.out.println("Competition -  search for 2" + bh.showAllPartBands());
		
		getServletContext().getRequestDispatcher("/viewAllCompetitions.jsp").forward(request, response);
		System.out.println("Competition - after");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
