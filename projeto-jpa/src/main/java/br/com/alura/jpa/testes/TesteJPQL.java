//Classe criada para trazer todas as movimentações de uma conta específica.
//Quando uso o JPA, não quero saber/ver como funcionam os relacionamentos entre tabelas, porque o JPA já faz isso por mim. Mas quando preciso fazer essa consulta, uso o JPQL (Java Persistence Query Language). Com ele posso usar a linguagem do SQL no programa Java.

package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL {
	public static void main(String[] args) {
				
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura"); 
		EntityManager em = emf.createEntityManager();	
				
		String sql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";// por padrão, coloca o 'p' no início do nome para ostrar que é um parâmetro. Os : são para fazer ser reconhecido em query.setParameter("pConta", conta);
		//esse comando é o mesmo que: select * from movimentacao where conta
		
		Conta conta = new Conta();	
		conta.setId(2L);
		TypedQuery<Movimentacao> query = em.createQuery(sql, Movimentacao.class);
		query.setParameter("pConta", conta);
		
		List <Movimentacao> resultList = query.getResultList();		
		for (Movimentacao movimentacao : resultList) { //teste no console, para ver se o método tá certo
			System.out.println("Descrição: " + movimentacao.getDescricao()); 
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
						
		}		
		
	}

}
