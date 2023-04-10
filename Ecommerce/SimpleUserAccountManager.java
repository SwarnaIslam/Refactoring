package Ecommerce;

public class SimpleUserAccountManager extends UserAccountManager {

    @Override
    protected void verifyInformation() {
        if (name == null || email == null || password == null || address == null) {
            throw new IllegalArgumentException("User information is incomplete");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
    }

    @Override
    protected void createProfile() {
        System.out.println("Creating profile for " + name + "...");
        // additional code to create user profile
    }
}
