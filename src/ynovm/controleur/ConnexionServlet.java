package ynovm.controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ynovm.modele.technique.ConnexionException;
import ynovm.service.Compte;
import ynovm.stockage.DaoCompte;
 
/**
 * Servlet implementation class ConnexionServlet
 */
//@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnexionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
try {
			
			Manager m = Manager.getInstance();
			
			try {
				m.connexion(request.getParameter("id"),request.getParameter("mdp"));
				
			}catch(ConnexionException e) {
				e.printStackTrace();
				request.setAttribute("authentification", "Compte ou mot de passe incorrect");
				request.getRequestDispatcher("connexion.jsp").forward(request, response);
				//response.sendRedirect("invalidLogin.jsp"); //TODO : error page
				return;
			}
			Compte c = m.getUtilisateur();
			HttpSession session = request.getSession(true);
			session.setAttribute("currentSessionUser", c);
			response.sendRedirect("choice.jsp");
}

		catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
