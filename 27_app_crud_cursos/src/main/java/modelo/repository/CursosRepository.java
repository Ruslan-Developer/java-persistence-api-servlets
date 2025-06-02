package modelo.repository;

import entidades.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CursosRepository {
	
	EntityManager em; // Interfaz principal de JPA para interactuar con la base de datos.
	
	public CursosRepository() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursosPU");
		em = emf.createEntityManager();
	}
	
	/**
	 * Usamos el JPA Pesistence API con el fin de guardar un curso en la base de datos.
	 * Se establece una transaccion para garantizar la integridad de los datos al ser
	 * una operación de escritura.
	 * @param curso
	 */	
	public void altaCurso(Curso curso) {
		EntityTransaction tx = em.getTransaction();
		tx.begin(); // Inicia la transacción
		em.persist(curso); // Guarda el curso en BBDD	
		tx.commit(); // Confirma la transacción
	}
	
	public Curso buscarCursoPorId(int idCurso) {
		return em.find(Curso.class, idCurso); // Busca un curso por su ID
	}
	
	public void actualizarCurso(Curso curso) {
		EntityTransaction tx = em.getTransaction();
		tx.begin(); // Inicia la transacción
		em.merge(curso); // Actualiza el curso en BBDD
		tx.commit(); // Confirma la transacción
	}
	
	public void eliminarCurso(Curso curso) {
		EntityTransaction tx = em.getTransaction();
		tx.begin(); // Inicia la transacción
		em.remove(curso);
		tx.commit(); // Confirma la transacción
	}
}
