package BancoTechDive;

public class ContaPoupanca extends Conta{

    public ContaPoupanca() {
    }

    public ContaPoupanca(String nomeConta, String cpfConta, double rendaMensalConta, int nrConta, int agenciaConta, double saldoConta) {
        super(nomeConta, cpfConta, rendaMensalConta, nrConta, agenciaConta, saldoConta);
    }
}
