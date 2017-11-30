package ifma.dcomp.lbd.aula_jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ifma.dcomp.lbd.aula_jpa.modelo.Produto;

public class bBuscaComFind {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("aula-jpa");
		EntityManager manager = factory.createEntityManager();
		
		
		Produto produto = manager.find(Produto.class, 1);
		
		System.out.println("\n-------------------------------" );
		
		System.out.println(produto );

		System.out.println(produto.getNome() );
		System.out.println(produto.getPreco() );
		
		
	
	}

}
