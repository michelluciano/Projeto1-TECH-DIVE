package BancoTechDive;

public class Pessoa {
    private int idPessoa;
    private String nome;
    private String cpf;
    public static int serialPessoas =0;

    // construtores
    public Pessoa() {
    }

    public Pessoa(int idPessoa, String nome, String cpf) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.cpf = cpf;
    }


    //getter e setter


    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
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

    @Override
    public String toString() {
        return "Pessoa{" +
                "idPessoa=" + idPessoa +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
