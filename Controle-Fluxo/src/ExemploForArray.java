public class ExemploForArray {
    public static void main(String[] args) {
        String alunos[] = {"Nicolas", "Felipe", "Patrick", "Biel"};

        for(int x = 0; x < alunos.length; x++){
            System.out.println("O Aluno no índice X = "+ x + " é " + alunos[x]);
        }

        //Maneira mais prática/agradável de interagir com arrays
        for(String aluno : alunos){
            System.out.println("Nome do aluno é: " + aluno);
        }
    }
}
