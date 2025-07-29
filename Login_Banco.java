package LoginBanco;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Login_Banco {

    static boolean continuar = true;

    private static double saldo = 0.0;
    private static ArrayList<String> extrato = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        boolean continuar = true;

        final String CPF_CONTA = "222.333.444-21";
        final String SENHA_CONTA = "234432";

        int tentativa = 0;
        final int MAX_TENTATIVA = 3;

        while(continuar) {
            System.out.println("\n===CONTA=BANCÁRIA=PAN===");
            System.out.println(" 1 - Fazer login");
            System.out.println(" 2 - Entrar com outra conta");
            System.out.println(" 3 - Sair");
            System.out.println("============================");
            int opcao = scan.nextInt();
            scan.nextLine();

            switch(opcao) {
                case 1: 
                    while(tentativa < MAX_TENTATIVA) {
                        System.out.print("\nDigite o seu CPF: ");
                        String cpfDigitar = scan.nextLine();
                        System.out.print("\nDigite sua senha: ");
                        String senhaDigitar = scan.nextLine();
                        if(cpfDigitar.equals(CPF_CONTA) && senhaDigitar.equals(SENHA_CONTA)) {
                            System.out.println("Login realizado com sucesso.");
                            entrarNaConta(scan);
                        } else {
                            System.out.println("Tente mais uma vez!");
                            tentativa++;
                        }

                        if(tentativa == MAX_TENTATIVA) {
                            System.out.println("Conta bloqueada!");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Informe o seu CPF: ");
                    String informeCpf = scan.nextLine();

                    System.out.println("Digite sua senha: ");
                    String informeSenha = scan.nextLine();
                    
                    entrarComOutraConta(scan);
                    break;
                case 3: 
                        continuar = false;
                        System.out.println("Saindo do aplicativo.");
                        break;
                default: 
                        System.out.println("Opção errada.");
            }
        }
        scan.close();
    }

    public static void entrarNaConta(Scanner scan) {
                 System.out.println("\n===DENTRO DA CONTA===");
        System.out.println(" 1 - Ver saldo na colta");
        System.out.println(" 2 - Extrato da conta");
        System.out.println(" 3 - Depositar");
        System.out.println("==============================");
        System.out.println();
        System.out.println("==============================");
        System.out.println(" 4 - Poupança");
        System.out.println(" 5 - Emprestimo");
        System.out.println(" 6 - FGTF");
        System.out.println("==============================");
        System.out.println();
        System.out.println("==============================");
        System.out.println(" 7 - Cartão de crédito");
        System.out.println(" 8 - Meus benefícios");
        System.out.println(" 9 - Investimento");
        System.out.println("==============================");
        System.out.println(" 10 - Sair da conta");
        int menu = scan.nextInt();
        scan.nextLine();

        switch(menu) {
            case 1: 
                verSaldoNaConta();
                break;
            case 2:
                extratoDaConta();
                break;
            case 3: 
                fazerDeposito(scan);
                break;
            //case 4: 
             //   poupanca(scan);
             //   break;
            //case 5:
            //    emprestimo(scan);
             //   break;
            //case 6:
            //    fgtf(scan);
             //   break;
            //case 7:
            //    cartaoDeCredito(scan);
             //   break;
            //case 8:
            //    muesBeneficios(scan);
             //   break;
           // case 9:
           //     investimento(scan);
           //     break;
            //case 10:
            //     continuar = false;
            //            System.out.println("Saindo do aplicativo.");
            //            break;
        }
    }

    public static void verSaldoNaConta() {
        System.out.printf("Seu saldo atualmente é: %.2.fR$\n", saldo);
    }
    public static void extratoDaConta() {
        if(extrato.isEmpty()){
            System.out.println("Extrato vazio. Nenhuma movimentação registrada.");
        } else {
            System.out.println("=====EXTRATO=DA=CONTA=====");
            for(String operacao : extrato) {
                System.out.println(operacao);
            }
        }
    }
    public static void fazerDeposito(Scanner scan) {
        System.out.println("Quanto que deseja depositar: R$");
        double depositar = scan.nextDouble();
        scan.nextLine();
        if(depositar > 0) {
            saldo+= depositar;
            String registro = String.format("Depósito de R$ %.2f.", depositar);
            extrato.add(registro);
            System.out.println("Depósito realizado com sucesso.");
            verSaldoNaConta();
        } else {
            System.out.println("Valor inválido para depósito");
        }
    }
   

    public static void entrarComOutraConta(Scanner scan) {

    }

}