package home;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBManager {
	
	private static DBManager dbManager;
	private EntityManagerFactory emf;
	
	private DBManager() {
	}
	
	public static synchronized DBManager getDbManager(){
		if(dbManager == null){
			dbManager = new DBManager();
		}
		return dbManager;
	}
	
	public EntityManagerFactory createEntityManagerFactory(){
		if(emf == null){
			emf = Persistence.createEntityManagerFactory("MyPersistanceUnit");
		}
		return emf;
	}
	
	public EntityManager createEntityManager(){
		return this.createEntityManagerFactory().createEntityManager();
	}
	
	public void closeEntityManagerFactory(){
		if(emf != null){
			emf.close();
		}
	}
	
	

}
