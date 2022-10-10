package InterfaceMap;

import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {

//        Crie um dicionário que relacione os modelos e seus respectivos consumos
        Map<String, Double> carrosPopulares = new HashMap<String, Double>(){{
            put("Gol", 14.4);
            put("Uno", 15.6);
            put("Mobi", 16.1);
            put("Hb20", 14.5);
            put("Kwid", 15.6);
        }};

        System.out.println(carrosPopulares);


//        Substitua o consumo do Gol por 16.1km/l / Uno por 14.5
        carrosPopulares.put("Gol", 16.1);
        carrosPopulares.put("Uno", 14.5);
        System.out.println(carrosPopulares);


//        Confira se o modelo Tucson está no dicionário
        boolean tucson = carrosPopulares.containsKey("Tucson");
        System.out.println(tucson);

//        Exiba o consumo do Uno
        System.out.println(carrosPopulares.get("Uno"));

//        Exiba os modelos (keys)
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos);

//        Exiba os consumos (values)
        Collection<Double> consumos = carrosPopulares.values();
        System.out.println(consumos);

//        Exiba o modelo mais economico e seu consumo
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEconomico = " ";

        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(consumoMaisEficiente)) {
                modeloMaisEconomico = entry.getKey();
                System.out.println("Modelo mais economico: " + modeloMaisEconomico + " - " + consumoMaisEficiente);
            }
        }


//        Exiba o modelo menos economico e seu consumo
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
//        Set<Map.Entry<String, Double>> entries1 = carrosPopulares.entrySet();
        String modeloMenosEconomico = " ";

        for (Map.Entry<String, Double> entry : carrosPopulares.entrySet()) {
            if (entry.getValue().equals(consumoMenosEficiente)) {
                modeloMenosEconomico = entry.getKey();
                System.out.println("Modelo menos economico: " + modeloMenosEconomico + " - " + consumoMenosEficiente);
            }
        }


//        Exiba a soma dos consumos
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0.0;
        while (iterator.hasNext()) {
            soma += iterator.next();
            System.out.println("Soma: " + soma);
        }

//        Exiba a media dos consumos
        System.out.println("Media de consumos: " + soma/carrosPopulares.size());

//        Remova os modelos com consumo igual a 14.5 km/l
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next().equals(14.5)) {
                iterator1.remove();
            }
        }
        System.out.println(carrosPopulares);


//        Exiba na ordem em que foram informados ( LinkedHashMap )
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>(){{
            put("Gol", 14.4);
            put("Uno", 15.6);
            put("Mobi", 16.1);
            put("Hb20", 14.5);
            put("Kwid", 15.6);
        }};

        System.out.println(carrosPopulares1);


//        Exiba o dicionário ordenado pelo modelo (key) (TreeMap) (Ordem Alfabética)
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2);

//        Apague o dicionário de carros
        carrosPopulares.clear();

//        Confira se o dicionário está vazio
        System.out.println("Está vazio? " + carrosPopulares.isEmpty());
    }
}
