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
		CompetitionHelper pbh = new CompetitionHelper();
		request.setAttribute("allCompetition", pbh.showAllCompetitions());
		System.out.println("View Competition");
		if(pbh.showAllCompetitions().isEmpty()) {
		//	getServletContext().getRequestDispatcher("/addPepBand.html").forward(request, response);
			System.out.println("Competition - empty");
		}
		System.out.println("Competition -  2" + pbh.showAllCompetitions());
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
