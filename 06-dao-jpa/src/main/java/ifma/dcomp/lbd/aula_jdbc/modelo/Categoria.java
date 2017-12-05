package ifma.dcomp.lbd.aula_jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
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
    private final List<Produto> produtos = new ArrayList<>();

    
	public Categoria() {
	}

	
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

	public void adiciona(Produto produto) {
		produtos.add(produto);
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((produtos == null) ? 0 : produtos.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (produtos == null) {
			if (other.produtos != null)
				return false;
		} else if (!produtos.equals(other.produtos))
			return false;
		return true;
	}
	
	
	
}