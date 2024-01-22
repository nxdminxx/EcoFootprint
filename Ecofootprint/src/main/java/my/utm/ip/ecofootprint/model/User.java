package my.utm.ip.ecofootprint.model;

import my.utm.ip.ecofootprint.model.DAO.UserDAO;

public class User {
	
	//DTO
    private int userId;
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
    private int waterId;
    private int electricityId;
    private int recycleId;

    public User(){

    }

    // DB -> Repo -> DAO -> Service -> DTO -> Controller -> view
	// view -> controller -> DTO -> Service -> DAO -> Repo -> DB

	//convert DAO to DTO obj
    public User(UserDAO dao){
        this.userId = dao.getUserId();
        this.username = dao.getUsername();
        this.password = dao.getPassword();
        this.role = dao.getRole();
        this.email = dao.getEmail();
        this.idCard = dao.getIdCard();
        this.name = dao.getName();        
        this.contact = dao.getContact();
        this.status = dao.getStatus();
        this.address = dao.getAddress();
        this.category = dao.getCategory();
        this.waterId = dao.getWaterId();
        this.electricityId = dao.getElectricityId();
        this.recycleId = dao.getRecycleId();
    }
    
    //convert DTO to DAO
    public UserDAO toDAO(){
		UserDAO dao = new UserDAO();
        dao.setUserId(userId);
        dao.setUsername(username);
        dao.setPassword(password);
        dao.setRole(role);
        dao.setEmail(email);
        dao.setIdCard(idCard);
        dao.setName(name); 
        dao.setContact(contact);
        dao.setStatus(status);
        dao.setAddress(address);
        dao.setCategory(category);
        dao.setWaterId(waterId);
        dao.setElectricityId(electricityId);
        dao.setRecycleId(recycleId);
		return dao;
	}

    public User(int userId, String username, String password, String role, String email, String idCard,
            String name, String contact, String status, String address, String category,  int waterId, int electricityId, int recycleId) {
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
        this.waterId = waterId;
        this.electricityId = electricityId;
        this.recycleId = recycleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getWaterId() {
        return waterId;
    }

    public void setWaterId(int waterId) {
        this.waterId = waterId;
    }

    public int getElectricityId() {
        return electricityId;
    }

    public void setElectricityId(int electricityId) {
        this.electricityId = electricityId;
    }

    public int getRecycleId() {
        return recycleId;
    }

    public void setRecycleId(int recycleId) {
        this.recycleId = recycleId;
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