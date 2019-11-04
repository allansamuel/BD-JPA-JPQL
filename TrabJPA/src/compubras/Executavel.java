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
		
		c.setCodCliente(0);
		c.setNome("pedrinho");
		c.setEndereco("rua show");
		c.setCidade("cidade do pedrinho");
		c.setCep("121312");
		c.setUf("rs");;
		c.setIe("123456789111");
		em.persist(c);
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
