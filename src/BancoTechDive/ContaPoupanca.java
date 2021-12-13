package BancoTechDive;

public class ContaPoupanca extends Conta{

    public ContaPoupanca() {
    }

    public ContaPoupanca(String nomeConta, String cpfConta, double rendaMensalConta, int nrConta, int agenciaConta, double saldoConta) {
        super(nomeConta, cpfConta, rendaMensalConta, nrConta, agenciaConta, saldoConta);
    }

    public void rendimentoPoupanca(int mes, double valor){
        double aux;
        aux = (valor*0.05)*mes;
        System.out.println("Valor do rendimento em "+mes+" é: R$"+aux);
    }
}
