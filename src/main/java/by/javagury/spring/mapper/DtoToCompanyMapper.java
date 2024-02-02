package by.javagury.spring.mapper;

import by.javagury.spring.database.entity.Company;
import by.javagury.spring.dto.CompanyDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DtoToCompanyMapper {
    DtoToCompanyMapper INSTANCE = Mappers.getMapper(DtoToCompanyMapper.class);

    Company fromDto(CompanyDto companyDto);
}
