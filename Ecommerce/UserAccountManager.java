package Ecommerce;

public abstract class UserAccountManager {

    protected String name;
    protected String email;
    protected String password;
    protected String address;

    public void createAccount(String name, String email, String password, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;

        verifyInformation();
        createProfile();
        sendWelcomeEmail();
    }

    protected abstract void verifyInformation();

    protected abstract void createProfile();

    protected void sendWelcomeEmail() {
        System.out.println("Welcome " + name + "!");
        System.out.println("Your account has been created successfully.");
    }
}
