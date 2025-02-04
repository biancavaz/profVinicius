public abstract class ContaBancaria {

    private String numeroConta;
    private double saldo ;

    public ContaBancaria (String numeroConta, double saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }
    public void depositar(double valorDeposito){
        this.saldo += valorDeposito;
    }

    public void sacar(double valorSaque){
        if (this.saldo < 0) {
            System.out.println("Saldo insuficiente");
        } else {
            this.saldo -= valorSaque;
            System.out.println("Saque realizado com sucesso");
        }
    }

    public void transferir(ContaBancaria contaDestino, double valorTransferencia) {
        if (this.saldo < valorTransferencia) {
            System.out.println("Saldo insuficiente para realizar a transferência");
        } else {
            this.saldo -= valorTransferencia;
            contaDestino.saldo += valorTransferencia;
            System.out.println("valor trasferido com sucesso");

        }
    }

    public void exibirSaldo() {
        System.out.println("Saldo atual: " + this.saldo);
    }

    public String getNumeroConta() {
        return this.numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract void CalcularRendimento();
}
