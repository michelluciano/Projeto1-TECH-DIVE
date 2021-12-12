package BancoTechDive;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //variaveis do sistema
    private static ArrayList<Conta> contas = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    int opcao = 0;
    int agencia = 0;
    Conta auxConta = null;
    String auxPesquisa;

    public static void main(String[] args) {
        Main principal = new Main();
        principal.menuInicial();
    }

    //Menu inicial do sistema
    public void menuInicial() {
        while (true) {
            System.out.println("=========================================");
            System.out.println("         B A N C O   T E C H D I V E     ");
            System.out.println("=========================================");
            System.out.println("Escolha uma opção abaixo:");
            System.out.println("1 - Gerencias Contas");
            System.out.println("2 - Rotinas da Conta");
            System.out.println("3 - Relatório do sistema");
            System.out.println("00 - Sair do Sistema");
            System.out.println("=========================================");
            opcao = Integer.parseInt(input.nextLine());
            //input.nextLine(); // corrigido o bug de pular entrada
            switch (opcao) {
                case 1:
                    menuGerenciarContas();
                    break;
                case 2:
                    nemuRotinaConta();
                    break;
                case 3:
                    nemuRelatorios();
                    break;
                case 00:
                    System.out.println("Saindo do Sistema B A N C O   T E C H D I V E");
                    System.exit(0);
                    break;
            }//fim switch
        }// fim while
    }// fim menu inicial

    // MENU GERENCIAR CONTAS
    public void menuGerenciarContas() {
        do {
            System.out.println("=========================================");
            System.out.println("         B A N C O   T E C H D I V E     ");
            System.out.println("=========================================");
            System.out.println("Escolha uma opção abaixo:");
            System.out.println("1 - Cadastrar contas");
            System.out.println("2 - Listar contas");
            System.out.println("3 - Pesquisar Cliente");
            System.out.println("4 - Excluir Cliente");
            System.out.println("5 - Atualizar dados do Cliente");
            System.out.println("00 - Voltar");
            System.out.println("=========================================");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    //cadastrar contas
                    System.out.print("\nDigite o nome do cliente: ");
                    String nome = input.nextLine();
                    System.out.print("Digite o CPF: ");
                    String cpf = input.nextLine();
                    System.out.println("Digite a renda mensal:");
                    double rendaMensal = input.nextDouble();
                    System.out.println("Digite a Agencia:\n001 - Florianópolis\n002 - São José");
                    agencia = input.nextInt();
                    System.out.println("Digite o valor do primeiro deposito:");
                    double saldoInicial = input.nextDouble();
                    Conta.serialConta++; //incrementar o contador de contas
                    Conta c = new Conta(nome, cpf, rendaMensal, Conta.serialConta, agencia, saldoInicial);
                    contas.add(c); //adiciona no ArrayList de contas
                    // e finalmente mostramos uma mensagem de sucesso.
                    System.out.println("\nA pessoa foi criada com sucesso");
                    System.out.println(contas);
                    break;
                case 2:
                    // listar
                    System.out.println("-------LISTA DE CLIENTES-------");
                    if (contas.isEmpty()) {
                        System.out.println("Não existem clientes cadastrados.");
                    } else {
                        for (int i = 0; i < contas.size(); i++) {
                            auxConta = contas.get(i);
                            System.out.println("------------------------------------");
                            System.out.println(" - Id:             \t" + auxConta.getNrConta());
                            System.out.println(" - Ag:             \t" + auxConta.getAgenciaConta());
                            System.out.println(" - Nome:           \t" + auxConta.getNomeConta());
                            System.out.println(" - CPF:            \t" + auxConta.getCpfConta());
                            System.out.println(" - Reanda Mensal:  \t" + auxConta.getRendaMensalConta());
                            System.out.println(" - Saldo da Conta: \t" + auxConta.getSaldoConta());
                        }
                    }
                    System.out.println("--------------------------------");
                    break;
                case 3:
                    //pesquisar
                    System.out.println("Digite o Codigo Identificador do cliente:");
                    auxPesquisa = input.nextLine();
                    auxConta = pesquisarConta(auxPesquisa);
                    if (auxConta == null) {
                        System.out.println("\nCliente não encontrado.");
                    } else {
                        System.out.println("------------------------------------");
                        System.out.println(" - Id:             \t" + auxConta.getNrConta());
                        System.out.println(" - Ag:             \t" + auxConta.getAgenciaConta());
                        System.out.println(" - Nome:           \t" + auxConta.getNomeConta());
                        System.out.println(" - CPF:            \t" + auxConta.getCpfConta());
                        System.out.println(" - Reanda Mensal:  \t" + auxConta.getRendaMensalConta());
                        System.out.println(" - Saldo da Conta: \t" + auxConta.getSaldoConta());
                    }

                    break;
                case 4:
                    //excluir
                    System.out.println("Digite o Codigo Identificador do cliente a ser excluido:");
                    auxPesquisa = input.nextLine();
                    auxConta = pesquisarConta(auxPesquisa);
                    if (auxConta == null) {
                        System.out.println("\nCliente não encontrado.");
                    } else {
                        System.out.println("------------------------------------");
                        System.out.println(" - Id:             \t" + auxConta.getNrConta());
                        System.out.println(" - Ag:             \t" + auxConta.getAgenciaConta());
                        System.out.println(" - Nome:           \t" + auxConta.getNomeConta());
                        System.out.println(" - CPF:            \t" + auxConta.getCpfConta());
                        contas.remove(auxConta);
                        System.out.println("-----CONTA EXCLUÍDA COM SUCESSO---");
                    }
                    break;
                case 5:
                    //atualizar
                    System.out.println("Digite o Codigo Identificador do cliente a ser atualizado:");
                    auxPesquisa = input.nextLine();
                    auxConta = pesquisarConta(auxPesquisa);
                    if (auxConta == null) {
                        System.out.println("\nCliente não encontrado.");
                    } else {
                        System.out.println("------Dados Atuais-----------");
                        System.out.println(" - Id:             \t" + auxConta.getNrConta());
                        System.out.println(" - Ag:             \t" + auxConta.getAgenciaConta());
                        System.out.println(" - Nome:           \t" + auxConta.getNomeConta());
                        System.out.println(" - CPF:            \t" + auxConta.getCpfConta());
                        System.out.println("-----------------------------");
                        System.out.println("---Atualize os novos dados---");
                        System.out.print("\nDigite o nome do cliente: ");
                        nome = input.nextLine();
                        System.out.println("Digite a renda mensal:");
                        rendaMensal = input.nextDouble();
                        System.out.println("Digite a Agencia:\n001 - Florianópolis\n002 - São José");
                        agencia = input.nextInt();
                        auxConta.setNomeConta(nome);
                        auxConta.setRendaMensalConta(rendaMensal);
                        auxConta.setAgenciaConta(agencia);
                        System.out.println("-----DADOS ATUALIZADOS COM SUCESSO---");
                    }
            }
        } while (opcao != 00);
    }// FIM menuGerenciarContas

    // MENU ROTINAS DA CONTA
    public void nemuRotinaConta() {
        Conta conta = null;
        while (conta == null) {
            System.out.println("Digite o nome ou numero da conta do cliente:");
            auxPesquisa = input.nextLine();
            conta = pesquisarConta(auxPesquisa);
        }

        while (true) {
            System.out.println("=========================================");
            System.out.println("         B A N C O   T E C H D I V E     ");
            System.out.println("=========================================");
            System.out.println("Escolha uma opção abaixo:");
            System.out.println("1 - Abrir/Alterar conta");
            System.out.println("2 - Sacar");
            System.out.println("3 - Depositar");
            System.out.println("4 - Saldo");
            System.out.println("5 - Extrato");
            System.out.println("6 - Transferir");
            System.out.println("7 - Relatórios");
            System.out.println("8 - Sair");
            System.out.println("=========================================");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
            }
        }
    }//MENU RELATORIOS DO SISTEMA
    public void nemuRelatorios(){

    };


    // METODOS AUXILIARES PARA NÂO REPETIR CODIGO
    public Conta pesquisarConta(String pesquisaConta){
        Conta c = null;
        // verifica se a conta existe
        for(int i = 0; i < contas.size(); i++){
            // pesquisa pelo id
            if(Integer.toString(contas.get(i).getNrConta()).equals(pesquisaConta)){
                return contas.get(i);
            }
            // pesquisar por nome
            else if(contas.get(i).getNomeConta().contains(pesquisaConta)){
                return contas.get(i);
            }
        }
        return c;
    }

}
