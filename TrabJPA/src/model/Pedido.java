package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CodPedido", columnDefinition="INT(4)")
	private Integer codPedido;
	
	@Column(name="PrazoEntrega", columnDefinition="DATE", nullable=false)
	private Date prazoEntrega;
	
	@Column(name="DataPedido", columnDefinition="DATE", nullable=false)
	private Date dataPedido;
	
	@ManyToOne
	@JoinColumn(name = "CodCliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "CodVendedor")
	private Vendedor vendedor;

	public Pedido() {
		super();
	}

	public Integer getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(Integer codPedido) {
		this.codPedido = codPedido;
	}

	public Date getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(Date prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	
}
