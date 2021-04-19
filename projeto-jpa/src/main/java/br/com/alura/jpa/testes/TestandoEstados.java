package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {
	public static void main(String[] args) {
		//Transient - > não tem vínculo nenhum com a Conta original, pois ela não tem Id.
		Conta conta = new Conta();
		conta.setTitular("Almiro");
		conta.setNumero(123123);
		conta.setAgencia(12387456);
				
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura"); 
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//Transient -> Managed
		em.persist(conta);
		
		//Managed ->Removed
		em.remove(conta);
		
		em.getTransaction().commit();
		
	}

}
