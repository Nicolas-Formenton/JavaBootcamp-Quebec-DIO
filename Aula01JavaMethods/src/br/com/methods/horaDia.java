package br.com.methods;

public class horaDia {
    public static void horario(int hora) {
        if(hora >= 6 && hora <= 12){
            System.out.println("Bom Dia!");
        }
        else if(hora > 12 && hora <= 18){
            System.out.println("Boa Tarde!");
        }
        else if(hora > 18 && hora <=24){
            System.out.println("Boa Noite!");
        }else if(hora >= 0 && hora < 6){
            System.out.println("Boa Noite!");
        }
        else{
            System.out.println("Entrada invalida!");
        }
    }
}
