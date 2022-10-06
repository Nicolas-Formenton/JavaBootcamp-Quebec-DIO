import java.util.*;
import java.util.Scanner;

//Faça um programa que receba a temperatura média dos 6 primeiros meses do ano e armazene-as em uma lista.
//Após isso, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta media, e em que mês
//elas ocorreram(mostrar o mês por extenso: 1 - Janeiro, 2 - Fevereiro e etc).
public class ListTemperaturaMedia {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Double> tempMedia = new ArrayList<Double>();

        //Adicionando as temperaturas na lista:
        int count = 0;
        while (true) {
            if (count == 6) break;

            System.out.print("Digite a temperatura: ");
            double temp = scan.nextDouble();
            tempMedia.add(temp);
            count++;
        }

//        System.out.println("Digite as 6 temperaturas medias dos 6 primeiros meses do ano: ");
//        Double temp1 = scan.nextDouble();
//        tempMedia.add(temp1);
//        Double temp2 = scan.nextDouble();
//        tempMedia.add(temp2);
//        Double temp3 = scan.nextDouble();
//        tempMedia.add(temp3);
//        Double temp4 = scan.nextDouble();
//        tempMedia.add(temp4);
//        Double temp5 = scan.nextDouble();
//        tempMedia.add(temp5);
//        Double temp6 = scan.nextDouble();
//        tempMedia.add(temp6);

//        Array Total das Temperaturas
        System.out.println(tempMedia);

//        Cálculo para a soma das temperaturas no array
        Iterator<Double> iterator = tempMedia.iterator();
        double somaTemp = 0;
        while (iterator.hasNext()){
            somaTemp += iterator.next();
        }

//        Calculo da média das temperaturas do Array
        Double averageTempSemester = somaTemp/tempMedia.size();
        System.out.println("Media Semestral de Temperatura: " + averageTempSemester);

//        Temperaturas somente maior que media
        tempMedia.removeIf(next -> next < averageTempSemester);
        System.out.println(tempMedia);

//        Ou usando iterator:

//        Iterator<Double> iterator1 = tempMedia.iterator();
//        while (iterator1.hasNext()){
//            double next = iterator1.next();
//            if(next < averageTempSemester){
//                iterator1.remove();
//            }
//        }
//        System.out.println(tempMedia);

        //Exibindo o mês das temperaturas acima da média por extenso:
        System.out.println("\n\nMeses das temperaturas acima da media: ");
        Iterator<Double> iterator2 = tempMedia.iterator();

        count = 0;

        while (iterator2.hasNext()) {
            Double temp = iterator2.next();
            if (temp > averageTempSemester) {
                switch (count) {
                    case (0):
                        System.out.printf("1 - Janeiro: %.1f\n", temp);
                        break;
                    case (1):
                        System.out.printf("2 - Fevereiro: %.1f\n", temp);
                        break;
                    case (2):
                        System.out.printf("3 - Marco: %.1f\n", temp);
                        break;
                    case (3):
                        System.out.printf("4 - Abril: %.1f\n", temp);
                        break;
                    case (4):
                        System.out.printf("5 - Maio: %.1f\n", temp);
                        break;
                    case (5):
                        System.out.printf("6 - Junho: %.1f\n", temp);
                        break;
                    default:
                        System.out.println("Não houve temperatura acima da media.");
                }
            }
            count++;
    }
}
}

