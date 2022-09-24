package br.com.methods;

public class Emprestimo {
    public static void calcular(double valorSolicitado, int parcelas) {

        if(parcelas > 1 && parcelas <= 6){
            double taxaParcelas = 0.06;
            double valorFinal = valorSolicitado + (valorSolicitado * taxaParcelas);
            System.out.println("Valor final e de: R$" + valorFinal);
        }
        else if(parcelas > 6 && parcelas <= 12){
            double taxaParcelas = 0.12;
            double valorFinal = valorSolicitado + (valorSolicitado * taxaParcelas);
            System.out.println("Valor final e de: R$" + valorFinal);
        }

    }
}
