package ifma.dcomp.lbd.aula_jpa.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ifma.dcomp.lbd.aula_jpa.modelo.Produto;

public class aInserindoProduto {
	
	public static void main(String[] args) {
		
		Produto produto1 = new Produto("Lapis de Cor", new BigDecimal(4.0));
		Produto produto2 = new Produto("Resma de Papel", new BigDecimal(18.50));
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("aula-jpa");
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		manager.persist(produto1 );
		manager.persist(produto2 );
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		
		
	}
	

}
