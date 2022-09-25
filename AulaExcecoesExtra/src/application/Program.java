package application;

import entities.Account;
import exceptions.BusinessException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe os dados da conta.");

        System.out.print("Numero: ");
        int number = scan.nextInt();

        System.out.print("Titular: ");
        scan.nextLine();
        String holder = scan.nextLine();

        System.out.print("Saldo Inicial: ");
        double balance = scan.nextDouble();

        System.out.print("Limite de Saque: ");
        double withdrawLimit = scan.nextDouble();


        System.out.println();
        System.out.print("Informe uma quantia para sacar: ");
        double amount = scan.nextDouble();

        Account acc = new Account(number, holder, balance, withdrawLimit);

        //Exceptions Method (3o)
        try {
            acc.withdraw(amount);
            System.out.printf("Novo saldo: %.2f%n", acc.getBalance());
        }
        catch(BusinessException e){
            System.out.println(e.getMessage());
        }

        //Gambiarra Method (2o)
//        String error = acc.validateWithdraw(amount);
//        if(error != null){
//            System.out.println(error);
//        }
//        else{
//            acc.withdraw(amount);
//            System.out.printf("Novo saldo: %.2f%n", acc.getBalance());
//        }

        //Método "Ruim" (1o)
//        if (amount > acc.getWithdrawLimit()){
//            System.out.println("Erro de Saque: A quantia excede o limite de saque.");
//        }
//        else if(amount > acc.getBalance()){
//            System.out.println("Erro de Saque: Saldo insuficiente.");
//        }
//        else{
//            acc.withdraw(amount);
//            System.out.printf("Novo saldo: %.2f%n", acc.getBalance());
//            //ou
//            //System.out.printf("Novo saldo: " + String.format("%.2f", acc.getBalance()));
//        }

        //Parte se não levasse em conta o if/else (0o)
//        acc.withdraw(amount);
//        System.out.printf("Novo saldo: %.2f%n", acc.getBalance());

        scan.close();
    }
}
