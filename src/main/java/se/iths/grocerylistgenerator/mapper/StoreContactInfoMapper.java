package se.iths.grocerylistgenerator.mapper;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.StoreContactInfoDto;
import se.iths.grocerylistgenerator.model.StoreContactInfo;

import java.util.List;
import java.util.Optional;

@Service
public class StoreContactInfoMapper {

    public StoreContactInfoMapper() {
    }

    public StoreContactInfo mapp(StoreContactInfoDto storeContactInfoDto) {
        return new StoreContactInfo(storeContactInfoDto.getAddress(), storeContactInfoDto.getPhoneNumber());
    }

    public StoreContactInfoDto mapp(StoreContactInfo storeContactInfo) {
        return new StoreContactInfoDto(storeContactInfo.getId(), storeContactInfo.getAddress(), storeContactInfo.getPhoneNumber());
    }

    public List<StoreContactInfoDto> mapp(List<StoreContactInfo> storeContactInfo) {
        return storeContactInfo
                .stream()
                .map(this::mapp)
                .toList();
    }

    public Optional<StoreContactInfoDto> mapp(Optional<StoreContactInfo> optionalStoreContactInfo) {
        if (optionalStoreContactInfo.isEmpty())
            return Optional.empty();
        return Optional.of(mapp(optionalStoreContactInfo.get()));
    }
}
