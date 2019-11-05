package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="CodProduto", columnDefinition="INT(4)")
	private Integer codProduto;
	
	@Column(name="Descricao", columnDefinition="VARCHAR(100)", nullable=false)
	private String descricao;
	
	@Column(name="ValorUnitario", columnDefinition="DECIMAL(10,2)", nullable=false)
	private Double valorUnitario;

	public Produto() {
		super();
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

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	} 
	
	
}
