package br.com.sobrecarga;

public class Quadrilatero {
    public static void area(double lado) {
        System.out.println("Area do Quadrado: " + lado*lado);
    }

    public static void area(double lado1, double lado2) {
        System.out.println("Area do Retangulo: " + lado1*lado2);
    }

    public static void area(double baseMaior, double baseMenor, double altura) {
        System.out.println("Area do Trapezio: " + ((baseMaior+baseMenor) * altura) / 2);
    }

    public static void area(float diagonal1, float diagonal2) {
        System.out.println("Area do Losango: " + (diagonal1*diagonal2)/2);
    }
}

class Quadrilatero2{
    public static double area(double lado) {
        return lado*lado;
    }

    public static double area(double lado1, double lado2) {
       return lado1*lado2;
    }

    public static double area(double baseMaior, double baseMenor, double altura) {
       return ((baseMaior+baseMenor) * altura) / 2;
    }

    public static float area(float diagonal1, float diagonal2) {
       return (diagonal1*diagonal2)/2;
    }
}
