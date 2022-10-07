package InterfaceSet;

import java.util.*;

//Crie uma classe LinguagemFavorita que possua os atributos
//        nome, anoDeCriacao e ide. Em seguida, crie um conjunto com
//        3 linguagens e faça um programa que ordene esse conjunto
//        por:
//        A. Ordem de Inserção
//        B. Ordem Natural (nome)
//        C. IDE
//        D. Ano de criação e nome
//        E. Nome, ano de criacao e IDE
//        Ao final, exiba as linguagens no console, um abaixo da outra.
public class LinguagemFavoritaSet {
    public static void main(String[] args) {

        Set<Atributos> linguagens = new HashSet<>() {{
            add(new Atributos("D", 1991, "IntelliJ"));
            add(new Atributos("D", 1991, "IntelliJ"));
            add(new Atributos("B", 1990, "IntelliJ"));
            add(new Atributos("C", 1991, "Jupyter"));
            add(new Atributos("C", 2010, "VS Code"));
            add(new Atributos("B", 1972, "VS Code"));
            add(new Atributos("B", 1972, "VS Code"));
            add(new Atributos("A", 2015, "VS Code"));
        }};
        for (Atributos atributo : linguagens)
            System.out.println(atributo.getNome() + ", " + atributo.getAnoDeCriacao() + ", " + atributo.getIde());


//          A. Ordem de Inserção (LinkedHashSet)
        System.out.println("\nOrdem de Insercao:");
        Set<Atributos> linguagens1 = new LinkedHashSet<>() {{
            add(new Atributos("Java", 1991, "IntelliJ"));
            add(new Atributos("Python", 1991, "Jupyter"));
            add(new Atributos("Rust", 2010, "VS Code"));
            add(new Atributos("C", 1972, "VS Code"));
        }};
        for (Atributos atributo : linguagens1)
            System.out.println(atributo.getNome() + ", " + atributo.getAnoDeCriacao() + ", " + atributo.getIde());


//          B. Ordem Natural(nome) (TreeSet) -> Implements Comparable<Atributos>
        System.out.println("\nOrdem Natural:");
        Set<Atributos> linguagens2 = new TreeSet<>(linguagens);
        for (Atributos atributo : linguagens2)
            System.out.println(atributo.getNome() + ", " + atributo.getAnoDeCriacao() + ", " + atributo.getIde());


//          C. Ordem Natural(IDE) (TreeSet)
        System.out.println("\nOrdem Natural IDE: ");
        Set<Atributos> linguagens3 = new TreeSet<>(new OrdemIde());
//        Adicionar os atributos para não ficar vazia
        linguagens3.addAll(linguagens);
        for (Atributos atributo : linguagens3)
            System.out.println(atributo.getNome() + ", " + atributo.getAnoDeCriacao() + ", " + atributo.getIde());


//          D. Ordem Natural (AnoDeCriacao/Nome) (TreeSet)
        System.out.println("\nOrdem Natural (AnoDeCriacao/Nome): ");
        Set<Atributos> linguagens4 = new TreeSet<>(new OrdemAnoDeCriacaoNome());
        linguagens4.addAll(linguagens);
        for (Atributos atributo : linguagens4) {
            System.out.println(atributo.getNome() + ", " + atributo.getAnoDeCriacao() + ", " + atributo.getIde());
        }


//        E. Ordem Natural(NomeAnoDeCriacaoIDE) (TreeSet)
        System.out.println("\nOrdem Natural (NomeAnoDeCriacaoIDE): ");
        Set<Atributos> linguagens5 = new TreeSet<>(new OrdemNomeAnoDeCriacaoIDE());
        linguagens5.addAll(linguagens);
        for (Atributos atributo : linguagens5){
            System.out.println(atributo.getNome() + ", " + atributo.getAnoDeCriacao() + ", " + atributo.getIde());
        }


//        Linguagens uma abaixo da outra
        System.out.println("\nLinguagens: ");
        for (Atributos atributo : linguagens){
            System.out.println(atributo.getNome());
        }
    }
}
class Atributos implements Comparable<Atributos>{
    private String nome;
    private Integer anoDeCriacao;
    private String ide;

    public Atributos(String nome, Integer anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public void setAnoDeCriacao(Integer anoDeCriacao) {
        this.anoDeCriacao = anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    @Override
    public String toString() {
        return "atributos{" +
                "nome='" + nome + '\'' +
                ", anoDeCriacao=" + anoDeCriacao +
                ", ide='" + ide + '\'' +
                '}';
    }

    @Override
    public int compareTo(Atributos atributos) {
        return this.getNome().compareTo(atributos.getNome());

    }
}

class OrdemIde implements Comparator<Atributos> {

    @Override
    public int compare(Atributos ide1, Atributos ide2) {
        return ide1.getIde().compareTo(ide2.getIde());
    }
}

class OrdemAnoDeCriacaoNome implements Comparator<Atributos>{
    @Override
    public int compare(Atributos a1, Atributos a2) {
        int anoDeCriacao = Integer.compare(a1.getAnoDeCriacao(), a2.getAnoDeCriacao());
            if (anoDeCriacao != 0)
                return anoDeCriacao;

        return a1.getNome().compareTo(a2.getNome());
    }
}

class OrdemNomeAnoDeCriacaoIDE implements Comparator<Atributos> {
    @Override
    public int compare(Atributos o1, Atributos o2) {
        int nome = o1.getNome().compareTo(o2.getNome());
        if (nome!= 0) return nome;

        int anoDeCriacao = Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
        if (anoDeCriacao!= 0) return anoDeCriacao;

        return o1.getIde().compareTo(o2.getIde());
    }
}