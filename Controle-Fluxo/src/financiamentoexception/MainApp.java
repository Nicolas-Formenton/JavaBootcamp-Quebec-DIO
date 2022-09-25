package financiamentoexception;

public class MainApp {
    public static void main(String[] args) {

        double valorTotal = 1000.0;
        double entrada = 150.0;
        int parcelas = 5;

        try {
            Financiamento f = new Financiamento(valorTotal, entrada, parcelas);
            System.out.println(f.prestacao());
        } 
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
