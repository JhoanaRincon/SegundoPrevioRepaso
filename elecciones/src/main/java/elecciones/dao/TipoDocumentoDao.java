package elecciones.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import elecciones.entities.Tipodocumento;
import elecciones.util.Conexion;

public class TipoDocumentoDao {

private Conexion conexion;
	
	public TipoDocumentoDao() {
		this.conexion = Conexion.getConexion();
	}
	
	
	public void  insert(Tipodocumento td) {	
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	tx.begin();
	 	
	 	em.persist(td);
	 	
	 	tx.commit();
	}
	
	public void  update(Tipodocumento td) {
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	tx.begin();
	 	
	 	em.merge(td);
	 	
	 	tx.commit();
	} 
	
	public Tipodocumento  get(int id) {
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
		Tipodocumento td = em.find(Tipodocumento.class, id);
	 	return td;
	}
	
	public void delete(int id) {
		
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	Tipodocumento td = em.find(Tipodocumento.class, id);
	 	tx.begin();
	 	em.remove(td);
	 	tx.commit();
	}
	
	public List<Tipodocumento> list(){
		EntityManager em = conexion.getEm(); //conexion a la base de datos
	 	EntityTransaction tx = em.getTransaction();  //transacional para poder interactuar con la base de datos
	 	List<Tipodocumento> listTipodocumentos = em.createQuery("select td from tipodocumento").getResultList();
		return listTipodocumentos;
	}
}
