package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemPedido {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CodItemPedido", columnDefinition="INT(4)" )
	private Integer codItemPedido;
	
	@Column(name="Quantidade", columnDefinition="INT(5)", nullable= false)
	private Integer quantidade;
	
	@ManyToOne
	@JoinColumn(name = "CodProduto")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "CodPedido")
	private Pedido pedido;

	public ItemPedido() {
		super();
	}

	public Integer getCodItemPedido() {
		return codItemPedido;
	}

	public void setCodItemPedido(Integer codItemPedido) {
		this.codItemPedido = codItemPedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	
	
	
}
