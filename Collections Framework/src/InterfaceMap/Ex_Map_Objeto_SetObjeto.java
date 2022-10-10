package InterfaceMap;
import java.util.*;

/*Crie uma classe Aluno que possua os atributos: nome, matricula.
Crie uma classe Curso que possua os atributos: nome, disciplina.
Em seguida, instancie 3 objetos alunos e para cada aluno uma lista contendo 2 cursos
fazendo a relação entre eles dentro de um dicionário.
Feito isso, exiba o dicionário com o seguintes requisito:
Key: Nome do aluno e matrícula - Value: Nome das disciplinas na qual estão matriculados
*/
public class Ex_Map_Objeto_SetObjeto {
    public static void main(String[] args) {

        AlunoSet aluno1 = new AlunoSet("Nicolas", 1);
        AlunoSet aluno2 = new AlunoSet("Arthur", 2);
        AlunoSet aluno3 = new AlunoSet("Rodrigo",3);

        CursoSet curso1 = new CursoSet("Java", 12);
        CursoSet curso2 = new CursoSet("Rust", 7);
        CursoSet curso3 = new CursoSet("Python", 9);

        Set<CursoSet> c1 = new HashSet<CursoSet>(Arrays.asList(curso1, curso2));
        Set<CursoSet> c2 = new HashSet<CursoSet>(Arrays.asList(curso2, curso3));
        Set<CursoSet> c3 = new HashSet<CursoSet>(Arrays.asList(curso1, curso3));

        Map<AlunoSet, Set<CursoSet>> alunosCursos = new LinkedHashMap<>(){{
           put(aluno1, c1);
           put(aluno2, c2);
           put(aluno3, c3);
        }};

        for(Map.Entry<AlunoSet, Set<CursoSet>> entry : alunosCursos.entrySet()){
            System.out.println(entry.getKey().getNome() + " -> " + entry.getKey().getMatricula());
            for(CursoSet entry1 : entry.getValue()){
                System.out.println(entry1.getNome() + " ");
            }
            System.out.println();
        }
    }
}

class AlunoSet{
    private String nome;
    private Integer matricula;

    public AlunoSet(String nome, Integer matricula) {
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
        AlunoSet alunoSet = (AlunoSet) o;
        return nome.equals(alunoSet.nome) && matricula.equals(alunoSet.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, matricula);
    }

    @Override
    public String toString() {
        return "AlunoSet{" +
                "nome='" + nome + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}

class CursoSet{
    private String nome;
    private Integer disciplina;

    public CursoSet(String nome, Integer disciplina) {
        this.nome = nome;
        this.disciplina = disciplina;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursoSet cursoSet = (CursoSet) o;
        return nome.equals(cursoSet.nome) && disciplina.equals(cursoSet.disciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, disciplina);
    }

    @Override
    public String toString() {
        return "CursoSet{" +
                "nome='" + nome + '\'' +
                ", disciplina=" + disciplina +
                '}';
    }
}
