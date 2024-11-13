package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LerDados {
    public static void main(String[] args) {
        Connection conexao = ConexaoBD.conectar(); // estabelece a conexão com o banco de dados no servidor Wamp
        if (conexao != null) { // verifica se a conexão foi bem-sucedida
            String sql = "SELECT * FROM alunos"; // instrução SQL para selecionar todos os registros da tabela 'alunos'
            try {
                PreparedStatement stmt = conexao.prepareStatement(sql); // prepara a instrução SQL para execução
                ResultSet rs = stmt.executeQuery(); // executa a consulta e armazena os resultados no ResultSet
                
                // imprime os dados recuperados da tabela 'alunos' com os parâmetros id, nome e idade
                System.out.println("Registros da tabela 'alunos':");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    int idade = rs.getInt("idade");
                    
                    System.out.println("ID: " + id + ", Nome: " + nome + ", Idade: " + idade); // exibe as informações dos alunos para o usuário
                }
            } catch (SQLException e) {
                System.err.println("Erro ao ler dados: " + e.getMessage()); // mensagem de erro caso a leitura dos dados falhe
            } finally { // bloco que garante o fechamento da conexão
                try {
                    if (conexao != null) conexao.close(); // fecha a conexão caso ela esteja aberta
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexão: " + e.getMessage()); // mensagem de erro ao fechar a conexão
                }
            }
        }
    }
}