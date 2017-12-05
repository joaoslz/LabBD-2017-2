package ifma.dcomp.lbd.aula_jdbc.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMFactory {
	
	
	private final EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("estoquePU");
	

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	
	public void close() {
		emf.close();
	}
}
