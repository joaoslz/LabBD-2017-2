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
	
	public Categoria buscaPor(Integer id) {
		return manager.find(Categoria.class, id);
	}
	
	
	public void salva(Categoria categoria) {
		
		this.manager.getTransaction().begin();
		this.manager.persist(categoria );
		this.manager.getTransaction().commit();
	}
	

    public List<Categoria> buscaCategoriasSemOsProdutos() {
    	
    	return manager.createQuery("FROM Categoria", Categoria.class)
    			.getResultList();
    	
    }
    
 /*   public List<Produto> buscaProdutosDa(Categoria categoria) {
    	
    	return categoria.getProdutos();
    }
*/    
    public List<Categoria> buscaCategoriasComProdutos()  {

        String jpql = "SELECT c FROM Categoria c join fetch Produto p";
        return this.manager.createNamedQuery(jpql, Categoria.class)
        		.getResultList();    
    }
}