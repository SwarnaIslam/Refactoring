package Ecommerce;

public interface PaymentMethod {
    void processPayment(double amount);
    double getAvailableAmount();
    void setDiscount(ProductDiscountManager manager);
}
