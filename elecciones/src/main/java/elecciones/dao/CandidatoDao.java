package elecciones.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import elecciones.entities.Candidato;
import elecciones.util.Conexion;

import elecciones.entities.Candidato;
import elecciones.util.Conexion;
//no me importa ahorita
public class CandidatoDao {
private Conexion conexion;
	
	public CandidatoDao() {
		this.conexion = Conexion.getConexion();
	}
	
	
	public void  insert(Candidato c) {	
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	tx.begin();
	 	
	 	em.persist(c);
	 	
	 	tx.commit();
	}
	
	public void  update(Candidato c) {
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	tx.begin();
	 	
	 	em.merge(c);
	 	
	 	tx.commit();
	} 
	
	public Candidato  get(int id) {
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	Candidato c = em.find(Candidato.class, id);
	 	return c;
	}
	
	public void delete(int id) {
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	Candidato c = em.find(Candidato.class, id);
	 	tx.begin();
	 	em.remove(c);
	 	tx.commit();
	}
	
	public List<Candidato> list(){
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	List<Candidato> listCandidatos = em.createQuery("select c from candidato").getResultList();
		return listCandidatos;
	}
	
}

