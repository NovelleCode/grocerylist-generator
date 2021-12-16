package se.iths.grocerylistgenerator.dto;

public class AddPersonDto {

    private String username;
    private String password;

    public AddPersonDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AddPersonDto() {
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
}
