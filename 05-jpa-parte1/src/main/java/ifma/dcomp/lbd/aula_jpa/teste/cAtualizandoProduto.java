package ifma.dcomp.lbd.aula_jpa.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ifma.dcomp.lbd.aula_jpa.modelo.Produto;

public class cAtualizandoProduto {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("aula-jpa");
		
		EntityManager manager = factory.createEntityManager();

		
		
		manager.close();
		factory.close();
		
		
		
	}
	

}
