package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;

public class TestaRelacionamentoClienteConta {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager(); 
		
		
		Conta conta = new Conta();
		conta.setId(3L);
		
		Cliente cliente = new Cliente();
		cliente.setNome("Maria");
		cliente.setEndereco("Rua do Ouvidor, 30");
		cliente.setProfissao("Professor");
		cliente.setConta(conta);
		
		em.getTransaction().begin();
		
		em.persist(cliente);
		
		em.getTransaction().commit();
		
	}

}
