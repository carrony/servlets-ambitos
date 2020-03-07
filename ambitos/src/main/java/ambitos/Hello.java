package ambitos;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cuenta")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();


		Contador peticion = (Contador) request.getAttribute("peticion");
		if (peticion==null) {
			peticion = new Contador("Petición");
			request.setAttribute("peticion", peticion);
		}
		peticion.incContador();
		out.println("<h2>"+peticion+"</h2>");
		
		Contador sesion = (Contador) request.getSession().getAttribute("sesion");
		if (sesion==null) {
			sesion = new Contador("Sesión");
			request.getSession().setAttribute("sesion", sesion);
		}
		sesion.incContador();
		out.println("<h2>"+sesion+"</h2>");
		
		Contador aplicacion = (Contador) getServletContext().getAttribute("aplicacion");
		if (aplicacion==null) {
			aplicacion = new Contador("Aplicación");
			getServletContext().setAttribute("aplicacion", aplicacion);
		}
		aplicacion.incContador();
		out.println("<h2>"+aplicacion+"</h2>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
