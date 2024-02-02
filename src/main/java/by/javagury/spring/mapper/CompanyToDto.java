package by.javagury.spring.mapper;

import by.javagury.spring.database.entity.Company;
import by.javagury.spring.dto.CompanyDto;

public class CompanyToDto {

    public CompanyDto mapfrom(Company company){
        return CompanyToDtoMapper.INSTANCE.fromCompany(company);
    }

}
