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
		

		TypedQuery<ClienteEPedido> query = em.createQuery("SELECT new model.ClienteEPedido(p.cliente.nome, p.codPedido) FROM Cliente AS c "
				+ "INNER JOIN Pedido AS p ON p.cliente.codCliente = c.codCliente "
				+ "ORDER BY c.nome, p.codPedido", ClienteEPedido.class);
		List<ClienteEPedido> results = query.getResultList();
		int calc = 0;
		for (ClienteEPedido result : results) {
			calc++;
			System.out.println("Cliente: " + result.getNome() + ", Pedido: " + result.getCodPedido());
		}
		System.out.println(calc + " rows");
		
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
class ClienteEPedido {
		private String nome;
		private Integer codPedido;
		
		public ClienteEPedido() {
			super();
		}

		public ClienteEPedido(String nome, Integer codPedido) {
		this.nome = nome;
		this.codPedido = codPedido;
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

		
	}
	
	
