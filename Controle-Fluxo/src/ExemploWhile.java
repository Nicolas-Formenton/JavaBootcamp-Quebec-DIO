import java.util.concurrent.ThreadLocalRandom;
import java.text.DecimalFormat;

public class ExemploWhile {
    public static void main(String[] args) {
        double mesada = 50.0;

        DecimalFormat df = new DecimalFormat("#.00");
        //Formatação de números decimais #.00 quantidade de casas é a quantidade de 0's
        
        while(mesada > 0){
            Double valorDoce = valorAleatorio();

            if(valorDoce > mesada)
                valorDoce = mesada;
            
            System.out.println("Doce de valor: R$" + df.format(valorDoce) + " adicionado no carrinho.");
            mesada = mesada - valorDoce;
        }

        System.out.println("Mesada:" + mesada);
        System.out.println("Joãozinho gastou toda a sua mesada em doces");
        }
    

    private static double valorAleatorio(){
        return ThreadLocalRandom.current().nextDouble(2, 15); //Algum valor entre 2 e 15(origin - bound)
        
    }
}
