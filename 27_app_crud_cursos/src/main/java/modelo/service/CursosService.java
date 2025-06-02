package modelo.service;

import entidades.Curso;
import modelo.repository.CursosRepository;

public class CursosService {
	
	CursosRepository repository;
	
	public CursosService() {
		repository = new CursosRepository(); // Inicializa el repositorio de cursos
	}
	
	public void nuevoCurso(Curso curso) {
		repository.altaCurso(curso);
	}
	
	public Curso buscarCurso(int idCurso) {		
		return repository.buscarCursoPorId(idCurso);
	}
	
	public void actualizarCurso(Curso curso) {
		if(repository.buscarCursoPorId(curso.getIdCurso()) != null) {
			repository.actualizarCurso(curso);			
		}		
	}
	
	public void eliminarCurso(int idCurso) {
		Curso curso = repository.buscarCursoPorId(idCurso);
		if(curso != null) {
			repository.eliminarCurso(curso);
		}
	}
}
