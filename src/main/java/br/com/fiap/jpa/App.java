package br.com.fiap.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import br.com.fiap.jpa.models.Condominio;
import br.com.fiap.jpa.models.FuncPortaria;
import br.com.fiap.jpa.models.MovimentacaoPortaria;
import br.com.fiap.jpa.models.Portaria;
import br.com.fiap.jpa.models.Visitante;
import br.com.fiap.jpa.service.impl.CondominioServiceImpl;
import br.com.fiap.jpa.service.impl.FuncPortariaServiceImpl;
import br.com.fiap.jpa.service.impl.MovimentacaoPortariaServiceImpl;
import br.com.fiap.jpa.service.impl.PortariaServiceImpl;
import br.com.fiap.jpa.service.impl.VisitanteServiceImpl;

public class App {

	public static void main(String[] args) {
		CondominioServiceImpl condominioService = CondominioServiceImpl.getInstance();
		PortariaServiceImpl portariaService = PortariaServiceImpl.getInstance();
		MovimentacaoPortariaServiceImpl movPortariaService = MovimentacaoPortariaServiceImpl.getInstance();
		VisitanteServiceImpl visitanteService = VisitanteServiceImpl.getInstance();
		FuncPortariaServiceImpl funcService = FuncPortariaServiceImpl.getInstance();

		System.out.println("======================CADASTRA CONDOMINIO======================");
		Condominio c1 = new Condominio("00.000.000/0000-00", LocalDate.of(2020, 1, 22), "Residencia vertical",
				"Condominio Farlalá",null);
		condominioService.cadastrar(c1);

		System.out.println("======================CADASTRO DUAS PORTARIAS======================");
		Portaria p1 = new Portaria("000", "Principal", LocalDate.of(2020, 1, 7), LocalDate.of(2022, 6, 7),null,c1);
		Portaria p2 = new Portaria("000", "Serviço", LocalDate.of(2020, 1, 7), LocalDate.of(2022, 6, 7),null,c1);
		portariaService.cadastrar(p1);
		portariaService.cadastrar(p2);
		
		System.out.println("======================CADASTRO VISITANTES E FUNCIONARIOS======================");
		FuncPortaria f1 = new FuncPortaria("Joel", LocalDate.of(1960, 9, 3), "000.000.000-00", "00.000.000-0",null);
		FuncPortaria f2 = new FuncPortaria("Jasmin", LocalDate.of(1990, 9, 3), "111.111.111-11", "11.111.111-1",null);

		Visitante v1 = new Visitante("Dagoberto", LocalDate.of(1960, 9, 3), "222.222.222-22", "22.222.222-2",null);
		Visitante v2 = new Visitante("Pamela", LocalDate.of(1988, 9, 3), "333.333.333-33", "33.333.333-3",null);
		
		System.out.println("======================OBTER POR ID======================");
		v1 = visitanteService.obter(1L);
		v2 = visitanteService.obter(1l);
		f1 = funcService.obter(1l);
		f2 = funcService.obter(2l);
		
		System.out.println("======================CADASTRO MOVIMENTACOES======================");
		MovimentacaoPortaria m1 = new MovimentacaoPortaria("E",LocalDateTime.of(LocalDate.of(2022, 6, 1), LocalTime.of(15, 0)), v1, f1, p1);
		MovimentacaoPortaria m2 = new MovimentacaoPortaria("E",LocalDateTime.of(LocalDate.of(2022, 6, 1), LocalTime.of(15, 30)), v2, f1, p1);
		MovimentacaoPortaria m3 = new MovimentacaoPortaria("S",LocalDateTime.of(LocalDate.of(2022, 6, 1), LocalTime.of(15, 45)), v2, f1, p1);

		movPortariaService.cadastrar(m1);
		movPortariaService.cadastrar(m2);
		movPortariaService.cadastrar(m3);
		
		System.out.println("======================LISTAR MOVIMENTACOES POR TIPO======================");
		movPortariaService.listarPorTipo("E").forEach(System.out::println);
		movPortariaService.listarPorTipo("S").forEach(System.out::println);

		System.out.println("======================BUSCA VISISTANTES CADASTRADOS NOME/CPF/DATA DE CADASTRO======================");
		visitanteService.listarPorNomeLike("Joel").forEach(System.out::println);
		visitanteService.listarPorCpfEqual("333.333.333-33").forEach(System.out::println);
		visitanteService.listarPorDtCadastro(v1.getDataCadastro()).forEach(System.out::println);
		
	}
	
}
