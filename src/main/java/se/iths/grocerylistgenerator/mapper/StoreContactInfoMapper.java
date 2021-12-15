package se.iths.grocerylistgenerator.mapper;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.StoreContactInfoDto;
import se.iths.grocerylistgenerator.model.StoreContactInfo;

@Service
public class StoreContactInfoMapper {

    public StoreContactInfo mapp(StoreContactInfoDto storeContactInfoDto) {
        return new StoreContactInfo(storeContactInfoDto.getAddress(), storeContactInfoDto.getAddress());
    }

    public StoreContactInfoDto mapp(StoreContactInfo storeContactInfo) {
        if(storeContactInfo == null){
            return new StoreContactInfoDto();
        }
        return new StoreContactInfoDto(storeContactInfo.getId(), storeContactInfo.getAddress(), storeContactInfo.getAddress());
    }


}
