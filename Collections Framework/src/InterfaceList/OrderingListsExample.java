package InterfaceList;

import java.util.*;

public class OrderingListsExample {
    public static void main(String[] args) {
        List<Gato> gatos = new ArrayList<>(){{
            add(new Gato("Hash", 3, "Laranja"));
            add(new Gato("Oliver", 5, "Rajado"));
            add(new Gato("Tom", 2, "Preto"));
            add(new Gato("Miau", 7, "Branco"));
            }};

//        Ordem de inserção
        System.out.println(gatos);

//        Ordem Aleatória
        Collections.shuffle(gatos);
        System.out.println(gatos);

//        Ordem Natural (implementar "Comparable<InterfaceList.Gato>" na class InterfaceList.Gato
        Collections.sort(gatos);
        System.out.println(gatos);

//        Ordem Idade (implementar "Comparator<InterfaceList.Gato>" na nova class InterfaceList.ComparatorIdade)
//        Collections.sort(gatos, new InterfaceList.ComparatorIdade());
        gatos.sort(new ComparatorIdade());
        System.out.println(gatos);

//        Ordem Cor (implementar "Comparator<InterfaceList.Gato>" na nova class InterfaceList.ComparatorCor)
//        Collections.sort(gatos, new InterfaceList.ComparatorCor());
        gatos.sort(new ComparatorCor());
        System.out.println(gatos);

//        Ordem por Nome/Cor/Idade (se x for igual, usar y como comparação, se y for igual, usar Z como comparação
        gatos.sort(new ComparatorNomeCorIdade());
        System.out.println(gatos);
    }
}

class Gato implements Comparable<Gato>{
    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "InterfaceList.Gato{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

class ComparatorIdade implements Comparator<Gato>{
    @Override
    public int compare(Gato gato1, Gato gato2) {
        return Integer.compare(gato1.getIdade(), gato2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato> {
    @Override
    public int compare(Gato gato1, Gato gato2) {
        return gato1.getCor().compareToIgnoreCase(gato2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato>{
    @Override
    public int compare(Gato gato1, Gato gato2) {
//        Primeiro critério de desempate
        int nome = gato1.getNome().compareToIgnoreCase(gato2.getNome());
        if(nome != 0){
            return nome;
        }

//        Segundo critério de desempate
        int cor = gato1.getCor().compareToIgnoreCase(gato2.getCor());
        if(cor!= 0){
            return cor;
        }

//        Terceiro critério de desempate
        return Integer.compare(gato1.getIdade(), gato2.getIdade());
    }
}