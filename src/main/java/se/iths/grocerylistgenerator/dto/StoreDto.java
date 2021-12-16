package se.iths.grocerylistgenerator.dto;

import se.iths.grocerylistgenerator.model.StoreContactInfo;

public class StoreDto {

    private Long id;
    private String name;
    private StoreContactInfo storeContactInfo;

    public StoreDto(Long id, String name, StoreContactInfo storeContactInfo) {
        this.id = id;
        this.name = name;
        this.storeContactInfo = storeContactInfo;
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

    public StoreContactInfo getStoreContactInfo() {
        return storeContactInfo;
    }

    public void setStoreContactInfo(StoreContactInfoDto storeContactInfoDto) {
        this.storeContactInfo = storeContactInfo;
    }
}
