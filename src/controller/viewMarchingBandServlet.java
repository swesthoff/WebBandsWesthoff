package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewMarchingBandServlet
 */
@WebServlet("/viewMarchingBandServlet")
public class viewMarchingBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewMarchingBandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MarchingBandHelper mbh = new MarchingBandHelper();
		request.setAttribute("allMarchingBands", mbh.showAllMarchingBands());
		System.out.println("View Marching Band 1");
		if(mbh.showAllMarchingBands().isEmpty()) {
			getServletContext().getRequestDispatcher("/addMarchingBand.html").forward(request, response);
			System.out.println("Marching Band - empty");
		}
		System.out.println("Marching -  2" + mbh.showAllMarchingBands());
		getServletContext().getRequestDispatcher("/viewMarchingBands.jsp").forward(request, response);
		System.out.println("Marching - after");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
