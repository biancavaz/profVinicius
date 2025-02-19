package Payment;

public interface PymentProcessInterface {

    void processPayment(String order, double amount);

    //caso tenha outros tipos de pagamentos
}
