import javax.swing.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Cliente nome = new Cliente();
        Conta cp = new ContaPoupanca(nome);
        Conta cc = new ContaCorrente(nome);

        System.out.print("Nome do titular: ");
        nome.setNome(new Scanner(System.in).nextLine());

        System.out.println("Agencia: " + cc.getAgencia());

        System.out.print("\nSaldo inexistente, deposite dinheiro na conta antes de prosseguir..." +
                        "\nR$");
        double deposito = new Scanner(System.in).nextDouble();
        cc.depositar(deposito);
        cc.imprimirExtrato();

        System.out.print("""

            Qual operação deseja fazer?
            1 - Transferir para Conta Poupança.
            2 - Sacar dinheiro.
            3 - Depositar na conta corrente
            Opção:\040""");


        boolean perguntarDeNovo = true;
        do{
            String opcao = new Scanner(System.in).nextLine();
            switch(opcao){
                case "1":
                    System.out.print("\nValor a ser transferido para a a Conta Poupança: \nR$");
                    double transferencia = new Scanner(System.in).nextDouble();

                    try {
                        cc.transferir(transferencia, cp);
                        cc.imprimirExtrato();
                        cp.imprimirExtrato();
                        break;
                    } catch (BusinessException e) {
                        System.out.println("\n" + e.getMessage());
                    }

                case "2":
                    System.out.print("\nValor a ser sacado da Conta Corrente: R$");
                    double quantidadeSaque = new Scanner(System.in).nextDouble();

                    try{
                        cc.sacar(quantidadeSaque);
                        System.out.printf("\nSaldo atualizado da Conta Corrente: R$%.2f%n", cc.getSaldo());
                        cc.imprimirExtrato();
                        break;

                    }
                    catch(BusinessException e){
                        System.out.println("\n" + e.getMessage());
                    }

                case "3":
                    System.out.print("\nQuanto deseja depositar? \nR$");
                    cc.depositar(new Scanner(System.in).nextDouble());
                    cc.imprimirExtrato();
                    break;
            }

            System.out.println("\nDeseja fazer outra operação (SIM/NÃO)?");
            String choice = new Scanner(System.in).nextLine();

            if(choice.equalsIgnoreCase("SIM")){
                System.out.print("""

                Qual operação deseja fazer?
                1 - Transferir para Conta Poupança.
                2 - Sacar dinheiro.
                3 - Depositar na conta corrente.
                Opção:\040""");
            }
            else{
                perguntarDeNovo = false;
                System.out.println("\nObrigado por utilizar nossos serviços!");
            }
        }while(perguntarDeNovo);




    }
}

