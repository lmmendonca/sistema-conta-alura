package br.com.banco.dados;

public class Cliente {
    private String   nome;
    private String   cpf;
    private String   rg;
    private Endereco endereco;
    private String   estadoCivil;
    private String   profissao;
    private String   dataNascimento;
    private String   email;

    public Cliente(String nome, String cpf, String rf, Endereco endereco, String estadoCivil,
            String profissao,
            String dataNascimento, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rf;
        this.endereco = endereco;
        this.estadoCivil = estadoCivil;
        this.profissao = profissao;
        this.dataNascimento = dataNascimento;
        this.email = email;
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
