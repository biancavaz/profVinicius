public class ContaPoupanca extends ContaBancaria {


    public ContaPoupanca(String numeroConta, double saldo) {
        super(numeroConta, saldo);
    }

    public ContaPoupanca () {
        super("2", 0);
    }

    @Override
    public void CalcularRendimento() {
        double rendimento = getSaldo() * 0.05;
        setSaldo(getSaldo() + rendimento);
    }
}
