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
		
		
		TypedQuery<Produtos> query = em.createQuery("select new model.Produtos" + 
				"(p.codProduto, p.descricao, sum(coalesce(i.quantidade,0) * p.valorUnitario)) " + 
				"from Produto p left join ItemPedido i " +
				"on i.produto.codProduto = p.codProduto group by p.codProduto", Produtos.class);
		List<Produtos> results = query.getResultList();
		int calc = 0;
		for (Produtos result : results) {
			calc++;
			System.out.println("CodProduto: " + result.getCodProduto() + ", Descricao: " + result.getDescricao() + ", ValorObtido: R$ " + result.getValorTotal());
		}
		System.out.println(calc + " rows");
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
class Produtos {
		private Integer codProduto;
		private String descricao;
		private double valorTotal;
		
		public Produtos() {
			super();
		}

		public Produtos(Integer codProduto, String descricao, double valorTotal) {
			super();
			this.codProduto = codProduto;
			this.descricao = descricao;
			this.valorTotal = valorTotal;
		}

		public Integer getCodProduto() {
			return codProduto;
		}

		public void setCodProduto(Integer codProduto) {
			this.codProduto = codProduto;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public double getValorTotal() {
			return valorTotal;
		}

		public void setValorTotal(double valorTotal) {
			this.valorTotal = valorTotal;
		}

		
		
	}
	
	
