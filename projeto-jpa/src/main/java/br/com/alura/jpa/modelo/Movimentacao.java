package br.com.alura.jpa.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Movimentacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private BigDecimal valor;
	
	@Enumerated(EnumType.STRING)//passa qual valor deve ser guardado
	//o Enum abaixo foi criado para que o usuário não tenha opção de digitar informação errada. Nesse caso, só aceita valores de entrada e saída, definidos na classe enum TipoMovimentacao.
	private TipoMovimentacao tipoMovimentacao; 
	private LocalDateTime data;
	private String descricao;		
	@ManyToOne
	private Conta conta;
	
	//a annotation abaixo cria uma tabela que mostra o relacionamento de duas ou mais tabelas. a tabela criada por essa annotation no MySQL foi a movimentacao_categoria.
	@ManyToMany 
	private List<Categoria> categorias;
	
	
	//Getters and Setters
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}
	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	
}
