import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Conta implements iConta{

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 0;
    protected int agencia;
    protected int numeroDaConta;
    private double saldo;
    private double limiteSaque;

    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numeroDaConta = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("\nErro: Quantia maior que o valor disponível.");
        }
        else{
            saldo -= valor;
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, iConta contaDestino) {
        if (valor > saldo) {
            System.out.println("\nQuantia excede o saldo.\n");
        }
        else{
            this.sacar(valor);
            contaDestino.depositar(valor);
        }
    }


    protected void imprimirInfosComuns() {
        System.out.println("Titular: " + cliente.getNome());
        System.out.println("Agencia: " + agencia);
        System.out.println("Numero da Conta: " + numeroDaConta);
        System.out.printf("Saldo Atual:  R$%.2f%n", saldo);
    }

}
