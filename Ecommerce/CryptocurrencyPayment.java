package Ecommerce;

public class CryptocurrencyPayment implements PaymentMethod {

    private double availableAmount;
    private UserAccountManager user;
    private double discount;
    private LaptopDiscountManager laptop=new LaptopDiscountManager();

    @Override
    public void setDiscount(ProductDiscountManager manager) {
        if(manager==laptop){
            this.discount=laptop.getDiscount();
        }
    }

    public CryptocurrencyPayment(double availableAmount, UserAccountManager user) {
        this.availableAmount=availableAmount;
        this.user=user;

    }

    @Override
    public void processPayment(double price) {
        double newPrice=price+price*this.discount;
        System.out.println("Processing cryptocurrency payment of $" + newPrice + " to wallet address of " + user.name + "...");
        if(newPrice<=availableAmount){
            availableAmount-=newPrice;
        }
    }

    @Override
    public double getAvailableAmount() {
        return availableAmount;
    }
}
