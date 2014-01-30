package br.com.fiap.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.fiap.bean.AlunoBean;
import br.com.fiap.bo.AlunoBO;

public class Teste {
	
	private static AlunoBO alunoBO = new AlunoBO();
	private static Scanner scann = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int opcao = -1;
		
		while (opcao != 5) {
			System.out.println("-----------------------------");
			System.out.println("\tSelecione uma opção");
			System.out.println("-----------------------------");
			System.out.println("1 - Incluir, 2 - Excluir, 3 - Alterar, 4 - Relatório, 5 - Sair \n");
			
			try{
				opcao = scann.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Apenas números de 1 a 5 são aceitos!");
				e.printStackTrace();
				System.exit(0);
			}
			
			switch (opcao) {
			
			case 1:
				incluirAluno();
				break;
			case 2:
				excluirAluno();
				break;
			case 3:
				alterarAluno();
				break;
			case 4:
				listarAlunos();
				break;
			case 5:
				System.exit(1);
				break;
			default:
				System.out.println("Não é um opção válida! Apenas números entre 1 e 5 são aceitos.");
				break;
			}
		}
	}
	
	public static void incluirAluno() {
		
		System.out.print("\nRM do aluno: ");
		int rm = scann.nextInt();
		System.out.print("\nNome do aluno: ");
		String nome = scann.next();
		System.out.print("\nTurma do aluno: ");
		String turma = scann.next();
		System.out.print("\nAno de entrada: ");
		int ano = scann.nextInt();
		System.out.print("\nStatus do aluno, (0) Inativo, (1) Ativo: ");
		int status = scann.nextInt();
		
		boolean ativo;
		if (status == 1)
			ativo = true;
		else
			ativo = false;
		
		AlunoBean aluno = new AlunoBean(rm, nome, turma, ano, ativo);
		alunoBO.incluirAluno(aluno);
	}
	
	public static void excluirAluno() {
		System.out.print("\nRM do aluno a ser excluído: ");
		int rm = scann.nextInt();
		alunoBO.excluirAluno(rm);
	}
	
	public static void alterarAluno() {
		System.out.print("\nRM do aluno: ");
		int rm = scann.nextInt();
		System.out.print("\nNova turma do aluno: ");
		String novaTurma = scann.next();
		
		alunoBO.alterarAluno(rm, novaTurma);
	}
	
	public static void listarAlunos() {
		List<AlunoBean> alunoLista = alunoBO.listarAlunos();
		for (AlunoBean aBean : alunoLista) {
			
			StringBuilder sb = new StringBuilder();
			sb.append(aBean.getTurma() + "/");
			sb.append(aBean.getAno() + " - ");
			sb.append(aBean.getRm() + "-");
			sb.append(aBean.getNome() + "\n");
			
			System.out.println(sb);
		}
	}
	
}
