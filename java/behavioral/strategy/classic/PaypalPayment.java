package behavioral.strategy.classic;

public class PaypalPayment implements PaymentStrategy {
    private final String emailId;

    public PaypalPayment(String email) {
        this.emailId = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Paypal account " + emailId);
    }
}
