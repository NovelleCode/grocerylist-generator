package se.iths.grocerylistgenerator.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.grocerylistgenerator.model.Store;
import se.iths.grocerylistgenerator.service.StoreService;

import java.util.Optional;

@RestController
@RequestMapping("stores")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping()
    public ResponseEntity<Store> createStore(@RequestBody Store store){
        Store createdStore = storeService.createStore(store);
        return new ResponseEntity<>(createdStore, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Store>> findStoreById(@PathVariable Long id){
        Optional<Store> foundStore = storeService.findStoreById(id);
        return new ResponseEntity<>(foundStore, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Iterable<Store>> findAllStores(){
        Iterable<Store> allStores = storeService.findAllStores();
        return new ResponseEntity<>(allStores, HttpStatus.OK);
    }


}
