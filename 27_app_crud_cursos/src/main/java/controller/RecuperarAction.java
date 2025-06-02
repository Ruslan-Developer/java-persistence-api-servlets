package controller;

import java.io.IOException;

import entidades.Curso;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.service.CursosService;

/**
 * Servlet implementation class RecuperarAction
 */
@WebServlet("/RecuperarAction")
public class RecuperarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CursosService service = new CursosService();
		Curso curso = service.buscarCurso(Integer.parseInt(request.getParameter("idCurso")));
		if(curso != null) {
			request.setAttribute("curso", curso); // Guarda el curso recuperado en el request
		} else {
			request.setAttribute("curso", new Curso()); //Se crea un curso vacío si no se encuentra el curso solicitado
		}
		
	}

}
