package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="itempedido")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CodItemPedido", columnDefinition="INT(4)" )
	private Integer codItemPedido;
	
	@ManyToOne
	@JoinColumn(name = "CodPedido", columnDefinition = "INT(4)", nullable=false)
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "CodProduto", columnDefinition = "INT(4)", nullable=false)
	private Produto produto;
	
	@Column(name = "Quantidade", columnDefinition="INT(5)", nullable= false)
	private Integer quantidade;

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
