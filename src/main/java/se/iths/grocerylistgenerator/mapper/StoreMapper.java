package se.iths.grocerylistgenerator.mapper;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.StoreDto;
import se.iths.grocerylistgenerator.model.Store;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StoreMapper {

    ContactInfoMapper contactInfoMapper;

    public StoreMapper(ContactInfoMapper contactInfoMapper) {
        this.contactInfoMapper = contactInfoMapper;
    }

    public Store mapp(StoreDto storeDto) {
        return new Store(storeDto.getName(), contactInfoMapper.mapp(storeDto.getContactInfoDto()));
    }

    public StoreDto mapp(Store store) {
        return new StoreDto(store.getId(), store.getName(), contactInfoMapper.mapp(store.getContactInfo()));
    }

    public List<StoreDto> mapp(List<Store> stores) {
        return stores
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }

    public Optional<StoreDto> mapp(Optional<Store> optionalStore) {
        if (optionalStore.isEmpty())
            return Optional.empty();
        return Optional.of(mapp(optionalStore.get()));
    }
}
