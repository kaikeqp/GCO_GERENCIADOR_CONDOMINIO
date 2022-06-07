package br.com.fiap.jpa.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_GCO_PORTARIA")
@SequenceGenerator(name = "portaria", sequenceName = "SQ_T_GCO_PORTARIA", allocationSize = 1)
public class Portaria implements Serializable {

	private static final long serialVersionUID = 4382414400712734208L;

	public Portaria() {
		this.status = true;
	}	
	
	public Portaria(String numero, String nome, LocalDate dataInicio, LocalDate dataTermino,
			List<MovimentacaoPortaria> movimentacaoPortaria, Condominio condominio) {
		this.numero = numero;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.movimentacaoPortaria = movimentacaoPortaria;
		this.condominio = condominio;
	}

	@Id
	@GeneratedValue(generator = "portaria", strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NR_PORTARIA")
	private String numero;

	@Column(name = "NM_PORTARIA", length = 55)
	private String nome;

	@Column(name = "ST_STATUS")
	private Boolean status;

	@Column(name = "DT_INICIO")
	private LocalDate dataInicio;

	@Column(name = "DT_TERMINO")
	private LocalDate dataTermino;

	@OneToMany(mappedBy = "portaria", fetch = FetchType.EAGER)
	private List<MovimentacaoPortaria> movimentacaoPortaria;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "condominio_id")
	private Condominio condominio;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	public List<MovimentacaoPortaria> getMovimentacaoPortaria() {
		return movimentacaoPortaria;
	}

	public void setMovimentacaoPortaria(List<MovimentacaoPortaria> movimentacaoPortaria) {
		this.movimentacaoPortaria = movimentacaoPortaria;
	}
	
	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

	@Override
	public String toString() {
		return "Portaria \n[numero=" + this.getNumero() + ", \nnome=" + this.getNome() + ", \nstatus=" + this.getStatus() + ", \ndataInicio=" + this.getDataInicio()
				+ ", \ndataTermino=" + getDataTermino() + "]";
	}
	
	

}
