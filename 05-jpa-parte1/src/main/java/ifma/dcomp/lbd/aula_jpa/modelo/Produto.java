package ifma.dcomp.lbd.aula_jpa.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
//@NamedQuery(name="produto.todos", query="SELECT p FROM Produto p" )

@NamedQueries({ 
	    @NamedQuery(name="produto.todos", query="SELECT p FROM Produto p"),
	    @NamedQuery(name="produto.porId", query="SELECT p FROM Produto p where p.id = :pId")
})

public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private BigDecimal preco;
	
	private LocalDate dataCadastro;
	
	public Produto() {
	}

	public Produto(String nome, BigDecimal preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}
	
	public Integer getId() {
		return id;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	
	@Override
	public String toString() {
		return String.format("Produto %s com Preço %.2f na data %s", 
				this.nome, this.preco.doubleValue(), this.dataCadastro );
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	
	

}
