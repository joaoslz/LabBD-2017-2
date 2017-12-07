package ifma.dcomp.lbd.pedidovenda.teste;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import ifma.dcomp.lbd.pedidovenda.model.Cliente;
import ifma.dcomp.lbd.pedidovenda.model.Endereco;
import ifma.dcomp.lbd.pedidovenda.model.TipoPessoa;


public class TesteCliente {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pedidoVendaPU");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transacao = manager.getTransaction();
		
		transacao.begin();
		
		Cliente cliente = new Cliente();
		cliente.setNome("João da Silva");
		cliente.setEmail("joao@silva.com");
		cliente.setDocumentoReceitaFederal("93655818696");
		
		cliente.setTipo(TipoPessoa.FISICA);
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua do Sol");
		endereco.setNumero("100");
		endereco.setCidade("São Luís");
		endereco.setUf("MA");
		endereco.setCep("65000-000");
		
		endereco.setCliente(cliente);
		
		cliente.adicionaUmEndereco(endereco );
		
		manager.persist(cliente);
		
		transacao.commit();
		
		manager.close();
		factory.close();
	}
	
}
