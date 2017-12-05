package ifma.dcomp.lbd.aula_jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import ifma.dcomp.lbd.aula_jdbc.modelo.Produto;

public class ProdutoDAO {

	private EntityManager manager;

	public ProdutoDAO(EntityManager manager) {
		this.manager = manager;
	}

	public Produto salva(Produto produto) {

		manager.getTransaction().begin();
		Produto produtoSalvo = manager.merge(produto);
		manager.getTransaction().commit();

		return produtoSalvo;

	}

	public List<Produto> lista() throws SQLException {
		return manager.createQuery("FROM Produto", Produto.class).getResultList();

	}

}
