package se.iths.grocerylistgenerator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.grocerylistgenerator.model.StoreContactInfo;
import se.iths.grocerylistgenerator.service.StoreContactInfoService;

import java.util.Optional;

@RestController
@RequestMapping("store/info")
public class StoreContactInfoController {

    private final StoreContactInfoService storeContactInfoService;

    public StoreContactInfoController(StoreContactInfoService storeContactInfoService) {
        this.storeContactInfoService = storeContactInfoService;
    }

    @PostMapping()
    public ResponseEntity<StoreContactInfo> createStoreContactInfo(@RequestBody StoreContactInfo storeContactInfo){
        StoreContactInfo createdStoreContactInfo = storeContactInfoService.createStoreContactInfo(storeContactInfo);
        return new ResponseEntity<>(createdStoreContactInfo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<StoreContactInfo> findStoreContactInfoById(@PathVariable Long id){
        StoreContactInfo foundStoreContactInfo = storeContactInfoService.findStoreContactInfoById(id);
        return new ResponseEntity<>(foundStoreContactInfo, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Iterable<StoreContactInfo>> findAllStoresContactInfo(){
        Iterable<StoreContactInfo> allStoresContactInfo = storeContactInfoService.findAllStoresContactInfo();
        return new ResponseEntity<>(allStoresContactInfo, HttpStatus.OK);
    }

}
