package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarDados { 
    public static void main(String[] args) {
        Connection conexao = ConexaoBD.conectar(); // chama o método para estabelecer conexão com o banco de dados no Wamp
        Scanner scanner = new Scanner(System.in); // inicializa o Scanner para capturar dados inseridos pelo usuário
        if (conexao != null) { 
            String sql = "UPDATE alunos SET nome = ?, idade = ? WHERE id = ?"; // define os campos a serem atualizados no banco de dados
            try {
                // solicita ao usuário o ID do aluno a ser atualizado, seguido pelo novo nome e idade
                System.out.print("Digite o ID do aluno que deseja atualizar: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Limpa a quebra de linha após a entrada numérica
                
                System.out.print("Digite o novo nome do aluno: ");
                String nome = scanner.nextLine();
                
                System.out.print("Digite a nova idade do aluno: ");
                int idade = scanner.nextInt();
                
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setString(1, nome); // insere o novo nome no primeiro parâmetro da consulta SQL
                stmt.setInt(2, idade); // insere a nova idade no segundo parâmetro da consulta SQL
                stmt.setInt(3, id); // insere o ID no terceiro parâmetro da consulta SQL
                
                int rowsUpdated = stmt.executeUpdate(); // executa a atualização no banco de dados
                
                if (rowsUpdated > 0) { // verifica se alguma linha foi modificada
                    System.out.println("Registro atualizado com sucesso!"); // mensagem confirmando que o registro foi atualizado com sucesso
                } else {
                    System.out.println("Nenhum registro encontrado com o ID especificado."); // mensagem se o ID não existir no banco de dados
                }
            } catch (SQLException e) {
                System.err.println("Erro ao atualizar dados: " + e.getMessage()); // mensagem caso ocorra erro ao atualizar os dados
            } finally {
                try {
                    if (conexao != null) conexao.close(); // encerra a conexão com o banco de dados, se estiver aberta
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexão: " + e.getMessage()); // mensagem caso ocorra erro ao fechar a conexão
                }
            }
        }
    }
}