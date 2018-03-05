package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewPepBandServlet
 */
@WebServlet("/viewPepBandServlet")
public class viewPepBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewPepBandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PepBandHelper pbh = new PepBandHelper();
		request.setAttribute("allPepBands", pbh.showAllPepBands());
		System.out.println("View pep Band 1");
		if(pbh.showAllPepBands().isEmpty()) {
			getServletContext().getRequestDispatcher("/addPepBand.html").forward(request, response);
			System.out.println("Pep Band - empty");
		}
		System.out.println("Mpep -  2" + pbh.showAllPepBands());
		getServletContext().getRequestDispatcher("/viewAllPepBand.jsp").forward(request, response);
		System.out.println("Pep - after");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
