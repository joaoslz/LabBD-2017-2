package ifma.dcomp.lbd.aula_jdbc.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ifma.dcomp.lbd.aula_jdbc.modelo.Categoria;
import ifma.dcomp.lbd.aula_jdbc.modelo.Produto;

public class CategoriasDAO {

	private final EntityManager manager;

	public CategoriasDAO(EntityManager manager) {
		this.manager = manager;
	}

	public List<Categoria> buscaCategoriasSemOsProdutos() {
		return manager.createQuery("from Categoria", Categoria.class).getResultList();
	}

	
	public List<Produto> buscaProdutosDa(Categoria categoria) {
		return manager.createQuery("SELECT p FROM PRODUTO p where p.categoria = categoria", Produto.class)
				.getResultList();
	}

	
	public List<Categoria> buscaCategoriasComProdutos() {

		String jpql = "SELECT c FROM Categoria c fetch join Produto p";
		return manager.createQuery(jpql, Categoria.class)
				      .getResultList();
	}

	public void salva(Categoria categoria) {

		manager.getTransaction().begin();
		
		manager.persist(categoria );
		
		manager.getTransaction().commit();
	}
}