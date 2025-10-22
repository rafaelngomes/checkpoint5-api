package br.com.fiap.checkpoint5.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PacienteResponse {

    private Long id;
    private String nome;
    private String endereco;
    private String bairro;
    private String email;
    private String telefoneCompleto;
    private LocalDate dataNascimento;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

  public PacienteResponse(Long id, String nome, String endereco, String bairro,
                        String email, String telefoneCompleto, LocalDate dataNascimento,
                        LocalDateTime createdAt, LocalDateTime updatedAt) {
    this.id = id;
    this.nome = nome;
    this.endereco = endereco;
    this.bairro = bairro;
    this.email = email;
    this.telefoneCompleto = telefoneCompleto;
    this.dataNascimento = dataNascimento;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoneCompleto() {
        return telefoneCompleto;
    }

    public void setTelefoneCompleto(String telefoneCompleto) {
        this.telefoneCompleto = telefoneCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
