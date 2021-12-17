package se.iths.grocerylistgenerator.dto;

public class StoreDto {

    private Long id;
    private String name;
    private ContactInfoDto contactInfoDto;

    public StoreDto(Long id, String name, ContactInfoDto contactInfoDto) {
        this.id = id;
        this.name = name;
        this.contactInfoDto = contactInfoDto;
    }

    public StoreDto() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContactInfoDto getContactInfoDto() {
        return contactInfoDto;
    }

    public void setContactInfoDto(ContactInfoDto contactInfoDto) {
        this.contactInfoDto = contactInfoDto;
    }
}
