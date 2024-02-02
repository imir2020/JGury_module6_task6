package by.javagury.spring.mapper;

import by.javagury.spring.database.entity.Company;
import by.javagury.spring.dto.CompanyDto;

public class DtoToCompany{

    public Company mapfrom(CompanyDto companyDto){
        return DtoToCompanyMapper.INSTANCE.fromDto(companyDto);
    }


}
