package elecciones.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import elecciones.entities.Votante;
import elecciones.util.Conexion;

public class VotanteDao {

private Conexion conexion;
	
	public VotanteDao() {
		this.conexion = Conexion.getConexion();
	}
	
	
	public void  insert(Votante v) {	
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	tx.begin();
	 	
	 	em.persist(v);
	 	
	 	tx.commit();
	 	tx=null;
	}
	
	public void  update(Votante v) {
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	tx.begin();
	 	
	 	em.merge(v);
	 	
	 	tx.commit();
	} 
	
	public Votante  get(int id) {
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
		Votante v = em.find(Votante.class, id);
	 	return v;
	}
	
	public void delete(int id) {
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	Votante v = em.find(Votante.class, id);
	 	tx.begin();
	 	em.remove(v);
	 	tx.commit();
	}
	
	public List<Votante> list(){
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	List<Votante> listVotantes = em.createQuery("select v from Votante as v").getResultList();
		return listVotantes;
	}
	

}
