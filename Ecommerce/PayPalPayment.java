package Ecommerce;

public class PayPalPayment implements PaymentMethod {

    private double availableAmount;
    private UserAccountManager user;
    private LaptopDiscountManager laptop=new LaptopDiscountManager();
    private double discount;
    @Override
    public void setDiscount(ProductDiscountManager manager) {
        if(manager==laptop){
            this.discount=laptop.getDiscount();
        }
    }

    public PayPalPayment(double availableAmount, UserAccountManager user) {
        this.availableAmount=availableAmount;
        this.user=user;
    }

    @Override
    public void processPayment(double price) {
        double newPrice=price+price*this.discount;
        System.out.println("Processing PayPal payment of $" + newPrice + "...");
        if(newPrice<=availableAmount){
            availableAmount-=newPrice;
        }
    }

    @Override
    public double getAvailableAmount() {
        return availableAmount;
    }
}
