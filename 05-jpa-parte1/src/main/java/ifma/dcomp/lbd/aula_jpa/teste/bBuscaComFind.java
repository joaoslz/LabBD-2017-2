package ifma.dcomp.lbd.aula_jpa.teste;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ifma.dcomp.lbd.aula_jpa.modelo.Produto;

public class bBuscaComFind {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("aula-jpa");
		EntityManager manager = factory.createEntityManager();
		
		
	
	}

}
