import java.util.ArrayList;
import java.util.List;

//Queremos manter uma lista de nomes de alunos de uma escola que oferece cursos de Informática básica.
// Essa lista será percorrida na ordem em que os elementos são inseridos.
// Além disso, queremos poder acessar um nome de aluno aleatoriamente.
public class ListaNomeAlunos {
    public static void main(String[] args) {
        final int MAX = 50000;
        long tInicio = System.currentTimeMillis();

//      Teste 1 de tempo com ArrayList<>  (~86ms)
        List<Integer> lista = new ArrayList<Integer>();

//      Teste 2 de tempo com LinkedList<> (~250ms)
//      List<Integer> lista = new LinkedList<Integer>();

        for (int i = 0; i < MAX; i++) {
            lista.add(i);
        }

        for (int i = 0; i < MAX; i++) {
            lista.contains(i);
        }

        long tFim = System.currentTimeMillis();
        System.out.println("Tempo total: " + (tFim - tInicio) + "ms");
    }
}

