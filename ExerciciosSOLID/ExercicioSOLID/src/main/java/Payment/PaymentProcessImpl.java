package Payment;

public class PaymentProcessImpl implements PymentProcessInterface{

    @Override
    public void processPayment(String order, double amount) {
        System.out.println("Processando pagamento de R$" + amount + " para o pedido: " + order);
    }
}
