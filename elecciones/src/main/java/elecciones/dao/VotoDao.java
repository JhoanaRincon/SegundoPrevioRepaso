package elecciones.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import elecciones.entities.Voto;
import elecciones.util.Conexion;

public class VotoDao {

private Conexion conexion;
	
	public VotoDao() {
		this.conexion = Conexion.getConexion();
	}
	
	
	public void  insert(Voto vt) {	
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	tx.begin();
	 	
	 	em.persist(vt);
	 	
	 	tx.commit();
	}
	
	public void  update(Voto vt) {
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	tx.begin();
	 	
	 	em.merge(vt);
	 	
	 	tx.commit();
	} 
	
	public Voto  get(int id) {
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
		Voto vt = em.find(Voto.class, id);
	 	return vt;
	}
	
	public void delete(int id) {
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	Voto vt = em.find(Voto.class, id);
	 	tx.begin();
	 	em.remove(vt);
	 	tx.commit();
	}
	
	public List<Voto> list(){
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	List<Voto> listVotos = em.createQuery("select vt from voto").getResultList();
		return listVotos;
	}
	

}
