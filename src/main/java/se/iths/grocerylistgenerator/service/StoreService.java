package se.iths.grocerylistgenerator.service;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.model.Store;
import se.iths.grocerylistgenerator.repository.StoreRepository;

import java.util.Optional;

@Service
public class StoreService {

    private final StoreRepository storeRepository;


    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public Store createStore(Store store){
        return storeRepository.save(store);
    }

    public Optional<Store> findStoreById(Long id) {
        return storeRepository.findById(id);
    }

    public Iterable<Store> findAllStores() {
        return storeRepository.findAll();
    }


}
