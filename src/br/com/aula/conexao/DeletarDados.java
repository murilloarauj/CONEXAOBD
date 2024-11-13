package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletarDados {
    public static void main(String[] args) {
        Connection conexao = ConexaoBD.conectar(); // método que estabelece a conexão com o banco de dados no servidor Wamp
        Scanner scanner = new Scanner(System.in); // inicializa o Scanner para capturar entradas do usuário
        if (conexao != null) {
            String sql = "DELETE FROM Alunos WHERE id = ?"; // instrução SQL para deletar um registro com base no ID fornecido
            System.out.print("Digite o ID do aluno que deseja deletar: ");
            int id = scanner.nextInt(); // recebe o ID do aluno que o usuário quer deletar
            try {
                PreparedStatement stmt = conexao.prepareStatement(sql); // prepara a consulta SQL para execução
                stmt.setInt(1, id); // insere o ID no parâmetro da instrução SQL
                int rowsDeleted = stmt.executeUpdate(); // executa a instrução SQL e retorna o número de linhas afetadas
                if (rowsDeleted > 0) { // verifica se alguma linha foi excluída
                    System.out.println("Registro deletado com sucesso!"); // mensagem de confirmação de exclusão
                } else {
                    System.out.println("Nenhum registro encontrado com o ID especificado."); // mensagem caso o ID não seja encontrado
                }
            } catch (SQLException e) {
                System.err.println("Erro ao deletar dados: " + e.getMessage()); // mensagem caso ocorra algum erro durante a exclusão
            } finally {
                try {
                    if (conexao != null) conexao.close(); // encerra a conexão com o banco de dados se estiver aberta
                } catch (SQLException c) {
                    System.err.println("Erro ao fechar conexão: " + c.getMessage()); // mensagem caso ocorra erro ao fechar a conexão
                }
            }
        }
    }
}