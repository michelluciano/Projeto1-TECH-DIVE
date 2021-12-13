package BancoTechDive;

import java.util.Date;

public class TransacaoBancaria {
    private Conta contaT; // conta a qual esta transação pertence
    private Conta contaTdestino; // conta a qual esta transação pertence
    private int idT; // identifica unicamente esta transação
    private Date dataT; // data da transação
    private String historicoT; // descrição da transação
    private double valorT;
    private char letraT; // tipo da conta
    public static int serialTransacao =0;

    public TransacaoBancaria() {
    }

    public TransacaoBancaria(Conta contaT,Conta contaTdestino, int idT, Date dataT, String historicoT, double valorT, char letraT) {
        this.contaT = contaT;
        this.contaTdestino = contaTdestino;
        this.idT = idT;
        this.dataT = dataT;
        this.historicoT = historicoT;
        this.valorT = valorT;
        this.letraT = letraT;
    }

    // getter e setter


    public Conta getContaTdestino() {
        return contaTdestino;
    }

    public void setContaTdestino(Conta contaTdestino) {
        this.contaTdestino = contaTdestino;
    }

    public Conta getContaT() {
        return contaT;
    }

    public void setContaT(Conta contaT) {
        this.contaT = contaT;
    }

    public int getIdT() {
        return idT;
    }

    public void setIdT(int idT) {
        this.idT = idT;
    }

    public Date getDataT() {
        return dataT;
    }

    public void setDataT(Date dataT) {
        this.dataT = dataT;
    }

    public String getHistoricoT() {
        return historicoT;
    }

    public void setHistoricoT(String historicoT) {
        this.historicoT = historicoT;
    }

    public double getValorT() {
        return valorT;
    }

    public void setValorT(double valorT) {
        this.valorT = valorT;
    }

    public char getLetraT() {
        return letraT;
    }

    public void setLetraT(char letraT) {
        this.letraT = letraT;
    }
}
