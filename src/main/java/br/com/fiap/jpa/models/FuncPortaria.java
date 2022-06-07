package br.com.fiap.jpa.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
@Table(name = "T_GCO_FUNC_PORTARIA")
@SequenceGenerator(name = "funcPortaria", sequenceName = "SQ_T_GCO_FUNC_PORTARIA", allocationSize = 1)
public class FuncPortaria implements Serializable {


	private static final long serialVersionUID = -2453330239147934739L;


	public FuncPortaria() {
		this.dataCadastro = LocalDateTime.now();
	}	

	
	public FuncPortaria(String nome, LocalDate dataNascimento, String cpf, String rg,
			List<MovimentacaoPortaria> movimentacaoPortaria) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.movimentacaoPortaria = movimentacaoPortaria;
	}

	
	@Id
	@GeneratedValue(generator = "funcPortaria", strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_FUNC_PORTARIA")
	private Long id;
	
	@Column(name = "NM_FUNCIONARIO", length = 55)
	private String nome;
	
	@Column(name = "DT_NASC")
	private LocalDate dataNascimento;

	@Column(name = "NR_CPF")
	private String cpf;
	
	@Column(name = "NR_RG")
	private String rg;
	
	@Column(name = "DT_CADASTRO")
	private LocalDateTime dataCadastro;
	
	@OneToMany(mappedBy = "funcPortaria", fetch = FetchType.EAGER)
	private List<MovimentacaoPortaria> movimentacaoPortaria;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public List<MovimentacaoPortaria> getMovimentacaoPortaria() {
		return movimentacaoPortaria;
	}

	public void setMovimentacaoPortaria(List<MovimentacaoPortaria> movimentacaoPortaria) {
		this.movimentacaoPortaria = movimentacaoPortaria;
	}

	@Override
	public String toString() {
		return "FuncPortaria \n[nome=" + nome + ", \ndataNascimento=" + dataNascimento + ", \ncpf=" + cpf + ", \nrg=" + rg
				+ "]";
	}

	
}
