package Ecommerce;

import java.util.Scanner;

public abstract class ProductViewer {

    protected String name;
    protected String description;
    protected double price;
    protected String image;
    protected int inventory;
    private UserAccountManager accountManager;
    ProductDiscountManager discountManager=new LaptopDiscountManager();
    public ProductViewer(UserAccountManager accountManager){
        this.accountManager=accountManager;
    }
    public void viewProduct() {
        showProductList();
        Product product=getProductNameInput();
        selectedProductDescription(product);
        sellProduct(product);
    }

    public abstract Product getProductNameInput();
    public abstract void showProductList();
    public void selectedProductDescription(Product product){
        System.out.println("\nProduct details for " + product.getName() + ":\n");
        System.out.println("Description: " + product.getDescription());
        System.out.println("Price: $" + product.getPrice());
        System.out.println("Inventory: " + product.getInventory() + " units");
        System.out.println("Image URL: " + product.getImage());
    }
    public void sellProduct(Product product){
        System.out.println("Please select a payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.println("3. Cryptocurrency");

        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();

        PaymentMethod paymentMethod;
        switch (selection) {
            case 1:
                paymentMethod = new CreditCardPayment(2000,accountManager);
                break;
            case 2:
                paymentMethod = new PayPalPayment(3000,accountManager);
                break;
            case 3:
                paymentMethod = new CryptocurrencyPayment(1000,accountManager);
                break;
            default:
                throw new IllegalArgumentException("Invalid payment method selection.");
        }
        PaymentProcessor processor=new PaymentProcessor(paymentMethod,product);
        this.discountManager.registerUser(paymentMethod);
        processor.processPayment();
    }

}
