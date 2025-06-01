/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import modelo.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
/**
 *
 * @author Usuario
 */
public class ProfessorDAO {
    
    public Professor login(String email, String senha) {
    String sql = "SELECT * FROM Professor WHERE email = ? AND senha = ?";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, email);
        stmt.setString(2, senha);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Professor p = new Professor();
            p.setIdProfessor(rs.getInt("idprofessor"));
            p.setNome(rs.getString("nome"));
            p.setEmail(rs.getString("email"));
            return p;
        } else {
            return null;
        }

    } catch (SQLException e) {
        System.out.println("Erro ao fazer login: " + e.getMessage());
        return null;
    }
}

}
