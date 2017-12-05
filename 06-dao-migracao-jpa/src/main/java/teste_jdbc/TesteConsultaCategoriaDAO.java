package teste_jdbc;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import ifma.dcomp.lbd.aula_jdbc.dao.CategoriasDAO;
import ifma.dcomp.lbd.aula_jdbc.infra.EMFactory;
import ifma.dcomp.lbd.aula_jdbc.modelo.Categoria;

public class TesteConsultaCategoriaDAO {

	public static void main(String[] args) throws SQLException {
		
		EMFactory emFactory = new EMFactory();
		
		EntityManager manager = emFactory.getEntityManager();
		
		
		CategoriasDAO categoriaDAO = new CategoriasDAO(manager );
		
		List<Categoria> categorias = categoriaDAO.
			                        	buscaCategoriasSemOsProdutos();
		
		categorias.forEach(System.out::println);
		
		
		manager.close();
		emFactory.close();

	
	}
}
