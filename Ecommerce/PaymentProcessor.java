package Ecommerce;

public class PaymentProcessor {
    private PaymentMethod paymentMethod;
    private Product product;

    public PaymentProcessor(PaymentMethod paymentMethod, Product product) {
        this.paymentMethod = paymentMethod;
        this.product = product;
    }

    public void processPayment() {
        this.paymentMethod.processPayment(this.product.getPrice());
        System.out.println("Payment confirmed. Current balance: "+paymentMethod.getAvailableAmount());
    }
}
