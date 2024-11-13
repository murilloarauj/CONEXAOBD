package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InserirDados {
    public static void main(String[] args) {
        Connection conexao = ConexaoBD.conectar(); // chama o método para estabelecer conexão com o banco de dados no Wamp
        Scanner scanner = new Scanner(System.in); // inicializa o Scanner para capturar dados inseridos pelo usuário
        if (conexao != null) {
            String sql = "INSERT INTO alunos (nome, idade) VALUES (?, ?)";
            try {
                // Captura o nome e a idade do aluno para inserção
                System.out.print("Digite o nome do aluno: ");
                String nome = scanner.nextLine();

                System.out.print("Digite a idade do aluno: ");
                int idade = scanner.nextInt();

                PreparedStatement stmt = conexao.prepareStatement(sql); // prepara o comando SQL para execução
                stmt.setString(1, nome); // atribui o nome ao primeiro parâmetro
                stmt.setInt(2, idade); // atribui a idade ao segundo parâmetro
                stmt.executeUpdate(); // executa a inserção no banco de dados

                System.out.println("Dados inseridos com sucesso."); // confirma a inserção caso não ocorra erros
            } catch (SQLException e) {
                System.err.println("Erro ao inserir dados: " + e.getMessage()); // mensagem caso ocorra algum problema na inserção
            } finally {
                try {
                    if (conexao != null) conexao.close(); // encerra a conexão com o banco de dados se não for nula
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexão: " + e.getMessage()); // mensagem caso ocorra erro ao encerrar a conexão
                }
            }
        }
    }
}