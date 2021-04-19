package br.com.alura.jpa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nome;
	
	@Override
	public String toString() {
		return nome + " - " + Id;
	}
	
	
	//Constructors
	@Deprecated //esse não será usado, só está aqui por causa do Hibernate, por isso a annotation que o anula.
	public Categoria() {
	}
				
	public Categoria(String nome) {
		super();
		this.nome = nome;
	}
	//Getters and Setters
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
