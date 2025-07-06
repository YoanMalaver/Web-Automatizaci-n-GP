package utils;

public class Users {
    private final String userName, userId, userPassword, userToken;
    private final int userRow;

    //Metodo Constructor
    public Users(String userName, String userId, String userPassword, String userToken, int userRow) {
        this.userName = userName;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userToken = userToken;
        this.userRow = userRow;
    }

    // Getters
    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserToken() {
        return userToken;
    }

    public int getUserRow() {
        return userRow;
    }
}
