package InterfaceSet;

import java.util.*;

//Crie um conjunto contendo as cores do arco-íris e:
//        A. Exiba todas as cores uma abaixo da outra
//        B. A quantidade de cores que o arco-íris tem
//        C. Exiba as cores em ordem alfabética
//        D. Exiba as cores na ordem inversa da que foi informada
//        E. Exiba todas as cores que começam com a letra ”v”
//        F. Remova todas as cores que não começam com a letra “v”
//        G. Limpe o conjunto
//        H. Confira se o conjunto está vazio
public class arcoIrisSet {
    public static void main(String[] args) {

        Set<Cores> cores = new HashSet<Cores>();
        cores.add(new Cores("Vermelho", 1));
        cores.add(new Cores("Laranja", 2));
        cores.add(new Cores("Amarelo", 3));
        cores.add(new Cores("Verde", 4));
        cores.add(new Cores("Azul", 5));
        cores.add(new Cores("Anil", 6));
        cores.add(new Cores("Violeta", 7));


//        A. Todas as cores, uma abaixo da outra
        System.out.println("\nCores uma abaixo da outra: ");
        for(Cores cor : cores) {
            System.out.println(cor.getCor());
        }


//        B. Quantidade de cores que o arco-íris tem
        System.out.print("\nQuantidade de cores que o arco-iris tem: ");
        int size = cores.size();
        System.out.println(size);


//        C. Ordem Alfabética
        System.out.println("\nOrdem Alfabetica: ");
        Set<Cores> cores1 = new TreeSet<>(cores);
            cores1.addAll(cores);

        for(Cores cor : cores1) {
            System.out.println(cor.getCor());
        }


//        D. Ordem Inversa da Informada
        System.out.println("\nOrdem Inversa da Informada: ");
        Set<Cores> cores2 = new LinkedHashSet<>(){{
            add(new Cores("Vermelho", 1));
            add(new Cores("Laranja", 2));
            add(new Cores("Amarelo", 3));
            add(new Cores("Verde", 4));
            add(new Cores("Azul", 5));
            add(new Cores("Anil", 6));
            add(new Cores("Violeta", 7));
        }};

//        Transformando o LinkedHashSet em um ArrayList para então usar o Collections.reverse
        ArrayList<Cores> reversedCores2= new ArrayList<Cores>(cores2);
        Collections.reverse(reversedCores2);

        for(Cores cor : reversedCores2) {
            System.out.println(cor.getCor());
        }


//        Exibir todas as cores que começar com a letra "v"
        System.out.println("\nExibir todas as cores que comecarem com a letra 'V': ");
        for(Cores cor : cores) {
            if(cor.getCor().startsWith("V")){
                System.out.println(cor.getCor());
            }
        }


//        Remover todas as cores que começar com a letra "v"
        System.out.println("\nRemover todas as cores que comecarem com a letra 'V': ");
        for(Cores cor : cores) {
            if (!cor.getCor().startsWith("V")) {
                System.out.println(cor.getCor());
            }
        }

//        Limpar o conjunto
        System.out.println("\nLimpar o conjunto:");
        cores.clear();
        for(Cores cor : cores) {
            System.out.println(cor);
        }


//        Verificar se o conjunto está vazio
        System.out.println("\nO conjunto esta vazio? " + cores.isEmpty());

    }
}

class Cores implements Comparable<Cores>{
    private String cor;
    private Integer numCor;

    public Cores(String cor, Integer numCor) {
        this.cor = cor;
        this.numCor = numCor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getNumCor() {
        return numCor;
    }

    public void setNumCor(Integer numCor) {
        this.numCor = numCor;
    }

    @Override
    public String toString() {
        return "Cores{" +
                "cores='" + cor + '\'' +
                ", numCores=" + numCor +
                '}';
    }

    @Override
    public int compareTo(Cores cor) {
        return this.getCor().compareToIgnoreCase(cor.getCor());
    }
}


