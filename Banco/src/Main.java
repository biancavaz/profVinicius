import java.util.Scanner;

public class Main {


    public static ContaCorrente contaCorrente = new ContaCorrente();
    public static ContaPoupanca contaPoupanca = new ContaPoupanca();
    private static  Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("BEM VINDO AO BANCO SUTTER");
        inicio();

    }

    public static void inicio (){
        do {
            opcoesMenu();
            int opcao = sc.nextInt();
            exibirMenu(opcao);

        } while (true);
    }

    public static void opcoesMenu (){
        System.out.println("""
                1 - CONTA CORRENTE
                2 - CONTA POUPANÇA
                3 - SAIR 
                """);
    }

    public static void exibirMenu (int opcao) {
        switch (opcao) {
            case 1: {
                int opcaoContaCorrente;
                do {
                    opcoesContaCorrente();
                    opcaoContaCorrente = sc.nextInt();
                    exibirContaCorrente(opcaoContaCorrente);
                } while (opcaoContaCorrente !=5);
            }
            case 2: {
                int opcaoContaPoupanca;
                do{
                    opcoesContaPoupanca();
                    opcaoContaPoupanca = sc.nextInt();
                    exibirContaPoupanca(opcaoContaPoupanca);

                } while (opcaoContaPoupanca !=6);
            }
            case 3: {
                System.out.println("Até mais!");
                System.exit(0);
            }
            default: {
                System.out.println("Opção inválida!");
            }
        }
    }

    public static void opcoesContaCorrente (){
        System.out.println("""
                1 - Depositar
                2 - Sacar
                3 - Transferir
                4 - Exibir Saldo
                5 - sair
                """);
    }

    public static void exibirContaCorrente (int opcao) {
        switch (opcao) {
            case 1: {
                System.out.println("valor a ser depositado: ");
                int valorDepositado = sc.nextInt();

                contaCorrente.depositar(valorDepositado);
                System.out.println("Valor depositado com sucesso!");
                break;
            }
            case 2: {
                System.out.println("valor a ser sacado: ");
                int valorSacado = sc.nextInt();

                contaCorrente.sacar(valorSacado);
                System.out.println("Valor sacado com sucesso!");
                break;
            }
            case 3: {
                System.out.println("Valor a ser transferido: ");
                int valorTransferido = sc.nextInt();

                contaCorrente.transferir(contaPoupanca, valorTransferido);
                System.out.println("Valor transferido com sucesso!");
                break;
            }
            case 4: {
                contaCorrente.exibirSaldo();
                break;
            }
            case 5: {
                inicio();
                break;
            }
        }
    }

    public static void opcoesContaPoupanca (){
        System.out.println("""
                1 - Depositar
                2 - Sacar
                3 - Transferir
                4 - Exibir Saldo
                5 - Calcular rendimento
                6 - sair
                """);
    }

    public static void exibirContaPoupanca (int opcao) {
        switch (opcao) {
            case 1: {
                System.out.println("valor a ser depositado: ");
                int valorDepositado = sc.nextInt();

                contaPoupanca.depositar(valorDepositado);
                System.out.println("Valor depositado com sucesso!");
                break;
            }
            case 2: {
                System.out.println("valor a ser sacado: ");
                int valorSacado = sc.nextInt();

                contaPoupanca.sacar(valorSacado);
                System.out.println("Valor sacado com sucesso!");
            }
            case 3: {
                System.out.println("Valor a ser transferido: ");
                int valorTransferido = sc.nextInt();

                contaPoupanca.transferir(contaCorrente, valorTransferido);
                System.out.println("Valor transferido com sucesso!");
                break;
            }
            case 4: {
                contaPoupanca.exibirSaldo();
                break;
            }
            case 5: {
                contaPoupanca.CalcularRendimento();
                break;
            }
            case 6: {
                inicio();
                break;
            }
        }
    }


}