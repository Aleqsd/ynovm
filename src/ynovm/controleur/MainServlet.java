package ynovm.controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ynovm.modele.technique.ProfileException;
import ynovm.modele.technique.StationException;
import ynovm.service.StationPOJO;

/**
 * Servlet implementation class MainServlet
 */
//@WebServlet({ "MainServlet", "main" })
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		// TODO Auto-generated constructor stub
		super();
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
		
		
		List<StationPOJO> tmp = null;
		tmp = Manager.getInstance().getPOJOs();
		request.setAttribute("modele", tmp);
		
		
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		
		if ("redemarrer".equals(action)) {
			
			try {
				Manager.getInstance().redemarrer(Integer.parseInt(id));
				request.setAttribute("message", "OK");
			} catch (StationException | NumberFormatException | ProfileException e) {
				request.setAttribute("message", e.getMessage());
			}
		} else if ("supprimer".equals(action)) {
			try {
				Manager.getInstance().supprimer(Integer.parseInt(id));
				request.setAttribute("message", "OK");
			} catch (StationException e) {
				request.setAttribute("message", e.getMessage());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ProfileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		request.getRequestDispatcher("tableau.jsp").forward(request, response);
		request.getRequestDispatcher("mappemonde.jsp").forward(request, response);
	}

}
