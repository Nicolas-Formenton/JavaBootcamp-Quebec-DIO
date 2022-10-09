package InterfaceList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa
//sobre um crime. As perguntas são:
//
//1. Telefonou para a vítima?
//2. Esteve no local do crime?
//3. Mora perto da vítima?
//4. Devia para a vítima?
//5. Já trabalhou com a vítima?
//
//Se a pessoa responder positivamente a 2 questões: Suspeita
//Entre 3 e 4: Cúmplica
//5: Assassina
//Caso contrário: Inocente
public class ListPerguntasVitima {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    List<String> respostas = new ArrayList<String>();

    System.out.println("Responda com S ou N");
    System.out.println("");

        System.out.println("Telefonou para a vitima?");
        String r1 = scan.nextLine();
        respostas.add(r1);

        System.out.println("Esteve no local do crime?");
        String r2 = scan.nextLine();
        respostas.add(r2);

        System.out.println("Mora perto da vitima?");
        String r3 = scan.nextLine();
        respostas.add(r3);

        System.out.println("Devia para a vitima?");
        String r4 = scan.nextLine();
        respostas.add(r4);

        System.out.println("Ja trabalhou com a vitima?");
        String r5 = scan.nextLine();
        respostas.add(r5);

        System.out.println(respostas.toString());

        int count = 0;
        Iterator<String> iterator = respostas.iterator();
        while (iterator.hasNext()) {
            String resp = iterator.next();
            if (resp.startsWith("S")) {
                count++;
            }
        }

        switch (count) {
            case 2 -> System.out.println("Suspeito(a)");
            case 3, 4 -> System.out.println("Cumplice");
            case 5 -> System.out.println("Assassino(a)");
            default -> System.out.println("Inocente");
        }

    }
}
