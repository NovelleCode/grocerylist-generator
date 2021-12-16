package se.iths.grocerylistgenerator.service;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.StoreDto;
import se.iths.grocerylistgenerator.mapper.StoreMapper;
import se.iths.grocerylistgenerator.model.Store;
import se.iths.grocerylistgenerator.repository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;

    public StoreService(StoreRepository storeRepository, StoreMapper storeMapper) {
        this.storeRepository = storeRepository;
        this.storeMapper = storeMapper;
    }

    public StoreDto createStore(StoreDto storeDto){
        return storeMapper.mapp(storeRepository.save(storeMapper.mapp(storeDto)));
    }

    public Optional<StoreDto> findStoreById(Long id) {
        return storeMapper.mapp(findById(id));
    }

    public Optional<Store> findById(Long id) {
        return storeRepository.findById(id);
    }

    public List<StoreDto> findAllStores() {
        return storeMapper.mapp(storeRepository.findAll());
    }


}
