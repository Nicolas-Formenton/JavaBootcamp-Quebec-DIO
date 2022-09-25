import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class AboutMe {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in).useLocale(Locale.US);
            
            System.out.print("Digite seu nome e sobrenome: ");
            String nome = scan.next();
            String sobrenome = scan.next();
            
            System.out.print("Digite sua idade: ");
            int idade = scan.nextInt();
            
            System.out.print("Digite sua altura: ");
            double altura = scan.nextDouble();
            
            
            //imprimindo os dados obtidos pelo usuario
            System.out.println("Olá, me chamo " + nome.toUpperCase() + " " + sobrenome.toUpperCase());
            System.out.println("Tenho " + idade + " anos ");
            System.out.println("Minha altura é " + altura + "cm ");
            scan.close();   

        } catch (InputMismatchException e) {
            System.out.println("Digite apenas um sobrenome! Os campos 'Idade' e 'Altura' precisam ser numéricos.");
        }
    }


    }

