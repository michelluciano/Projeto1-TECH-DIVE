package BancoTechDive;

import java.util.ArrayList;

public class Conta {
    private ArrayList<TransacaoBancaria> transacoes = new ArrayList<>();
    private String nomeConta;
    private String cpfConta;
    private double rendaMensalConta;
    private int nrConta;
    private int agenciaConta;
    private double saldoConta;
    public static int serialConta =0;

    //Construtores
    public Conta() {
    }

    public Conta(String nomeConta, String cpfConta, double rendaMensalConta, int nrConta, int agenciaConta, double saldoConta) {
        this.nomeConta = nomeConta;
        this.cpfConta = cpfConta;
        this.rendaMensalConta = rendaMensalConta;
        this.nrConta = nrConta;
        this.agenciaConta = agenciaConta;
        this.saldoConta = saldoConta;
    }

    //getter e setter


    public ArrayList<TransacaoBancaria> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(ArrayList<TransacaoBancaria> transacoes) {
        this.transacoes = transacoes;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public String getCpfConta() {
        return cpfConta;
    }

    public void setCpfConta(String cpfConta) {
        this.cpfConta = cpfConta;
    }

    public double getRendaMensalConta() {
        return rendaMensalConta;
    }

    public void setRendaMensalConta(double rendaMensalConta) {
        this.rendaMensalConta = rendaMensalConta;
    }

    public int getNrConta() {
        return nrConta;
    }

    public void setNrConta(int nrConta) {
        this.nrConta = nrConta;
    }

    public int getAgenciaConta() {
        return agenciaConta;
    }

    public void setAgenciaConta(int agenciaConta) {
        this.agenciaConta = agenciaConta;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }
    //to string para teste

    @Override
    public String toString() {
        return "Conta{" +
                "nomeConta='" + nomeConta + '\'' +
                ", cpfConta='" + cpfConta + '\'' +
                ", rendaMensalConta=" + rendaMensalConta +
                ", nrConta=" + nrConta +
                ", agenciaConta=" + agenciaConta +
                ", saldoConta=" + saldoConta +
                '}';
    }

    //metodos
    public void sacar(double valor){
        saldoConta = saldoConta - valor;
    }

    public void depositor(double valor){
        this.saldoConta = this.saldoConta + valor;
    }
}
