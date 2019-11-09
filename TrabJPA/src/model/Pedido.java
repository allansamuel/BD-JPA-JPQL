package model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CodPedido", columnDefinition="INT(4)")
	private Integer codPedido;
	
	@Column(name="PrazoEntrega", columnDefinition="DATE", nullable=false)
	private LocalDate prazoEntrega;
	
	@Column(name="DataPedido", columnDefinition="DATE", nullable=false)
	private LocalDate dataPedido;
	
	@ManyToOne
	@JoinColumn(name = "CodCliente", columnDefinition="INT(4)", nullable=false)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "CodVendedor", columnDefinition="INT(4)", nullable=false)
	private Vendedor vendedor;

	public Pedido() {
		super();
	}
	
	public Pedido(Integer codPedido, LocalDate prazoEntrega, LocalDate dataPedido, Cliente cliente, Vendedor vendedor) {
		super();
		this.codPedido = codPedido;
		this.prazoEntrega = prazoEntrega;
		this.dataPedido = dataPedido;
		this.cliente = cliente;
		this.vendedor = vendedor;
	}

	public Integer getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(Integer codPedido) {
		this.codPedido = codPedido;
	}

	public LocalDate getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(LocalDate prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
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
