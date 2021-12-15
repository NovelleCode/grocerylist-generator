package se.iths.grocerylistgenerator.service;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.model.StoreContactInfo;
import se.iths.grocerylistgenerator.repository.StoreContactInfoRepository;

import java.util.Optional;

@Service
public class StoreContactInfoService {

    private final StoreContactInfoRepository storeContactInfoRepository;

    public StoreContactInfoService(StoreContactInfoRepository storeContactInfoRepository) {
        this.storeContactInfoRepository = storeContactInfoRepository;
    }

    public StoreContactInfo createStoreContactInfo(StoreContactInfo storeContactInfo){
        return storeContactInfoRepository.save(storeContactInfo);
    }

    public Optional<StoreContactInfo> findStoreContactInfoById(Long id) {
        return storeContactInfoRepository.findById(id);
    }

    public Iterable<StoreContactInfo> findAllStoresContactInfo() {
        return storeContactInfoRepository.findAll();
    }


}
