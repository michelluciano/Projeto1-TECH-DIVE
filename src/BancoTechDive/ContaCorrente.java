package BancoTechDive;

public class ContaCorrente extends Conta{

    private double valorChequeEs = 15*getRendaMensalConta()/100;

    public ContaCorrente(double valorChequeEs) {
        this.valorChequeEs = valorChequeEs;
    }

    public ContaCorrente(String nomeConta, String cpfConta, double rendaMensalConta, int nrConta, int agenciaConta, double saldoConta, double valorChequeEs) {
        super(nomeConta, cpfConta, rendaMensalConta, nrConta, agenciaConta, saldoConta);
        this.valorChequeEs = valorChequeEs;
    }

    //getter e setter
    public double getValorChequeEs() {
        return valorChequeEs;
    }

    public void setValorChequeEs(double valorChequeEs) {
        this.valorChequeEs = valorChequeEs;
    }
}
