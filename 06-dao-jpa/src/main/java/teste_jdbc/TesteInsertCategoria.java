package teste_jdbc;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import ifma.dcomp.lbd.aula_jdbc.dao.CategoriasDAO;
import ifma.dcomp.lbd.aula_jdbc.dao.ProdutoDAO;
import ifma.dcomp.lbd.aula_jdbc.infra.EMFactory;
import ifma.dcomp.lbd.aula_jdbc.modelo.Categoria;
import ifma.dcomp.lbd.aula_jdbc.modelo.Produto;

public class TesteInsertCategoria {

	public static void main(String[] args) throws SQLException {

		EntityManager manager = new EMFactory().getEntityManager();
		
		ProdutoDAO produtoDAO = new ProdutoDAO(manager);

/*		Produto produto = new Produto("HD SSD", "HD SSD 500GB");
        Categoria categoria = new Categoria();
        categoria.setNome("Eletrônico");
        
		produto.setCategoria(categoria );
        
		produto = produtoDAO.salva(produto);

		System.out.println("id : " + produto.getId()   );
		System.out.println("id : " + produto.getNome() );
*/
		
		
/*		Categoria categoria = new Categoria();
        categoria.setNome("Eletrônico");
        
        new CategoriasDAO(manager).salva(categoria );
*/        
	}
}
