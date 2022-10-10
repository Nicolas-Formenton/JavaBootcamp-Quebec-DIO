package InterfaceMap;

import java.util.*;

/*Dada a população estimada de alguns estados do NE brasileiro, faça:
Estado = PE - População = 9.616.621
Estado = AL - População = 3.351.543
Estado = CE - População = 9.187.103
Estado = RN - População = 3.534.265
- Crie um dicionário e relacione os estados e suas populações;
- Substitua a população do estado do RN por 3.534.165;
- Confira se o estado PB está no dicionário, caso não adicione: PB - 4.039.277;
- Exiba a população PE;
- Exiba todos os estados e suas populações na ordem que foi informado;
- Exiba os estados e suas populações em ordem alfabética;
- Exiba o estado com o menor população e sua quantidade;
- Exiba o estado com a maior população e sua quantidade;
- Exiba a soma da população desses estados;
- Exiba a média da população deste dicionário de estados;
- Remova os estados com a população menor que 4.000.000;
- Apague o dicionário de estados;
- Confira se o dicionário está vazio.*/
public class Ex_Map_Estados_Populacao {
    public static void main(String[] args) {

        Map<String, Integer> listaEstados = new HashMap<String, Integer>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        for (Map.Entry<String, Integer> entry : listaEstados.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.println("\n");


//    Substituir a população do estado do RN por 3.534.165
        listaEstados.put("RN", 3534165);
        for (Map.Entry<String, Integer> entry : listaEstados.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.println("\n");

//        Confira se o estado PB está no dicionário, caso não, adicione (PB: 4.039.277)
        System.out.println("PB esta presente na lista? " + listaEstados.containsKey("PB"));
        listaEstados.put("PB", 4039277);

        System.out.println("\n");

//        Exiba a população de PE
        System.out.println("Populacao de PE - " + listaEstados.get("PE"));

        System.out.println("\n");

//    Exiba todos os estados e suas populaçoes na ordem que foi informado (LinkedHashMap)
        System.out.println("Lista na ordem que foram informados: ");
        Map<String, Integer> listaEstados1 = new LinkedHashMap<String, Integer>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        for (Map.Entry<String, Integer> entry : listaEstados1.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.println("\n");


//        Exiba os estads e suas populações em ordem alfabética (TreeMap)
        System.out.println("\nLista alfabetica: ");
        Map<String, Integer> listaEstados3 = new TreeMap<String, Integer>(listaEstados1);
        for (Map.Entry<String, Integer> entry : listaEstados3.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.println("\n");

//       Exiba o estado com menor população e sua quantidade
        System.out.println("Estado com menor populacao: ");
        Integer menorPop = Collections.min(listaEstados.values());
        Set<Map.Entry<String, Integer>> entries = listaEstados.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue().equals(menorPop)) {
                System.out.println(entry.getKey() + " - " + menorPop);
            }
        }

        System.out.println("\n");

//        Exiba o estado com maior população e sua quantidade
        System.out.println("Estado com maior populacao: ");
        Integer maiorPop = Collections.max(listaEstados.values());
        for (Map.Entry<String, Integer> entry : listaEstados.entrySet()) {
            if (entry.getValue().equals(maiorPop)) {
                System.out.println(entry.getKey() + " - " + maiorPop);
            }
        }

        System.out.println("\n");

//      Exiba a soma da população desses estados
        Iterator<Integer> iterator = listaEstados.values().iterator();
        double soma = 0;
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println("Soma da populacao dos estados: " + soma);

        System.out.println("\n");

//        Exiba a media da população desses estados
        System.out.println("Media da populacao desses estados: " + soma/listaEstados.size());

    System.out.println("\n");

//    Remova os estados com a população menor que 4.000.000
        System.out.println("Removendo estados com populacao menor que 4.000.000: ");
        Iterator<Integer> iterator1 = listaEstados.values().iterator();
        while (iterator1.hasNext()) {
            if(iterator1.next() < 4000000){
                iterator1.remove();
            }
        }
        for (Map.Entry<String, Integer> entry : listaEstados.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.println("\n");

//        Apagando o dicionário de estados
        listaEstados.clear();

//        Conferindo se o dicionário está vazio:
        System.out.println("O dicionario de estados esta vazio: " + listaEstados.isEmpty());


    }
}