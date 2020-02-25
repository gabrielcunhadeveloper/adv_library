package br.com.gabrielcunha.advlibrary.api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	
	private String descricao;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "livros_autores", joinColumns = {@JoinColumn(name = "id_livro")}, inverseJoinColumns = {@JoinColumn(name = "id_autor") })
	private List<Autor> autores;
	
	private String edicao;
	
	private String isbn;
	
	@Column(name = "quantidade_exemplares")
	private Integer quantidadeExemplares;
	
	private boolean ativo;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void addAutor(Autor autor) {
		if (this.autores == null) {
			this.autores = new ArrayList<>();
		}
		
		this.autores.add(autor);
	}
	
	public List<Autor> getAutores() {
		if (this.autores == null) {
			this.autores = new ArrayList<>();
		}
		
		return this.autores;
	}
	
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public Integer getQuantidadeExemplares() {
		return quantidadeExemplares;
	}
	public void setQuantidadeExemplares(Integer quantidadeExemplares) {
		this.quantidadeExemplares = quantidadeExemplares;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	
	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", autores=" + autores
				+ ", edicao=" + edicao + ", isbn=" + isbn + ", quantidadeExemplares=" + quantidadeExemplares
				+ ", ativo=" + ativo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
