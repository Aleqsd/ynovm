package ynovm.controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ynovm.modele.technique.ProfileException;
import ynovm.utilitaire.TypeStation;

/**
 * Servlet implementation class ValiderAjoutServlet
 */
@WebServlet("/validerajout")
public class ValiderAjoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValiderAjoutServlet() {
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
		String id = request.getParameter("id");
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String nom = request.getParameter("nom");
		String localisation = request.getParameter("localisation");
		String temperature = request.getParameter("temperature");
		String hygrometrie = request.getParameter("hygrometrie");
		String nebulosite = request.getParameter("nebulosite");
		String anemometrie = request.getParameter("anemometrie");
		String pluviometrie = request.getParameter("pluviometrie");
		String remarques = request.getParameter("remarques");
		String type = request.getParameter("type");
		
		
		try {
			Manager.getInstance().ajouter(Integer.parseInt(id), Integer.parseInt(x), Integer.parseInt(y), nom, localisation, Double.parseDouble(temperature),
					Double.parseDouble(hygrometrie), Integer.parseInt(nebulosite), Integer.parseInt(anemometrie), Integer.parseInt(pluviometrie),
					remarques, TypeStation.valueOf(type));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProfileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("message", "OK");
		
		response.sendRedirect("choice.jsp");
		//doGet(request, response);
	}

}
