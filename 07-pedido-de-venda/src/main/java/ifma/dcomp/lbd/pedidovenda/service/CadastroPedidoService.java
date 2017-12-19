package ifma.dcomp.lbd.pedidovenda.service;

import java.time.LocalDateTime;

import ifma.dcomp.lbd.pedidovenda.model.Pedido;
import ifma.dcomp.lbd.pedidovenda.model.StatusPedido;
import ifma.dcomp.lbd.pedidovenda.repository.Pedidos;

public class CadastroPedidoService  {


	private Pedidos pedidos;
	
	public Pedido salvar(Pedido pedido)  {
		
		if (pedido.ehNovo() ) {
			pedido.setDataCriacao(LocalDateTime.now() );
			pedido.setStatus(StatusPedido.ORCAMENTO);
		}
		
		//pedido.recalcularValorTotal();
/*		
		if (pedido.isNaoAlteravel()) {
			throw new IllegalArgumentException("Pedido não pode ser alterado no status "
					+ pedido.getStatus().getDescricao() + ".");
		}
		
		if (pedido.getItens().isEmpty()) {
			throw new NegocioException("O pedido deve possuir pelo menos um item.");
		}
		
		if (pedido.isValorTotalNegativo()) {
			throw new NegocioException("Valor total do pedido não pode ser negativo.");
		}
*/		
		pedido = this.pedidos.salva(pedido );
		return pedido;
	}
	
}