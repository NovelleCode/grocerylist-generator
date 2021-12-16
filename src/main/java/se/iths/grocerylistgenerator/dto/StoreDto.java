package se.iths.grocerylistgenerator.dto;

public class StoreDto {

    private Long id;
    private String name;
    private StoreContactInfoDto storeContactInfoDto;

    public StoreDto(Long id, String name, StoreContactInfoDto storeContactInfoDto) {
        this.id = id;
        this.name = name;
        this.storeContactInfoDto = storeContactInfoDto;
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

    public StoreContactInfoDto getStoreContactInfoDto() {
        return storeContactInfoDto;
    }

    public void setStoreContactInfoDto(StoreContactInfoDto storeContactInfoDto) {
        this.storeContactInfoDto = storeContactInfoDto;
    }
}
