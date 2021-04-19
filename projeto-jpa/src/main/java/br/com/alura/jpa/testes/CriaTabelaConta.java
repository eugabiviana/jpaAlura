package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaTabelaConta {
	public static void main(String[] args) {
	//Como chamar o JPA para que ele crie a tabela conta? Cria o objeto EntityManagerFactory.
		//contas é o nome da unidade de persistencia, foi definido no arquivo persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura"); 
		EntityManager createEntityManager = emf.createEntityManager();
		emf.close();
		
	}
}
