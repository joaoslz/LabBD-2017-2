package ifma.dcomp.lbd.aula_jpa.teste;

import java.math.BigDecimal;
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
		
		
//		Query query = manager.createQuery("select p from Produto p", Produto.class);
//		Query query = manager.createQuery("from Produto p", Produto.class);

//		Query query = manager.createQuery("select p from Produto p where p.preco > 5", Produto.class);
		
//		Query query = manager.createQuery("SELECT p FROM Produto p WHERE p.nome LIKE '%Lapis%' ", Produto.class);
//
//		Query query = manager.createQuery("select p from Produto p "
//				                          + "where p.preco between :pValorInicial and :pValorFinal", 
//				Produto.class);
//		
//		query.setParameter("pValorInicial", new BigDecimal(1) );
//		query.setParameter("pValorFinal", new BigDecimal(10) );

//		List<Produto> produtos = query.getResultList();
// ------------------------------------------------------------- 
		
		
		String jpql = "select p from Produto p "
        + "where p.preco between :pValorInicial and :pValorFinal";
		
		List<Produto> produtos = manager.createQuery(jpql, Produto.class)
						  .setParameter("pValorInicial", new BigDecimal(1) )
						  .setParameter("pValorFinal", new BigDecimal(10) )
						  
						  .getResultList();

		
		
//		for (Produto produto : produtos) {
//			System.out.println(produto);
//		}
		
/*		produtos.forEach(new Consumer<Produto>() {

			@Override 
			public void accept(Produto produto) {
				System.out.println(produto);
				
			}	} );
*/		
//		produtos.forEach( produto -> System.out.println(produto) );
		
		System.out.println("\n-----------------------------");
		produtos.forEach( System.out::println );
		
		
		//produtos.forEach(System.out::println  );
		
		
	}
				
		     
	
}
