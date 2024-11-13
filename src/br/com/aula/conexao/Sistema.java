package br.com.aula.conexao;

import java.sql.Connection;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
    	Connection conexao = ConexaoBD.conectar(); // método para conectar com o banco de dados no servidor Wamp
        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para ler as entradas do usuário.
        int escolherOpcao;
       
        do {
        	// Exibe o menu de opções para o usuário
        	System.out.println("");
        	System.out.println("=== Menu Principal ===");
            System.out.println("1. Inserir Aluno");
            System.out.println("2. Atualizar Aluno");
            System.out.println("3. Deletar Aluno");
            System.out.println("4. Ler registro de Alunos");
            System.out.println("0. Sair");

            escolherOpcao = scanner.nextInt(); // Lê a opção escolhida pelo usuário
            scanner.nextLine(); // Consome a quebra de linha após a leitura do inteiro

            // Executa a ação correspondente à opção escolhida
            switch (escolherOpcao) {
                case 1:
                    InserirDados.main(null); // Chama o método para inserir um novo aluno
                    break;
                case 2:
                    AtualizarDados.main(null); // Chama o método para atualizar os dados de um aluno
                    break;
                case 3:
                    DeletarDados.main(null); // Chama o método para excluir um aluno
                    break;
                case 4:
                    LerDados.main(null); // Chama o método para exibir os registros dos alunos
                    break;
                case 0: // Caso o usuário escolha sair do sistema
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente."); // Exibe mensagem de erro caso a opção seja inválida
            }
        } while (escolherOpcao != 0); // O loop continua até o usuário escolher sair (opção 0)

        scanner.close(); // Fecha o scanner ao final da execução
    }
}