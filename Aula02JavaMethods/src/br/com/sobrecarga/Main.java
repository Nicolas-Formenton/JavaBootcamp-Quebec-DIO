package br.com.sobrecarga;

public class Main {
    public static void main(String[] args) {
    //Um método/nome, 1 parametro
    Quadrilatero.area(5);

    //Um método/nome, 2 parametros
    Quadrilatero.area(5d, 10d);

    //Um método/nome, 3 parametros
    Quadrilatero.area(5, 10, 15);

    //Um método/nome, 2 paramentos com tipos de dados diferentes(float)
    Quadrilatero.area(5f,10f);


    //Returns
    double areaQuadrado = Quadrilatero2.area(3);
        System.out.println("Area Quadrado: " + areaQuadrado);

    double areaRetangulo = Quadrilatero2.area(3d, 5d);
        System.out.println("Area Retangulo: " + areaRetangulo);

    double areaTrapezio = Quadrilatero2.area(3, 5, 10);
        System.out.println("Area Trapezio: " + areaTrapezio);

    double areaLosango = Quadrilatero2.area(3f, 5f);
        System.out.println("Area Losango: " + areaLosango);
    }
}
