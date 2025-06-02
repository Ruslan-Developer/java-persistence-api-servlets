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
 * Esto es un Servlet que hace de intermediario entre la vista y el modelo.
 */
@WebServlet("/ActualizarAction")
public class ActualizarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CursosService service = new CursosService();
		Curso curso = service.buscarCurso(Integer.parseInt(request.getParameter("idCurso")));
		if (curso != null) {
			curso.setDenominacion(request.getParameter("denominacion"));
			curso.setDuracion(Integer.parseInt(request.getParameter("duracion")));
			curso.setPrecio(Double.parseDouble(request.getParameter("precio")));
			service.actualizarCurso(curso); // Llama al servicio para actualizar el curso
		}
	}

}
