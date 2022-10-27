package Exceptions;

import javax.swing.*;
import java.io.*;

public class CustomException {
    public static void main(String[] args) {

//        Arquivo precisa estar na root
//        String nomeDoArquivo = "teste.txt";
        String nomeDoArquivo = JOptionPane.showInputDialog("Insira o nome do arquivo");
        imprimirArquivoNoConsole(nomeDoArquivo);
    }

    public static void imprimirArquivoNoConsole(String nomeDoArquivo) {

        try {
            BufferedReader reader = lerArquivo(nomeDoArquivo);
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

        catch (ArquivoImpedidoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }

        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro não esperado, por favor, fale " +
                    "com o suporte" + e.getCause());
            e.printStackTrace();
        }


    }

    public static BufferedReader lerArquivo(String nomeDoArquivo) throws ArquivoImpedidoException{

        File file = new File(nomeDoArquivo);

        try {
            return new BufferedReader(new FileReader(file.getName()));
        }
        catch (FileNotFoundException e) {
            throw new ArquivoImpedidoException(file.getName(), file.getPath());
        }
    }
}

class ArquivoImpedidoException extends Exception {

    private String nomeDoArquivo;
    private String diretorio;

    public ArquivoImpedidoException(String nomeDoArquivo, String diretorio) {
        super("O arquivo " + nomeDoArquivo +" não foi encontrado no diretório " + diretorio);
        this.nomeDoArquivo = nomeDoArquivo;
        this.diretorio = diretorio;
    }

//    ToString é usado para quando lançada a Exception, modificar o início da amostra no console.
    @Override
    public String toString() {
        return "ArquivoImpedidoException{" +
                "nomeDoArquivo='" + nomeDoArquivo + '\'' +
                ", diretorio='" + diretorio + '\'' +
                '}';
    }
}
