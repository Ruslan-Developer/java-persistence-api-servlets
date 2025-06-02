package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Este es un Servlet que nos sirve de controlador para manejar las acciones
	 * que permiten realizar las operaciones CRUD sobre los cursos. Cada accion es 
	 * un Servlet que se encarga de realizar una operacion especifica.
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		String url="menu.html";
		
		switch(op) {
			case "doAlta":
				request.getRequestDispatcher("AltaAction").include(request, response);
				url="menu.html";
				break;				
			case "doEliminar":
				request.getRequestDispatcher("EliminarAction").include(request, response);
				url="menu.html";
				break;			
			case "doActualizar":
				request.getRequestDispatcher("ActualizarAction").include(request, response);
				url="menu.html";
				break;	
			case "doRecuperar":
				request.getRequestDispatcher("RecuperarAction").include(request, response);
				url="curso.jsp";
				break;
			case "doRecuperarActualizar":
				request.getRequestDispatcher("RecuperarAction").include(request, response);
				url="cursoActualizar.jsp";
				break;
			case "toNuevo":
				url="nuevo.html";
				break;
			case "toActualizar":
				request.setAttribute("url", "Controller?op=doRecuperarActualizar");
				url="buscador.jsp";
				break;
			case "toRecuperar":
				//Se agrega un atributo al request para que el JSP pueda saber a que Servlet llamar mediante el atributo "url"
				//El JSP buscador.jsp tiene un requestScope que contiene el atributo "url" y lo usa para redirigir de nuevo al Servlet Controller
				//Cuando el usuario envía el formulario, se genera una petición POST a la URL almacenada en ese atributo -> "Controller?op=doRecuperar"
				// Esta petición POST regresa a tu servlet Controller, que procesa la solicitud según el parámetro "op", ejecutando la acción correspondiente.
				request.setAttribute("url", "Controller?op=doRecuperar");
				url="buscador.jsp";
				break;
			case "toEliminar":
				request.setAttribute("url", "Controller?op=doEliminar");
				url="buscador.jsp";
				break;
			case "toInicio":
				url="menu.html";
				break;
			}
			
		request.getRequestDispatcher(url).forward(request, response);	
	}

}
