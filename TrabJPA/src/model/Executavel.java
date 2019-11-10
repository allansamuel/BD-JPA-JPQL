package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Executavel {
	public static void main(String[]args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("compubras");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<ClienteEPedidoEProdutos> query = em.createQuery("SELECT new model.ClienteEPedidoEProdutos" + 
				"(c.nome, p.codPedido, SUM(COALESCE(i.quantidade,0))) FROM Cliente AS c " + 
				"INNER JOIN Pedido AS p ON p.cliente.codCliente = c.codCliente " + 
				"LEFT JOIN ItemPedido AS i ON p.codPedido = i.pedido.codPedido " + 
				"GROUP BY p.codPedido ORDER BY c.codCliente, p.codPedido", ClienteEPedidoEProdutos.class);
		List<ClienteEPedidoEProdutos> results = query.getResultList();
		int calc = 0;
		for (ClienteEPedidoEProdutos result : results) {
			calc++;
			System.out.println("Cliente: " + result.getNome() + ", Pedido: " + result.getCodPedido() + ", Quantia: " + result.getQuantidade());
		}
		System.out.println(calc + " rows");
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
class ClienteEPedidoEProdutos {
		private String nome;
		private Integer codPedido;
		private long quantidade;
		
		public ClienteEPedidoEProdutos() {
			super();
		}

		public ClienteEPedidoEProdutos(String nome, Integer codPedido, long quantidade) {
			super();
			this.nome = nome;
			this.codPedido = codPedido;
			this.quantidade = quantidade;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Integer getCodPedido() {
			return codPedido;
		}

		public void setCodPedido(Integer codPedido) {
			this.codPedido = codPedido;
		}

		public long getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(long quantidade) {
			this.quantidade = quantidade;
		}

		

		
	}
	
	
