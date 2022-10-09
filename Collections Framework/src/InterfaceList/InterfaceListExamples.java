package InterfaceList;

import java.util.*;
public class InterfaceListExamples {
    public static void main(String[] args) {
        System.out.println("Crie uma lista e adicione as notas... ");

        List<Double> notas = new ArrayList<Double>();
        notas.add(7.0);
        notas.add(5.0);
        notas.add(4.0);
        notas.add(3.0);
        notas.add(1.0);
        notas.add(9.0);
        notas.add(10.0);
        System.out.println(notas);

        notas.add(1, 9.0);;
        System.out.println(notas);

        System.out.println("Posicao da nota 4.0: " + notas.indexOf(4d));
        System.out.println("Posicao da nota X: " + notas.indexOf(8d));

        System.out.println("Adicione na lista a nota 8.0 na posicao 4: ");
        notas.add(4, 8d);

        System.out.println("Posicao da nota 8.0: " + notas.indexOf(8d));
        System.out.println(notas);

        System.out.println("Substitua a nota 3.0 pela nota 6.0:");
        notas.set(notas.indexOf(3d), 6.0);
        System.out.println(notas);

        System.out.println("Confira se a nota 5.0 esta na lista: " + notas.contains(5d));
        System.out.println("Confira se a nota 5.0 esta na lista: " + notas.contains(11d));

        System.out.println("Exiba todas as notas na ordem que foram informados: ");
        for(double nota : notas) System.out.println(nota);

        System.out.println("Exiba a terceira nota adicionada: " + notas.get(2));

        System.out.println("Exiba a menor nota: " + Collections.min(notas));
        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        System.out.print("Exiba a soma dos valores: ");
        Iterator<Double> iterator = notas.iterator();
        double soma = 0;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        System.out.println(soma);

        System.out.println("Exiba a media das notas: " + (soma/notas.size()));

        System.out.println("Remova a nota sete: ");
        notas.remove(7d);

        System.out.println("Remova a nota na posicao 0: ");
        notas.remove(0);

        System.out.println("Remova as notas menores que 7.0 e exiba a lista:");
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()){
            Double next = iterator1.next();
            if(next < 7.0){
                iterator1.remove();
            }
        }
        System.out.println(notas);

        System.out.println("Apague toda a lista: ");
        notas.clear();
        System.out.println(notas);

        System.out.println("Confira se a lista esta vazia: " + notas.isEmpty());
}
}
