package InterfaceMap;

import java.util.*;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {

//        Ordem Aleatória
        Map<String, Livro> meusLivros = new HashMap<String, Livro>(){{
            put("Hawking, Stephen", new Livro("Uma Breve Historia do Tempo", 256));
            put("Duhigg, Charles", new Livro("O Poder do Habito", 408));
            put("Harari, Yuval Noah", new Livro("21 Licoes Para o Seculo 21", 432));
            put("Rand, Ayn", new Livro("A Revolta de Atlas - 1", 429));
        }};

        for(Map.Entry<String, Livro> livro : meusLivros.entrySet()){
            System.out.println(livro.getKey() + ": " + livro.getValue().getNome());
        };

        System.out.println("\n");

//        Ordem de Inserção (LinkedHashMap)
        Map<String, Livro> meusLivros1 = new LinkedHashMap<String, Livro>(){{
            put("Hawking, Stephen", new Livro("Uma Breve Historia do Tempo", 256));
            put("Duhigg, Charles", new Livro("O Poder do Habito", 408));
            put("Harari, Yuval Noah", new Livro("21 Licoes Para o Seculo 21", 432));
            put("Rand, Ayn", new Livro("A Revolta de Atlas - 1", 429));

        }};

        for(Map.Entry<String, Livro> livro : meusLivros1.entrySet()){
            System.out.println(livro.getKey() + ": " + livro.getValue().getNome());
        };

        System.out.println("\n");

//        Ordem Alfabética Autores (Keys) -> TreeMap
        Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1);
        for(Map.Entry<String, Livro> livro : meusLivros2.entrySet()){
            System.out.println(livro.getKey() + ": " + livro.getValue().getNome());
        };

        System.out.println("\n");

//        Ordem Alfabética Livros -> TreeSet por conta do comparator
        Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());

        for(Map.Entry<String, Livro> livro : meusLivros3){
            System.out.println(livro.getKey() + ": " + livro.getValue().getNome());
        }

        System.out.println("\n");

//        Ordem Numero de Paginas -> TreeSet implements Comparator
        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorPaginas());
        meusLivros4.addAll(meusLivros.entrySet());

        for(Map.Entry<String, Livro> livro : meusLivros4){
            System.out.println(livro.getKey()
                    + ": "
                    + livro.getValue().getNome()
                    + " ("
                    + livro.getValue().getPaginas()
                    + ")");
        }

        System.out.println("\n");
    }
}

class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Map.Entry<String, Livro> livro1, Map.Entry<String, Livro> livro2) {
        return livro1.getValue().getNome().compareTo(livro2.getValue().getNome());
    }
}

class ComparatorPaginas implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> livro1, Map.Entry<String, Livro> livro2) {
        return livro1.getValue().getPaginas().compareTo(livro2.getValue().getPaginas());
    }
}