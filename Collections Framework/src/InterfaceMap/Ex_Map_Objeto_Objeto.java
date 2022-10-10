package InterfaceMap;

import java.util.*;

/*Crie uma classe Aluno que possua os atributos: nome, matricula.
Crie uma classe Curso que possua os atributos: nome, disciplina.
Em seguida, instancie 3 objetos alunos e 3 cursos, fazendo a relação entre eles dentro de um dicionário.
Feito isso, ordene esse dicionário por:
A) Nome da disciplina
a) Duração do curso;
b) Nome do aluno;
d) Matricula do aluno;
*/
public class Ex_Map_Objeto_Objeto {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Nicolas", 1);
        Aluno aluno2 = new Aluno("Arthur", 2);
        Aluno aluno3 = new Aluno("Rodrigo", 3);

        Curso curso1 = new Curso("Java", 73);
        Curso curso2 = new Curso("Rust", 62);
        Curso curso3 = new Curso("Python", 48);

//        Fazendo sua relação dentro de um dicionario(Map)
        Map<Curso, Aluno> cursos = new HashMap<>(){{
            put(curso1, aluno1);
            put(curso2, aluno2);
            put(curso3, aluno3);
        }};

        System.out.println("Exibindo o dicionario: ");
        for (Map.Entry<Curso, Aluno> curso : cursos.entrySet()){
            System.out.println(curso.getKey() + ": " + curso.getValue());
        }

        System.out.println("\n");

//        Por ordem alfabética (Nome do curso)
        System.out.println("Exibindo em ordem alfabetica: ");
        Map<Curso, Aluno> cursos1 = new LinkedHashMap<>(){{
            put(curso1, aluno1);
            put(curso2, aluno2);
            put(curso3, aluno3);
        }};
        for (Map.Entry<Curso, Aluno> curso : cursos1.entrySet()){
            System.out.println(curso.getKey() + ": " + curso.getValue());
        }

        System.out.println("\n");

//        Por ordem da matricula (TreeMap)
        System.out.println("Exibindo em ordem da matricula: ");
        Map<Curso, Aluno> cursos2 = new TreeMap<>(new ComparatorCurso());
        cursos2.putAll(cursos);
        for (Map.Entry<Curso, Aluno> curso : cursos2.entrySet()){
            System.out.println(curso.getKey() + ": " + curso.getValue());
        }

        System.out.println("\n");

//        Por ordem de nome do aluno (TreeSet)
        System.out.println("Exibindo em ordem de nome do aluno: ");
        Set<Map.Entry<Curso, Aluno>> cursos4 =
                new TreeSet<Map.Entry<Curso, Aluno>>(new ComparatorNomeAluno());
        cursos4.addAll(cursos.entrySet());

        for (Map.Entry<Curso, Aluno> curso : cursos4){
            System.out.println(curso.getKey() + ": " + curso.getValue());
        }

        System.out.println("\n");

//        Por ordem de matricula do aluno (TreeSet)
        System.out.println("Exibindo em ordem de matricula do aluno: ");
        Set<Map.Entry<Curso, Aluno>> cursos5 =
                new TreeSet<>(new ComparatorMatriculaAluno());
        cursos5.addAll(cursos.entrySet());

        for (Map.Entry<Curso, Aluno> curso : cursos5){
            System.out.println(curso.getKey() + ": " + curso.getValue());
        }
    }
}

class Aluno{
    private String nome;
    private Integer matricula;

    public Aluno(String nome, Integer matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return nome.equals(aluno.nome) && matricula.equals(aluno.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, matricula);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}

class Curso {
    private String nome;
    private Integer disciplina;

    public Curso(String nome, Integer disciplina) {
        this.nome = nome;
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                ", matricula=" + disciplina +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return nome.equals(curso.nome) && disciplina.equals(curso.disciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, disciplina);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Integer disciplina) {
        this.disciplina = disciplina;
    }
}

class ComparatorCurso implements Comparator<Curso>{
    @Override
    public int compare(Curso curso1, Curso curso2) {
//        return curso1.getDisciplina().compareTo(curso2.getDisciplina());
        return Integer.compare(curso1.getDisciplina(), curso2.getDisciplina());
    }
}

class ComparatorNomeAluno implements Comparator<Map.Entry<Curso, Aluno>> {
    @Override
    public int compare(Map.Entry<Curso, Aluno> aluno1, Map.Entry<Curso, Aluno> aluno2) {
        return aluno1.getValue().getNome().compareTo(aluno2.getValue().getNome());
    }
}

class ComparatorMatriculaAluno implements Comparator<Map.Entry<Curso, Aluno>>{

    @Override
    public int compare(Map.Entry<Curso, Aluno> aluno1, Map.Entry<Curso, Aluno> aluno2) {
        return aluno1.getValue().getMatricula().compareTo(aluno2.getValue().getMatricula());
    }
}
