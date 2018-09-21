public class Endereco {

    private String logradouro;
    private String complemento;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;

    public Endereco(String logradouro, String complemento, String numero, String bairro,
            String cidade, String cep) {
        this.logradouro = logradouro.toUpperCase();
        this.complemento = complemento.toUpperCase();
        this.numero = numero.toUpperCase();
        this.bairro = bairro.toUpperCase();
        this.cidade = cidade.toUpperCase();
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro.toUpperCase();
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento.toUpperCase();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero.toUpperCase();
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro.toUpperCase();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade.toUpperCase();
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
