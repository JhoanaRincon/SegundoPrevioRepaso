package elecciones.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import elecciones.entities.Estamento;
import elecciones.util.Conexion;

public class EstamentoDao {

private Conexion conexion;
	
	public EstamentoDao() {
		this.conexion = Conexion.getConexion();
	}
	
	
	public void  insert(Estamento es) {	
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	tx.begin();
	 	
	 	em.persist(es);
	 	
	 	tx.commit();
	}
	
	public void  update(Estamento es) {
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	tx.begin();
	 	
	 	em.merge(es);
	 	
	 	tx.commit();
	} 
	
	public Estamento  get(int id) {
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
		Estamento es = em.find(Estamento.class, id);
	 	return es;
	}
	
	public void delete(int id) {
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	Estamento es = em.find(Estamento.class, id);
	 	tx.begin();
	 	em.remove(es);
	 	tx.commit();
	}
	
	public List<Estamento> list(){
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	List<Estamento> listEstamentos = em.createQuery("select e from estamento").getResultList();
		return listEstamentos;
	}
	
}
