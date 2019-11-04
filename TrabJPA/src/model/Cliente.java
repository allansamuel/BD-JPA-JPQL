package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "CodCliente")
	private Integer codCliente;

	@Column(name = "Nome")
	private String nome;
	
	@Column(name = "Endereco")
	private String endereco;
	
	@Column(name = "Cidade")
	private String cidade;
	
	@Column(name = "Cep")
	private String cep;
	
	@Column(name = "Uf")
	private String uf;
	
	@Column(name = "Ie")
	private String ie;
	
	public Cliente() {
		super();
	}
	public Integer getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getIe() {
		return ie;
	}
	public void setIe(String ie) {
		this.ie = ie;
	}
	
	
	
}
