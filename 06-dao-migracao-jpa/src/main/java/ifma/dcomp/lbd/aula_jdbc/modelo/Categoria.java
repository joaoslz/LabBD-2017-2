package ifma.dcomp.lbd.aula_jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    
    @OneToMany(mappedBy="categoria")
    private List<Produto> produtos = new ArrayList<>();

    public Categoria() {  }	
    
    public Categoria(String nome) {
        this.nome = nome;
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

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	}
    
	public void adiciona(Produto produto) {
		produtos.add(produto);
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
    
    
    
}