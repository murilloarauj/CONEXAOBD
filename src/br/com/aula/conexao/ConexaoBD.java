package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static final String URL = "jdbc:MySQL://localhost:3306/aula_java_db"; // URL para acesso ao banco de dados, incluindo o host local e nome do projeto SQL
    private static final String USUARIO = "root"; // usuário com privilégios de administrador
    private static final String SENHA = ""; // senha do administrador

    public static Connection conectar() { 
        Connection conexao = null; // caso a conexão seja bem-sucedida, será atribuída aqui
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // registra o driver JDBC para a conexão entre o Java e o MySQL
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA); // realiza a conexão usando o URL, o usuário e a senha especificados
            System.out.println("Conexão realizada com sucesso."); // mensagem de sucesso para uma conexão bem-sucedida
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado: " + e.getMessage()); // exibe uma mensagem caso o driver não seja localizado
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage()); // mensagem para erros na tentativa de conexão
        }
        return conexao;
    }

    public static void main(String[] args) {
        conectar(); // chama o método para iniciar a conexão
    }
}