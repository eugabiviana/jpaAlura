package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoContaLeonardo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura"); 
		EntityManager em = emf.createEntityManager();		
		
		Conta contaDoLeonardo = em.find(Conta.class, 1L); //o dado 1l, é a primary key Id do Leonardo, o JPA atualiza os dados por causa desse find! Ele guarda a informação inicial da classe CONTA e detecta que uma alteração foi feita.
		
		em.getTransaction().begin();
		
		contaDoLeonardo.setSaldo(20.0);
		
		em.getTransaction().commit();
		
		//System.out.println("Conta do Leonardo: " +contaDoLeonardo.getTitular()); Usei para testar se o parâmetro estava correto
		
		
	}

}
