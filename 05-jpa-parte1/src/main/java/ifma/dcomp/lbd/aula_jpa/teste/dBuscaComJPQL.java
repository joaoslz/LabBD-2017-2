package ifma.dcomp.lbd.aula_jpa.teste;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ifma.dcomp.lbd.aula_jpa.modelo.Produto;

public class dBuscaComJPQL {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("aula-jpa");
		EntityManager manager = factory.createEntityManager();
		
		
	}
				
		     
	
}
