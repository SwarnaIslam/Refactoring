package Ecommerce;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserAccountManager accountManager = new SimpleUserAccountManager();
        accountManager.createAccount("John Smith", "john.smith@example.com", "password123", "123 Main St");
        ProductViewer productViewer=new LaptopProductViewer(accountManager);
        productViewer.viewProduct();



    }
}
