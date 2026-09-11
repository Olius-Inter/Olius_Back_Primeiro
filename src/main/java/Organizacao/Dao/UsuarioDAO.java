package Organização.Dao;

import Organização.Model.UsuarioModel;
import Organização.Conexao_Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // 1. CREATE
    public void inserirUsuario(UsuarioModel usuario) {
        String sql = "INSERT INTO usuario (nome, email, senha, dt_cadastro, tp_usuario) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexao = Conexao_Banco.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setDate(4, java.sql.Date.valueOf(usuario.getDt_cadastro()));
            stmt.setString(5, usuario.getTp_usuario());
            stmt.executeUpdate();
            System.out.println("Usuário cadastrado com sucesso!");




        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }
    //2.READ
    public List<UsuarioModel> listarUsuarios() {
        List<UsuarioModel> ListaUsuario = new ArrayList<>();
        String sql = "SELECT * FROM Usuario Order By id_usuario";

        try(Connection conexao = Conexao_Banco.conectar();
            PreparedStatement stmt  = conexao.prepareStatement(sql);
            ResultSet rs  = stmt.executeQuery()){
            while(rs.next()){
                int id_usuario = rs.getInt("id_usuario");
                String   nome = rs.getString("nome");
                String  email = rs.getString("email");
                String  senha = rs.getString("senha");
                LocalDate dt_cadastro = rs.getObject("dt_cadastro", LocalDate.class);
                String   tp_usuario = rs.getString("tp_usuario");

                UsuarioModel novoUsuario = new UsuarioModel(id_usuario, nome, email, senha, dt_cadastro, tp_usuario);
                ListaUsuario.add(novoUsuario);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ListaUsuario;
    }


    // 3. UPDATE
    public void atualizarUsuario(UsuarioModel usuario) {
        String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ?, dt_cadastro = ?, tp_usuario = ? WHERE id = ?";

        try (Connection conexao = Conexao_Banco.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setDate(4, java.sql.Date.valueOf(usuario.getDt_cadastro()));
            stmt.setString(5, usuario.getTp_usuario());



            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Usuário atualizado com sucesso!");
            } else {
                System.out.println("Nenhum usuário encontrado com esse ID.");
            }

        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    // 4. DELETE
    public void deletarUsuario(int id) {
        String sql = "DELETE FROM usuario WHERE id = ?";

        try (Connection conexao = Conexao_Banco.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

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