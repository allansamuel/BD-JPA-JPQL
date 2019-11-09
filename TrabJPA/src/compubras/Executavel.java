package compubras;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import model.Vendedor;

public class Executavel {
	public static void main(String[]args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("compubras");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		buscarPedidos(em);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	//Ver os pedidos de cada cliente, listando nome do cliente e n�mero do pedido.
	public static List<Object[]> buscarPedidos(EntityManager em) {
		TypedQuery<Object[]> query = em.createQuery("SELECT c.nome, p.codPedido FROM Cliente AS c "
				+ "LEFT JOIN Pedido AS p ON p.cliente.codCliente = c.codCliente", Object[].class);
		List<Object[]> results = query.getResultList();
		int calc = 0;
//		for (Object[] result : results) {
//			calc++;
//			System.out.println("Cliente: " + result[0] + ", Pedido: " + result[1]);
//		}
//		System.out.println(calc);
		return results;
	}

}
