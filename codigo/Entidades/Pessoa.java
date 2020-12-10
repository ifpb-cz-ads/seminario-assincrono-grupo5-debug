package Entidades;

import java.time.LocalDate;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private LocalDate nascimento;
    private String sexo;
    private int idade;

    public Pessoa(String nome, String cpf, LocalDate nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return nome;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }



    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", nascimento=" + nascimento +
                '}';
    }

    public void nomeEhGrande(String nome) {
      System.out.println("\nO nome " + nome + " tem " + nome.length() + " caracteres.\n");
    }
}
