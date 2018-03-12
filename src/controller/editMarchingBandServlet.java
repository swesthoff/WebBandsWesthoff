package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MarchingBand;

/**
 * Servlet implementation class editMarchingBandServlet
 */
@WebServlet("/editMarchingBandServlet")
public class editMarchingBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editMarchingBandServlet() {
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
		String act = request.getParameter("doThisToMarchingBand");
		System.out.println("in Edit Marching Band Servlet: " + act);
		MarchingBandHelper mbh = new MarchingBandHelper();
		// PlayerHelper ph = new PlayerHelper();

		if (act == null) {
			getServletContext().getRequestDispatcher("/viewMarchingBandServlet").forward(request, response);
		} else if (act.equals("Edit Selected Marching Band")) {
			System.out.println("in edit selected band");
			
			String stringBandId = request.getParameter("bandId");
			try { 
		        Integer.parseInt(stringBandId); 
		    } catch(NumberFormatException e) { 
		    	getServletContext().getRequestDispatcher("/marchingBandNoBandIdError.jsp").forward(request, response);
		    } catch(NullPointerException e) {
		    	getServletContext().getRequestDispatcher("/marchingBandNoBandIdError.jsp").forward(request, response);
		    }
			Integer tempId = Integer.parseInt(request.getParameter("bandId"));
			System.out.println("ParseINT: " + tempId);
			MarchingBand bandToEdit = mbh.searchForMarchingBandById(tempId);
			System.out.println("Marching Band to Edit: " + bandToEdit);
			request.setAttribute("marchingBandToEdit", bandToEdit);
			getServletContext().getRequestDispatcher("/editMarchingBand.jsp").forward(request, response);
		} else if (act.equals("Delete Selected Marching Band")) {
			String stringBandId = request.getParameter("bandId");
			try { 
		        Integer.parseInt(stringBandId); 
		    } catch(NumberFormatException e) { 
		    	getServletContext().getRequestDispatcher("/marchingBandNoBandIdError.jsp").forward(request, response);
		    } catch(NullPointerException e) {
		    	getServletContext().getRequestDispatcher("/marchingBandNoBandIdError.jsp").forward(request, response);
		    }
			
			Integer tempId = Integer.parseInt(request.getParameter("bandId"));
			MarchingBand marchingBandToDelete = mbh.searchForMarchingBandById(tempId);

			System.out.println(" to delete: before all players on team " + marchingBandToDelete);

			mbh.deleteMarchingBand(marchingBandToDelete);
			getServletContext().getRequestDispatcher("/viewMarchingBandServlet").forward(request, response);

		} else if (act.equals("Add New Marching Band")) {
			System.out.println(" Add New Marching Band ");

			getServletContext().getRequestDispatcher("/addMarchingBand.html").forward(request, response);
		}
	}
}
