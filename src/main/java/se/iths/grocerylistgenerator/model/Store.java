package se.iths.grocerylistgenerator.model;

import javax.persistence.*;

@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_storeinfo_id")
    private StoreContactInfo storeContactInfo;

    public Store(String name, StoreContactInfo storeContactInfo) {
        this.name = name;
        this.storeContactInfo = storeContactInfo;
    }

    public Store(String name) {
        this.name = name;
    }

    public Store() {
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

    public void setStoreContactInfo(StoreContactInfo storeContactInfo) {
        this.storeContactInfo = storeContactInfo;
    }
}
