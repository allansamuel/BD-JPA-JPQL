package compubras;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Cliente;

public class Executavel {
	public static void main(String[]args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("compubras");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Cliente c = new Cliente();
		c  = em.find(Cliente.class, 1);
		System.out.println(c.getNome());
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
