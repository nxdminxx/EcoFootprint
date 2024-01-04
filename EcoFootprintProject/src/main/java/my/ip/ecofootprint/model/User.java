package my.ip.ecofootprint.model;

public class User {
    private int userId; // Primary key
    private String username;
    private String password;
    private String role;
    private String email;
    private String idCard;
    private String name;
    private String contact;
    private String status;
    private String address;
    private String category;

    public User() {
        this.userId = 0; // Default value, assuming 0 is not a valid user ID
        this.username = "";
        this.password = "";
        this.role = "";
        this.email = "";
        this.idCard = "";
        this.name = "";
        this.contact = "";
        this.status = "";
        this.address = "";
        this.category = "";
    }

    public User(int userId, String username, String password, String role, String email, String idCard,
                String name, String contact, String status, String address, String category) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.idCard = idCard;
        this.name = name;
        this.contact = contact;
        this.status = status;
        this.address = address;
        this.category = category;
    }

    // Getter and Setter methods for userId
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Getter and Setter methods for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter methods for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter methods for role
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Getter and Setter methods for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter methods for idCard
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    // Getter and Setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter methods for contact
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    // Getter and Setter methods for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter and Setter methods for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and Setter methods for category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Method to redirect to the appropriate dashboard based on the user's role
    public String redirectToDashboard() {
        switch (role.toLowerCase()) {
            case "admin":
                return "admin_dashboard";
            case "guest":
                return "guest_dashboard";
            // Add more cases for other roles if needed
            default:
                return "default_dashboard";
        }
    }
}
