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
 * Servlet implementation class AltaAction
 */
@WebServlet("/AltaAction")
public class AltaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CursosService service = new CursosService();
		Curso curso = new Curso(0, 
				request.getParameter("denominacion"),
				Integer.parseInt(request.getParameter("duracion")),
				Double.parseDouble(request.getParameter("precio")));
		service.nuevoCurso(curso); // Llama al servicio para guardar el curso
	}

}
