package br.com.dio.calculadora;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int a = scan.nextInt();
        System.out.print("Digite outro número: ");
        int b = scan.nextInt();


        int somar = somar(a, b);
        int subtrair = subtrair(a, b);
        int multiplicar = multiplicar(a, b);
        float dividir = dividir(a, b);

        System.out.println("Soma: " + somar);
        System.out.println("Subtracao: " + subtrair);
        System.out.println("Multiplicacao: " + multiplicar);
        System.out.println("Divisao: " + dividir);
    }

    public static int somar(int a, int b){
        return a + b;
    }

    public static int subtrair(int a, int b){
        return a - b;
    }

    public static int multiplicar(int a, int b){
        return a * b;
    }

    public static float dividir(float a, float b){
        return a / b;
    }
}
