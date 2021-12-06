package se.iths.grocerylistgenerator.model;

import javax.persistence.*;

public class StoreContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;
    private String phoneNumber;
/*
    @OneToOne(mappedBy = "storeContactInfo", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    Store store;

 */

    @OneToOne(mappedBy = "store_id")
    Store store;

    public StoreContactInfo(String address, String phoneNumber) {
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public StoreContactInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
