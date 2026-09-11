package Organização.Model;

import java.time.LocalDate;

public class UsuarioModel {
    private int id_usuario;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dt_cadastro;
    private String tp_usuario;

    public UsuarioModel(String nome, String email, String senha, LocalDate dt_cadastro, String tp_usuario) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dt_cadastro = dt_cadastro;
        this.tp_usuario = tp_usuario;
    }

    public UsuarioModel(int id_usuario, String nome, String email, String senha, LocalDate dt_cadastro, String tp_usuario) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dt_cadastro = dt_cadastro;
        this.tp_usuario = tp_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDate getDt_cadastro() {
        return dt_cadastro;
    }

    public String getTp_usuario() {
        return tp_usuario;
    }

    public void setTp_usuario(String tp_usuario) {
        this.tp_usuario = tp_usuario;
    }

    public void setDt_cadastro(LocalDate dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
