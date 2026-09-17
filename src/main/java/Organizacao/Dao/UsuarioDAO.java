package Organizacao.Dao;

import Organizacao.Conexo.Conexao_Banco;
import Organizacao.Model.B2bModel;
import Organizacao.Model.UsuarioModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
// create
    public void salvar(UsuarioModel usuario) throws Exception {
        String sql = "INSERT INTO usuario (email, senha, primeiro_registro, tipo_usuario, telefone, nome) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao_Banco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());
            stmt.setDate(3, usuario.getPrimeiroRegistro());
            stmt.setString(4, usuario.getTipoUsuario());
            stmt.setString(5, usuario.getTelefone());
            stmt.setString(6, usuario.getNome());

            stmt.executeUpdate();
        }
    }
// read
    public List<UsuarioModel> listar() throws Exception {
        List<UsuarioModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (Connection conn = Conexao_Banco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                UsuarioModel u = new UsuarioModel(
                        rs.getInt("id_usuario"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getDate("primeiro_registro"),
                        rs.getString("tipo_usuario"),
                        rs.getString("telefone"),
                        rs.getString("nome")
                );
                lista.add(u);
            }
        }
        return lista;
    }
    //UPDATE
    public void atualizarB2b(B2bModel b2b) {
        String sql = "UPDATE Usuario SET id_usuario = ?, email = ?," +
                " senha = ?, primerio_registro = ?, tipo_usuario = ?, telefone = ?, nome = ? WHERE id_usuario = ?";

        try (Connection conexao = Conexao_Banco.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, b2b.getCnpj());
            stmt.setString(2, b2b.getRazao_social());
            stmt.setString(3, b2b.getNome_fantasia());
            stmt.setString(4, b2b.getTelefone());
            stmt.setInt(5, b2b.getId_usuario());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("usuario atualizado com sucesso!");
            } else {
                System.out.println("Nenhum registro de usuario encontrado com o ID informado.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar usuário: " + e.getMessage(), e);
        }
}
// delete
    public void deletarUsuario(int id_Usuario) {
        String sql = "DELETE FROM Usuario WHERE id_Usuario = ?";

        try (Connection conexao = Conexao_Banco.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id_Usuario);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Usuário deletado com sucesso!");
            } else {
                System.out.println("Nenhum usuário encontrado com esse ID para deletar.");
            }

        } catch (Exception e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }
}