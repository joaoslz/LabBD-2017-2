package ifma.dcomp.lbd.pedidovenda.repository;

import javax.persistence.EntityManager;

import ifma.dcomp.lbd.pedidovenda.model.Pedido;

public class Pedidos {


	private EntityManager manager;
	
    public Pedidos(EntityManager manager) {
		this.manager = manager;
	}

    
	public Pedido salva(Pedido pedido) {
		return this.manager.merge(pedido);
	}

	
	public Pedido porId(Long id) {
		return this.manager.find(Pedido.class, id);
	}
	
}