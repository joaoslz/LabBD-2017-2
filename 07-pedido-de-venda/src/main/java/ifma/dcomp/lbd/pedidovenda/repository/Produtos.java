package ifma.dcomp.lbd.pedidovenda.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import ifma.dcomp.lbd.pedidovenda.model.Produto;

public class Produtos {


	private EntityManager manager;

	
	public Produto salva(Produto produto) {
		return manager.merge(produto);
	}
	

	public void remove(Produto produto) {
		try {
			produto = buscaPorId(produto.getId());
			manager.remove(produto);
			manager.flush();
		} catch (PersistenceException e) {
			throw new IllegalStateException("Produto não pode ser excluído.");
		}
	}

	public Produto buscaPorSku(String sku) {
		try {
			return manager.createQuery("from Produto where upper(sku) = :sku", Produto.class)
				.setParameter("sku", sku.toUpperCase())
				.getSingleResult();
			
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	public Produto buscaPorId(Long id) {
		return manager.find(Produto.class, id);
	}

	
	public List<Produto> buscaPorNome(String nome) {
		return this.manager.createQuery("from Produto where upper(nome) like :nome", Produto.class)
				.setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}
	
}