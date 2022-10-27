package Exceptions;

import javax.swing.*;
import java.io.*;
public class CheckedException {
    public static void main(String[] args) {
//        Arquivo precisa estar na root
        String nomeDoArquivo = "testee.txt";

        try {
            imprimirArquivoNoConsole(nomeDoArquivo);
        }

        catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Revise o nome do arquivo que você deseja " +
                    "inserir!\n" + e.getMessage());
        }

//        Exception mae (IOException), colocar sempre abaixo...
        catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um erro inesperado. Entre em contato com o suporte.\n" + e.getCause());
            e.printStackTrace();
        }

        finally {
            System.out.println("Apesar da exception ou nao, o programa continua...");
        }
    }

    public static void imprimirArquivoNoConsole(String nomeDoArquivo) throws IOException {
        File file = new File(nomeDoArquivo);

        BufferedReader reader = new BufferedReader(new FileReader(file.getName()));
        String line = reader.readLine();

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        do {
            writer.write(line);
            writer.newLine();
            line= reader.readLine();
        } while (line!=null);
        writer.flush();
        writer.close();
    }
}
