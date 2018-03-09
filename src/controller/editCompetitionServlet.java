package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import model.Competition;

/**
 * Servlet implementation class editCompetitionServlet
 */
@WebServlet("/editCompetitionServlet")
public class editCompetitionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editCompetitionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String act = request.getParameter("doThisToCompetition");
		System.out.println("in Edit Competition Servlet: " + act);
	//	CompetitionHelper pbh = new CompetitionHelper();

		if (act == null) {
			getServletContext().getRequestDispatcher("/viewCompetitionServlet").forward(request, response);
			// } else if (act.equals("Edit Selected Pep Band")) {
			// System.out.println("in edit selected band");
			//
			// String stringBandId = request.getParameter("bandId");
			// System.out.println(" pepband to edit :: " + stringBandId);
			//
			// Integer tempId = Integer.parseInt(request.getParameter("bandId"));
			// System.out.println("ParseINT: " + tempId);
			// PepBand bandToEdit = pbh.searchForPepBandById(tempId);
			// System.out.println("Pep Band to Edit: " + bandToEdit);
			// request.setAttribute("pepBandToEdit", bandToEdit);
			// getServletContext().getRequestDispatcher("/editPepBand.jsp").forward(request,
			// response);
			// } else if (act.equals("Delete Selected Competition")) {
			// Integer tempId = Integer.parseInt(request.getParameter("bandId"));
			// Competition competitionToDelete = pbh.searchForCompeitionById(tempId);
			//
			// System.out.println(" to delete: " + competitionToDelete);
			//
			// pbh.deleteCompetition(competitionToDelete);
			// getServletContext().getRequestDispatcher("/viewCompetitionServlet").forward(request,
			// response);

		} else if (act.equals("Add Band to Competition")) {
			System.out.println(" Add New Competition! ");

			getServletContext().getRequestDispatcher("/addCompetition.html").forward(request, response);
		}

	}
}
