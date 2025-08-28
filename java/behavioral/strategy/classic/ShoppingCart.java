package behavioral.strategy.classic;

public class ShoppingCart {
    private int amount;

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void pay(PaymentStrategy paymentMethod) {
        paymentMethod.pay(amount);
    }
}
