package elecciones.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import elecciones.entities.Eleccion;
import elecciones.util.Conexion;

import elecciones.entities.Eleccion;
import elecciones.util.Conexion;
//esto es una nueva actualización para recordar que no se ha realizado
//no me imprt ahorita
public class EleccionDao {
private Conexion conexion;
	
	public EleccionDao() {
		this.conexion = Conexion.getConexion();
	}
	
	
	public void  insert(Eleccion e) {	
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	tx.begin();
	 	
	 	em.persist(e);
	 	
	 	tx.commit();
	}
	
	public void  update(Eleccion e) {
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	tx.begin();
	 	
	 	em.merge(e);
	 	
	 	tx.commit();
	} 
	
	public Eleccion  get(int id) {
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
		Eleccion e = em.find(Eleccion.class, id);
	 	return e;
	}
	
	public void delete(int id) {
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	Eleccion e = em.find(Eleccion.class, id);
	 	tx.begin();
	 	em.remove(e);
	 	tx.commit();
	}
	
	public List<Eleccion> list(){
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	List<Eleccion> listEleccion = em.createQuery("select e from eleccion").getResultList();
		return listEleccion;
	}
}
