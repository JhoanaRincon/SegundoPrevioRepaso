package elecciones.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion {
	
	private EntityManager em;
	private static Conexion conexion;
	
	public Conexion() {
		if(this.em == null) {
			System.out.print("aaaaaaaaaaa");
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("elecciones");
		    em = emf.createEntityManager();  //conexion a la base de datos
		}
	
	}
	
	public static Conexion getConexion() {
		if(conexion==null) {
			conexion = new Conexion();
		}
		return conexion;
	}
		
	public EntityManager getEm() {
		return this.em;
	}
}
