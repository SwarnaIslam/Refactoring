package Ecommerce;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LaptopProductViewer extends ProductViewer{

    private static final Map<String, Product> PRODUCT_LIST = new HashMap<>();
    private UserAccountManager user;


    static {
        // Hard-coded product list
        Product product1 = new Product("Lenovo IdeaPad", "15.6 inch laptop with Intel Core i5 processor", 699.99, "https://example.com/images/lenovo-ideapad.jpg", 10);
        Product product2 = new Product("Dell XPS", "13.3 inch laptop with Intel Core i7 processor", 1299.99, "https://example.com/images/dell-xps.jpg", 5);
        PRODUCT_LIST.put(product1.getName(), product1);
        PRODUCT_LIST.put(product2.getName(), product2);
    }
    public LaptopProductViewer(UserAccountManager user){
        super(user);
        this.user=user;
    }

    public Product getProductNameInput(){
        System.out.println("\nEnter the name of a product to view its details:");
        Scanner scanner = new Scanner(System.in);
        String productName = scanner.nextLine();
        Product product = PRODUCT_LIST.get(productName);
        while (product == null) {
            System.out.println("Product not found. Please enter a valid product name:");
            productName = scanner.nextLine();
            product = PRODUCT_LIST.get(productName);
        }
        return product;
    }
    public void showProductList() {
        System.out.println("Welcome to our laptop store! Here are the available products:\n");
        for (String productName : PRODUCT_LIST.keySet()) {
            System.out.println("- " + productName);
        }
    }
}

