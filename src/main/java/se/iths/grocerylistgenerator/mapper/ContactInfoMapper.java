package se.iths.grocerylistgenerator.mapper;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.ContactInfoDto;
import se.iths.grocerylistgenerator.entity.ContactInfo;

@Service
public class ContactInfoMapper {

    public ContactInfo mapp(ContactInfoDto contactInfoDto) {
        return new ContactInfo(contactInfoDto.getAddress(), contactInfoDto.getPhoneNumber());
    }

    public ContactInfoDto mapp(ContactInfo contactInfo) {
        if(contactInfo == null){
            return new ContactInfoDto();
        }
        return new ContactInfoDto(contactInfo.getId(), contactInfo.getAddress(), contactInfo.getPhoneNumber());
    }


}
