package Exceptions;

import javax.swing.*;
public class UncheckedException {
    public static void main(String[] args) {
        String a = JOptionPane.showInputDialog("Numerador: ");
        String b = JOptionPane.showInputDialog("Denominador: ");

        try {
            double resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));
            System.out.println("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada Invalida, informe um numero." + e.getMessage());
//            e.printStackTrace();
        } finally{
            System.out.println("Chegou no finally!");
        }
    }

    public static double dividir(double a, double b) {
        return a/b;
    }
}
