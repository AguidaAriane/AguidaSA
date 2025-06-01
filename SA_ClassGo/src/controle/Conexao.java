/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aguida_silva
 */
public class Conexao {
    
     public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/banco_sa";
        String usuario = "root";
        String senha = "";
        Connection conexao = null;

        try {
            // Registrar o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Estabelecer a conexão
            System.out.println("Conectando ao banco de dados...");
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida com sucesso!");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver MySQL JDBC não encontrado");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados");
            e.printStackTrace();
        } finally {
            // Fechar a conexão
            try {
                if (conexao != null) {
                    conexao.close();
                    System.out.println("Conexão fechada");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static Connection conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/cadastro";
        String usuario = "root";
        String senha = ""; // Coloque sua senha aqui

        return DriverManager.getConnection(url, usuario, senha);
    }
}
