package BancoTechDive;

import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
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
    private double limiteConta;

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


    public double getLimiteConta() {
        return limiteConta;
    }

    public void setLimiteConta(double limiteConta) {
        this.limiteConta = limiteConta;
    }

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
                "}\n";
    }

    //metodos
    public void sacar(double valor){
        saldoConta = saldoConta - valor;
    }

    public void depositar(double valor){
        this.saldoConta = this.saldoConta + valor;
    }

    public void saldo(Conta conta,int numConta){
        System.out.println("");
        System.out.println("++++++++++++++++ Saldo da Conta Bancária+++++++++++++++++++");
        System.out.println(" - Saldo                   \t R$ " + conta.getSaldoConta());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("");
    }

    public void extrato(Conta conta, int numConta){
        NumberFormat nf = NumberFormat.getCurrencyInstance(); // para formatar a moeda
        Format formato = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++ Extrato Conta ++++++++++++++++++++++++++++");
        System.out.println(" - Nome Cliente      \t\t\t    " + conta.getNomeConta());
        System.out.println(" - Número da CPF     \t\t\t    " + conta.getCpfConta());
        System.out.println(" - Número da conta   \t\t\t    " + conta.getNrConta());
        System.out.println(" - Agência           \t\t\t    " + ((conta.getAgenciaConta()== 1) ? "001 - Florianópolis":"002 - São Jose"));
        System.out.println(" - Saldo             \t\t\t R$ " + conta.getSaldoConta());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("DATA         HISTÓRICO         DOC       VALOR                 ");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        for(int i = 0; i < conta.getTransacoes().size(); i++){
            TransacaoBancaria tb = conta.getTransacoes().get(i); // representa a transação da iteração atual

            String valorFormatado = nf.format(tb.getValorT());
            System.out.println(
                    formato.format(tb.getDataT()) + "  "
                  + String.format("%-20s", tb.getHistoricoT()) +
                    String.format("%1$5s", tb.getIdT()).replace(' ', '0') +
                    String.format("%10s", valorFormatado.replace("R$ ", "")) + " "+tb.getLetraT());
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        String valorFormatado = nf.format(conta.getSaldoConta());
        System.out.println("SALDO ATUAL:" + String.format("%36s", valorFormatado.replace("R$ ", "")));
        valorFormatado = nf.format(conta.getLimiteConta());
        System.out.println("LIMITE:" + String.format("%41s", valorFormatado.replace("R$ ", "")));
        valorFormatado = nf.format(conta.getSaldoConta() + conta.getLimiteConta());
        System.out.println("SALDO + LIMITE:" + String.format("%33s", valorFormatado.replace("R$ ", "")));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

}//FECHA CONTA
