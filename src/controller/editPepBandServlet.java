package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PepBand;



/**
 * Servlet implementation class editPepBandServlet
 */
@WebServlet("/editPepBandServlet")
public class editPepBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPepBandServlet() {
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
		String act = request.getParameter("doThisToPepBand");
		System.out.println("in Edit Pep Band Servlet: " + act);
		PepBandHelper pbh = new PepBandHelper();


		if (act == null) {
			getServletContext().getRequestDispatcher("/viewPepBandServlet").forward(request, response);
		} else if (act.equals("Edit Selected Pep Band")) {
			System.out.println("in edit selected band");

			String stringBandId = request.getParameter("bandId");
			System.out.println(" pepband to edit :: " + stringBandId);
			
			Integer tempId = Integer.parseInt(request.getParameter("bandId"));
			System.out.println("ParseINT: " + tempId);
			PepBand bandToEdit = pbh.searchForPepBandById(tempId);
			System.out.println("Pep Band to Edit: " + bandToEdit);
			request.setAttribute("pepBandToEdit", bandToEdit);
			getServletContext().getRequestDispatcher("/editPepBand.jsp").forward(request, response);
		} else if (act.equals("Delete Selected Pep Band")) {
			Integer tempId = Integer.parseInt(request.getParameter("bandId"));
			PepBand pepBandToDelete = pbh.searchForPepBandById(tempId);

			System.out.println(" to delete:  " + pepBandToDelete);

			pbh.deletePepBand(pepBandToDelete);
			getServletContext().getRequestDispatcher("/viewPepBandServlet").forward(request, response);

		} else if (act.equals("Add New Pep Band")) {
			System.out.println(" Add New Pep Band! ");

			getServletContext().getRequestDispatcher("/addPepBand.html").forward(request, response);
	}

	}
}
