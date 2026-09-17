package Organizacao.Model;

import java.sql.Date;

public class UsuarioModel {

    private int idUsuario;
    private String email;
    private String senha;
    private Date primeiroRegistro;
    private String tipoUsuario;
    private String telefone;
    private String nome;

    public UsuarioModel() {}

    public UsuarioModel(int idUsuario, String email, String senha, Date primeiroRegistro, String tipoUsuario, String telefone, String nome) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.senha = senha;
        this.primeiroRegistro = primeiroRegistro;
        this.tipoUsuario = tipoUsuario;
        this.telefone = telefone;
        this.nome = nome;
    }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public Date getPrimeiroRegistro() { return primeiroRegistro; }
    public void setPrimeiroRegistro(Date primeiroRegistro) { this.primeiroRegistro = primeiroRegistro; }

    public String getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(String tipoUsuario) { this.tipoUsuario = tipoUsuario; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}