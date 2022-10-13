package InterfaceStream;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExerciciosStreamAPI {
    public static void main(String[] args) {
        List<String> numeros = Arrays.asList("0", "1", "1", "4", "3", "5", "2", "15", "9", "30");
        System.out.println("Imprima todos os elementos dessa lista de String: ");
            numeros.forEach(System.out::println);

        System.out.println();

//        Pegue os 5 primeiros numeros e coloque dentro de um Set
        Set<String> collect = numeros.stream()
                .limit(5)
                .collect(Collectors.toSet());
//                .forEach(System.out::println);
                System.out.println(collect);

System.out.println();

//        Transforme esta lista de String em uma lista de números inteiros
        List<Integer> collectList = numeros.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
//                .collect(Collectors.toList());
//                .forEach(System.out::println);
                System.out.println(collectList);

System.out.println();

//        Pegue os números pares e maiores que 2 e coloque em uma lista
        List<Integer> ListParesMaioresQue2 = numeros.stream()
                .map(Integer::parseInt)
                .filter(i -> i % 2 == 0 && i > 2)
                .collect(Collectors.toList());
        System.out.println(ListParesMaioresQue2);

System.out.println();

//        Media dos numeros
        numeros.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

System.out.println();

//        Remova os valores ímpares
        List<Integer> removendoImpares = new ArrayList<Integer>(collectList);
        removendoImpares.removeIf(integer -> (integer % 2 != 0));
        System.out.println(removendoImpares);

System.out.println();

//        Ignore os 3 primeiros elementos da lista e imprima o restante
        numeros.stream()
                .skip(3)
                .forEach(System.out::println);

System.out.println();

//        Retirando os numeros repetidos da lista, quantos números ficam?
        long count = numeros.stream()
                            .distinct()
                            .count();
        System.out.println("Sobram " + count + " numeros.");

System.out.println();

//        Mostre o menor valor da lista
        numeros.stream()
                .mapToInt(Integer::parseInt)
                .min()
                .ifPresent(System.out::println);

//        Mostre o maior valor da lista
        numeros.stream()
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);

System.out.println();

//        Pegue apenas os números ímpares e some
        int somaDosPares = collectList.stream()
                .filter(i -> (i % 2 == 0))
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Soma dos pares: " + somaDosPares);

System.out.println();

//        Mostre a lista em ordem numérica
        List<Integer> ordemNumerica = collectList.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(ordemNumerica);

//        Agrupe os valores ímpares múltiplos de 3 e de 5
        Map<Boolean, List<Integer>> imparesMultiplos = collectList.stream()
                .collect(Collectors.groupingBy(i -> (i % 3 == 0 && i % 5 == 0)));
        System.out.println(imparesMultiplos);
        
//        Dica: collect(Collectors.groupingBy(new Function())
    }
}