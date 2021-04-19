package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura"); 
		EntityManager em = emf.createEntityManager();		
		
		Conta conta = new Conta();
		conta.setTitular("Jo�o");
		conta.setNumero(1234567);
		conta.setAgencia(643217);
		
		em.getTransaction().begin(); //se n�o colocar esse comando ele n�o inicia a inser��o dos dados
		
		em.persist(conta);
		
		em.getTransaction().commit(); //se n�o colocar esse comando ele n�o escreve a inser��o dos dados
				
	}
	
}
