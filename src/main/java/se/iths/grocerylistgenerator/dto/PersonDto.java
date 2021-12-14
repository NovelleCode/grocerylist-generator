package se.iths.grocerylistgenerator.dto;

public class PersonDto {

    private Long id;
    private String username;
    private String password;

    //En dto för att skapa upp en ny person. SOm sedan -> security och password kryptering

    //En dto För det som skall skickas ut som svar
    // private Long id;
    // private String username;
    // grocerylist?
    // recipelist?
    // favourite store?

    //samma för alla endpoints?
    // - Skapat upp en ny användare
    // - Hämta alla användare
    // - Hämta en användare med id
    // - Lägga till ingredienser på inhandlingslista efter recept (flera ingredienser)
    // - Lägga till ingrediens på inhandlingslista (en ingrediens)
    // - Ta bort ingrediens på inhandlingslista.
    // - Lägga till favoritaffär
    // - Ta bort favoritaffär


    public PersonDto(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public PersonDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
