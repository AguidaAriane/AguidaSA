/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import modelo.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Usuario
 */
public class TurmaDAO {
    
    public void cadastrarTurma(Turma t){
        
        String sql = "INSERT INTO Turma(nome , Professor_idprofessor) VALUES (? , ?)";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, t.getNome());
            stmt.setInt(2, t.getProfessor().getIdProfessor());
            stmt.executeUpdate();
            System.out.println("Cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    
   public List<Turma> listarTurma(int idProfessor) {
    List<Turma> listaTurma = new ArrayList<>();

    String sql = "SELECT idturma, nome FROM Turma WHERE Professor_idprofessor = ?";

    try (Connection con = Conexao.conectar();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setInt(1, idProfessor);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            int idturma = rs.getInt("idturma");
            String nome = rs.getString("nome");

            Turma turma = new Turma();
            turma.setIdturma(idturma);
            turma.setNome(nome);

            listaTurma.add(turma);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return listaTurma;
    }

    
    
            
        
        
    }

