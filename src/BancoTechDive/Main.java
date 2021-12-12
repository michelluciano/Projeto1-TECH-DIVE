package BancoTechDive;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    //variaveis do sistema
    private static ArrayList<Conta> contas = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    int opcao = 0;
    int agencia = 0;
    int nrConta = 0;
    String nome;
    double rendaMensal;
    double valorTransacao;
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
                    menuRotinaConta();
                    break;
                case 3:
                    menuRelatorios();
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
    public int menuRotinaConta() {
        Conta conta = null;
        TransacaoBancaria transacao =null;
        while (conta == null) {
            System.out.println("Digite o nome ou numero da conta do cliente:");
            auxPesquisa = input.nextLine();
            conta = pesquisarConta(auxPesquisa);
            if (conta == null) {
                System.out.println("Conta não encontrada!\n\n1.Para pesquisar.\n2.Voltar menu anterior");
                opcao = input.nextInt();
                if (opcao == 2) {
                    return 1;
                }
            }//fim if
        }//fin while

        while (true) {
            System.out.println("=========================================");
            System.out.println("         B A N C O   T E C H D I V E     ");
            System.out.println("=========================================");
            System.out.println("Conta selecionada: " + conta.getNrConta());
            System.out.println("Escolha uma opção abaixo " + conta.getNomeConta() + ":");
            System.out.println("1 - Abrir/Alterar conta");
            System.out.println("2 - Realizar Saque");
            System.out.println("3 - Realizar Depósito");
            System.out.println("4 - Verificar Saldo");
            System.out.println("5 - Retirar Extrato da Conta");
            System.out.println("6 - Transferir Valores");
            System.out.println("00 - Voltar");
            System.out.println("=========================================");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    break;
                case 2:
                    System.out.println("Digite o numero da conta:");
                    nrConta = input.nextInt();
                    System.out.println("Digite o valor do saque: R$");
                    valorTransacao = input.nextDouble();
                    conta = pesquisarNrConta(nrConta);
                    if (conta == null) {
                        System.out.println("Conta não existe, SAQUE cancelado!");
                    }else{
                        if(valorTransacao > conta.getSaldoConta()){
                            System.out.println("Saldo insuficiente");
                            System.out.println("Saldo atual:R$"+conta.getSaldoConta());
                        }else {
                            conta.sacar(valorTransacao);
                            TransacaoBancaria.serialTransacao++;
                            transacao = new TransacaoBancaria(conta,TransacaoBancaria.serialTransacao, new Date(),"SAQUE",valorTransacao,'D');
                            conta.getTransacoes().add(transacao);
                            System.out.println("Saque no valor de \nR$"+valorTransacao+"\nRealizado com SUCESSO!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Digite o numero da conta:");
                    nrConta = input.nextInt();
                    System.out.println("Digite o valor do depósito: R$");
                    valorTransacao = input.nextDouble();
                    conta = pesquisarNrConta(nrConta);
                    if (conta == null) {
                        System.out.println("Conta não existe, DEPÓSITO cancelado!");
                    }else{
                        conta.depositor(valorTransacao);
                        TransacaoBancaria.serialTransacao++;
                        transacao = new TransacaoBancaria(conta,TransacaoBancaria.serialTransacao, new Date(),"DEPÓSITO",valorTransacao,'D');
                        conta.getTransacoes().add(transacao);
                        System.out.println("Deposito no valor de \nR$"+valorTransacao+" \nRealizado com SUCESSO!");
                    }
                    break;
            }
        }
    }//MENU RELATORIOS DO SISTEMA

    public void menuRelatorios() {

    }


    // METODOS AUXILIARES PARA NÂO REPETIR CODIGO
    public Conta pesquisarConta(String pesquisaConta) {
        Conta c = null;
        // verifica se a conta existe
        for (int i = 0; i < contas.size(); i++) {
            // pesquisa pelo id
            if (Integer.toString(contas.get(i).getNrConta()).equals(pesquisaConta)) {
                return contas.get(i);
            }
            // pesquisar por nome
            else if (contas.get(i).getNomeConta().contains(pesquisaConta)) {
                return contas.get(i);
            }
        }
        return c;
    }

    private Conta pesquisarNrConta(int nrConta) {
        Conta c = null;
        // verifica se a conta existe
        for (int i = 0; i < contas.size(); i++) {
            // pesquisa pelo id
            if (Integer.toString(contas.get(i).getNrConta()).equals(nrConta)) {
                return contas.get(i);
            }
        }
        return c;
    }
}// FIM MAIN