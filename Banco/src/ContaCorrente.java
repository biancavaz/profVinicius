public class ContaCorrente  extends ContaBancaria {

    public ContaCorrente(String numeroConta, double saldo) {
        super(numeroConta, saldo);
    }

    public ContaCorrente() {
        super("1", 0);
    }

    @Override
    public void CalcularRendimento() {}
}
