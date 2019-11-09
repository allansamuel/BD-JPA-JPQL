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
		
		buscarQuantidadePorPedido(em);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	//Ver os pedidos de cada cliente, listando nome do cliente e número do pedido.
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
	
	
	//Liste o nome do cliente, o código do pedido e a quantidade total de produtos por pedido.
	public static void buscarQuantidadePorPedido(EntityManager em) {
		TypedQuery<Object[]> query = em.createQuery("select c.nome, p.codPedido, sum(i.quantidade) from Cliente c " + 
				"left join Pedido p on p.cliente.codCliente = c.codCliente " + 
				"left join ItemPedido i on p.codPedido = i.pedido.codPedido group by p.codPedido", Object[].class);
		List<Object[]> results = query.getResultList();
		int calc = 0;
		for (Object[] result : results) {
			calc++;
			System.out.println("Cliente: " + result[0] + ", Pedido: " + result[1] + ", Soma: " + result[2]);
		}
		System.out.println(calc);
//		return results;
	}

}
