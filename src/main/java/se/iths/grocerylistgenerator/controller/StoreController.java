package se.iths.grocerylistgenerator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.iths.grocerylistgenerator.dto.StoreDto;
import se.iths.grocerylistgenerator.service.StoreService;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping()
    public ResponseEntity<StoreDto> createStore(@RequestBody StoreDto storeDto){
        StoreDto createdStore = storeService.createStore(storeDto);
        return new ResponseEntity<>(createdStore, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<StoreDto> findStoreById(@PathVariable Long id){
        StoreDto foundStore = storeService.findStoreById(id);
        return new ResponseEntity<>(foundStore, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping()
    public ResponseEntity<List<StoreDto>> findAllStores(){
        List<StoreDto> allStores = storeService.findAllStores();
        return new ResponseEntity<>(allStores, HttpStatus.OK);
    }


}
