package br.com.fiap.jpa.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_GCO_CONDOMINIO")
@SequenceGenerator(name = "condominio", sequenceName = "SQ_T_GCO_CONDOMINIO", allocationSize = 1)
public class Condominio implements Serializable {

	private static final long serialVersionUID = 2346214738097779106L;

	public Condominio() {
	}

	public Condominio(String cnpj, LocalDate dataFundacao, String razaoSocial, String nomeFantasia,
			List<Portaria> portaria) {
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.portaria = portaria;
	}

	@Id
	@GeneratedValue(generator = "condominio", strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_CONDOMINIO")
	private Long id;

	@Column(name = "NR_CNPJ")
	private String cnpj;

	@Column(name = "DT_FUNDACAO")
	private LocalDate dataFundacao;

	@Column(name = "DS_RAZAO_SOCIAL")
	private String razaoSocial;

	@Column(name = "NM_FANTASIA", length = 55)
	private String nomeFantasia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	@OneToMany(mappedBy = "condominio", fetch = FetchType.EAGER)
	private List<Portaria> portaria;

	@Override
	public String toString() {
		return "\nCondominio [cnpj=" + this.getCnpj() + ", \ndataFundacao=" + this.getDataFundacao() + ", \nrazaoSocial=" + this.getRazaoSocial()
				+ ", \nnomeFantasia=" + this.getNomeFantasia() + "]";
	}

	
}
