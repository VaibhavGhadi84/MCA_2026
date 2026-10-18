/**
 * Base class for Single Inheritance.
 * Represents a generic user in the system.
 */
public class SystemUser {
    public String userId;
    public String name;
    public String contactDetails;

    public SystemUser(String userId, String name, String contactDetails) {
        this.userId = userId;
        this.name = name;
        this.contactDetails = contactDetails;
    }

    /** Simulates a user login. */
    public void login() {
        System.out.println(name + " (ID: " + userId + ") has logged into the AgriSmart System.");
    }
}