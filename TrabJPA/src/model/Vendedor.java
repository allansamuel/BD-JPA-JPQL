package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="vendedor")
public class Vendedor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "CodVendedor", columnDefinition= "INT(4)")
	private Integer codVendedor;

	@Column(name = "Nome", columnDefinition="VARCHAR(45)", nullable=false)
	private String nome;
	
	@Column(name = "SalarioFixo", columnDefinition="DECIMAL(10,2)", precision=10, scale=2, nullable=false)
	private Double salarioFixo;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "FaixaComissao", columnDefinition="ENUM('A','B','C','D')", nullable=false)
	private Comissao faixaComissao;

	public Vendedor() {
		super();
	}

	public Vendedor(Integer codVendedor, String nome, Double salarioFixo, Comissao faixaComissao) {
		super();
		this.codVendedor = codVendedor;
		this.nome = nome;
		this.salarioFixo = salarioFixo;
		this.faixaComissao = faixaComissao;
	}

	public Integer getCodVendedor() {
		return codVendedor;
	}

	public void setCodVendedor(Integer codVendedor) {
		this.codVendedor = codVendedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalarioFixo() {
		return salarioFixo;
	}

	public void setSalarioFixo(Double salarioFixo) {
		this.salarioFixo = salarioFixo;
	}

	public Comissao getFaixaComissao() {
		return faixaComissao;
	}

	public void setFaixaComissao(Comissao faixaComissao) {
		this.faixaComissao = faixaComissao;
	}
	
	
	
	
	
	
}
