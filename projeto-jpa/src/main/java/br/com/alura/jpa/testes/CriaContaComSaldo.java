package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura"); 
		EntityManager em = emf.createEntityManager();		
		
		Conta conta = new Conta();
		conta.setTitular("Márcia");
		conta.setNumero(12345);
		conta.setAgencia(54321);
		conta.setSaldo(100.0);
		
		
		em.getTransaction().begin(); //se não colocar esse comando ele não inicia a inserção dos dados
		
		em.persist(conta);		
				
		em.getTransaction().commit(); //se não colocar esse comando ele não escreve a inserção dos dados
		em.close(); //quando fecha a entidade, ele não seta mais o banco de dados. Pra isso, tem que criar outra entity.
		
		EntityManager em2 = emf.createEntityManager();
		System.out.println("ID da conta da Márcia: " + conta.getId());
		conta.setSaldo(500.0);
		
		em2.getTransaction().begin();
		
		em2.merge(conta); //o merge transforma uma conta detached em managed de novo.
		
		em2.getTransaction().commit();
		
		
	}

}
