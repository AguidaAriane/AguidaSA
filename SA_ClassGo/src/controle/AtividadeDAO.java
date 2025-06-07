/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import modelo.Atividade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author aguida_silva
 */
public class AtividadeDAO {
    
    public void cadastrarAtividade(Atividade atividade) throws Exception {
        String sql = "INSERT INTO Atividade (nome, descricao, Turma_idturma, Turma_Professor_idprofessor) "
                   + "VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, atividade.getNome());
            stmt.setString(2, atividade.getDescricao());
            stmt.setInt(3, atividade.getTurma().getIdturma());
            stmt.setInt(4, atividade.getTurma().getProfessor().getIdProfessor());

            stmt.executeUpdate();
        }
    }
    
    public List<Atividade> listarAtividadesPorTurma(int idTurma, int idProfessor) throws SQLException {
    List<Atividade> lista = new ArrayList<>();

    String sql = "SELECT * FROM Atividade WHERE Turma_idturma = ? AND Turma_Professor_idprofessor = ?";

    try (Connection con = Conexao.conectar();
         PreparedStatement stmt = con.prepareStatement(sql)) {

        stmt.setInt(1, idTurma);
        stmt.setInt(2, idProfessor);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Atividade a = new Atividade();
            a.setNome(rs.getString("nome"));
            a.setDescricao(rs.getString("descricao"));

            // opcional: setTurma se precisar
            lista.add(a);
        }
    }

    return lista;
}
    
    
}


    

