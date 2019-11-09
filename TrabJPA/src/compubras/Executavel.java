package compubras;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Cliente;
import model.Comissao;
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
		
//		Cliente c = new Cliente(1, "allanzinho", "rua", "cidade", "12231", "UF", "233223");
////		em.persist(c);
//		Produto p = new Produto(1, "produto legal", 1200.90);
////		em.persist(p);
//		Vendedor v = new Vendedor(1, "paola", 2.00, Comissao.A);
////		em.persist(v);
//		Pedido e = new Pedido(1, LocalDate.of(2019, 11, 29), LocalDate.of(2019, 10, 31), c, v);
//		
//		ItemPedido i = new ItemPedido(null, e, p, 25);
//		em.persist(i);
		
		buscarPedidos(em);
//		buscarProdutosVendidos(em);
//		buscarQuantidadePorPedido(em);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	//Ver os pedidos de cada cliente, listando nome do cliente e número do pedido.
	public static List<Pedido> buscarPedidos(EntityManager em) {
		TypedQuery<Pedido> query = em.createQuery("SELECT p.cliente.nome, p.codPedido FROM Cliente AS c "
				+ "INNER JOIN Pedido AS p ON p.cliente.codCliente = c.codCliente "
				+ "ORDER BY c.codCliente, p.codPedido", Pedido.class);
		List<Pedido> results = query.getResultList();
		int calc = 0;
		for (Pedido result : results) {
			calc++;
			System.out.println("Cliente: " + result.getCliente().getNome() + ", Pedido: " + result.getCodPedido());
		}
		System.out.println(calc);
		return results;
	}
	
	
//	Mostre o código do produto, a descrição e o valor total obtido por cada produto ao longo da história da loja. 
//	Ordene a lista pelo valor total dos produtos. Observe que mesmo os produtos que nunca foram vendidos devem ser exibidos.
	public static List<Object[]> buscarProdutosVendidos(EntityManager em) {
		TypedQuery<Object[]> query = em.createQuery("select p.codProduto, p.descricao, sum(coalesce(i.quantidade,0) * p.valorUnitario) as obtido " + 
				"from Produto p left join ItemPedido i on i.produto.codProduto = p.codProduto group by p.codProduto", Object[].class);
		List<Object[]> results = query.getResultList();
		int calc = 0;
		for (Object[] result : results) {
			calc++;
			System.out.println("CodProduto: " + result[0] + ", Descricao: " + result[1] + ", ValorObtido: " + result[2]);
		}
		System.out.println(calc);
		return results;
	}
	
	//Liste o nome do cliente, o código do pedido e a quantidade total de produtos por pedido.
	public static List<Object[]> buscarQuantidadePorPedido(EntityManager em) {
		TypedQuery<Object[]> query = em.createQuery("SELECT c.nome, p.codPedido, SUM(COALESCE(i.quantidade,0)) FROM Cliente AS c " + 
				"INNER JOIN Pedido AS p ON p.cliente.codCliente = c.codCliente " + 
				"LEFT JOIN ItemPedido AS i ON p.codPedido = i.pedido.codPedido " + 
				"GROUP BY p.codPedido ORDER BY c.codCliente, p.codPedido", Object[].class);
		List<Object[]> results = query.getResultList();
		int calc = 0;
		for (Object[] result : results) {
			calc++;
			System.out.println("Cliente: " + result[0] + ", Pedido: " + result[1] + ", Quantia: " + result[2]);
		}
		System.out.println(calc);
		return results;
	}

}
