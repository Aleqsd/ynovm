package ynovm.controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ynovm.modele.technique.ProfileException;
import ynovm.modele.technique.StationException;

/**
 * Servlet implementation class SupprimerServlet
 */
//@WebServlet({ "SupprimerServlet", "supprimer" })
public class SupprimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * HttpServlet#HttpServlet()
	 */
	public SupprimerServlet() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("station");
		
		try {
			Manager.getInstance().supprimer(Integer.parseInt(id));
			request.setAttribute("message", "OK");
		} catch (StationException | NumberFormatException | ProfileException e) {
			request.setAttribute("message", e.getMessage());
		}		
		response.sendRedirect("choice.jsp");
}
}
