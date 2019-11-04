package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Vendedor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "CodVendedor")
	private Integer codVendedor;

	@Column(name = "Nome")
	private String nome;
	
	@Column(name = "SalarioFixo")
	private String salarioFixo;
	
	@Column(name = "FaixaComissao")
	private String faixaComissao;

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

	public String getFaixaComissao() {
		return faixaComissao;
	}

	public void setFaixaComissao(String faixaComissao) {
		this.faixaComissao = faixaComissao;
	}
	
	
	
	
	
	
}
