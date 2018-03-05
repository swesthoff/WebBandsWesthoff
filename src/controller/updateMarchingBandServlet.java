package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.MarchingBand;

/**
 * Servlet implementation class updateMarchingBandServlet
 */
@WebServlet("/updateMarchingBandServlet")
public class updateMarchingBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateMarchingBandServlet() {
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
		MarchingBandHelper dao = new MarchingBandHelper();
		String typesOfProps = request.getParameter("typesOfProps");
		System.out.println(" to update  " + typesOfProps);
		
		Integer tempId = Integer.parseInt(request.getParameter("bandId"));
		System.out.println(" to update 2 " + tempId);
		MarchingBand marchingBandToUpdate = dao.searchForMarchingBandById(tempId);
		marchingBandToUpdate.setTypesOfProps(typesOfProps);
		System.out.println(" to update 3 " + tempId);
//		bandToUpdate.setNumberOfMembers(numberOfMembers);
		dao.updateMarchingBand(marchingBandToUpdate);
		getServletContext().getRequestDispatcher("/viewMarchingBandServlet").forward(request, response);
	}

}
