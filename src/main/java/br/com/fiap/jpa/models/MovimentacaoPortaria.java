package br.com.fiap.jpa.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_GCO_MOVIMENTACAO_PORTARIA")
@SequenceGenerator(name = "movimentacaoPortaria", sequenceName = "SQ_T_GCO_MOVIMENTACAO_PORTARIA", allocationSize = 1)
@NamedQueries({
	@NamedQuery(name = "MovimentacaoPortaria.listarPorTipo", query = "SELECT a FROM MovimentacaoPortaria a WHERE a.tipo = :tipo")})
public class MovimentacaoPortaria implements Serializable{

	private static final long serialVersionUID = 5786427317314565431L;

	public MovimentacaoPortaria() {
	}
	
	
	public MovimentacaoPortaria(String tipo, LocalDateTime data, Visitante visitante, FuncPortaria funcPortaria,
			Portaria portaria) {
		this.tipo = tipo;
		this.data = data;
		this.visitante = visitante;
		this.funcPortaria = funcPortaria;
		this.portaria = portaria;
	}


	@Id
	@GeneratedValue(generator = "movimentacaoPortaria", strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_MOVIMENTACAO")
	private Long id;
	
	@Column(name = "TP_MOVIMENTACAO")
	private String tipo;
	
	@Column(name = "DT_MOVIMENTACAO")
	private LocalDateTime data;
	
	@ManyToOne(cascade = CascadeType.MERGE, optional = true)
	@JoinColumn(name = "visitante_id")
	private Visitante visitante;
	
	@ManyToOne(cascade = CascadeType.MERGE, optional = true)
	@JoinColumn(name = "funcPortaria_id")
	private FuncPortaria funcPortaria;
	
	@ManyToOne(cascade = CascadeType.MERGE, optional = true)
	@JoinColumn(name = "portaria_id")
	private Portaria portaria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}

	public FuncPortaria getFuncPortaria() {
		return funcPortaria;
	}

	public void setFuncPortaria(FuncPortaria funcPortaria) {
		this.funcPortaria = funcPortaria;
	}

	public Portaria getPortaria() {
		return portaria;
	}

	public void setPortaria(Portaria portaria) {
		this.portaria = portaria;
	}

	@Override
	public String toString() {
		return "MovimentacaoPortaria \n[tipo=" + tipo + ", \ndata=" + data + ", \nvisitante=" + visitante + ", \nfuncPortaria="
				+ funcPortaria + ", \nportaria=" + portaria + "]";
	}

}
