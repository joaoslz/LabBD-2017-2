package teste_jdbc;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import ifma.dcomp.lbd.aula_jdbc.dao.CategoriasDAO;
import ifma.dcomp.lbd.aula_jdbc.infra.EMFactory;
import ifma.dcomp.lbd.aula_jdbc.modelo.Categoria;

public class TesteInsereCategoriaDAO {

	public static void main(String[] args) throws SQLException {
		
		EMFactory emFactory = new EMFactory();
		
		EntityManager manager = emFactory.getEntityManager();
		
		
		CategoriasDAO categoriaDAO = new CategoriasDAO(manager );
		
		Categoria categoria =  new Categoria("Informática");
		
		categoriaDAO.salva(categoria);
		
		
		manager.close();
		emFactory.close();

	
	}
}
