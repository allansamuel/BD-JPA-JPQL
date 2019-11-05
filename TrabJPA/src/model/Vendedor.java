package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Vendedor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "CodVendedor", columnDefinition= "INT(4)")
	private Integer codVendedor;

	@Column(name = "Nome", columnDefinition="VARCHAR(45)", nullable=false)
	private String nome;
	
	@Column(name = "SalarioFixo", columnDefinition="DECIMAL(10,2)", nullable=false)
	private String salarioFixo;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "FaixaComissao", nullable=false)
	private Comissao faixaComissao;

	public Vendedor() {
		super();
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

	public String getSalarioFixo() {
		return salarioFixo;
	}

	public void setSalarioFixo(String salarioFixo) {
		this.salarioFixo = salarioFixo;
	}

	public Comissao getFaixaComissao() {
		return faixaComissao;
	}

	public void setFaixaComissao(Comissao faixaComissao) {
		this.faixaComissao = faixaComissao;
	}
	
	
	
	
	
	
}
