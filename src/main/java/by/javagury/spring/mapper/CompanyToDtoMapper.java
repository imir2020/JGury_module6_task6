package by.javagury.spring.mapper;

import by.javagury.spring.database.entity.Company;
import by.javagury.spring.dto.CompanyDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyToDtoMapper {
    CompanyToDtoMapper INSTANCE = Mappers.getMapper(CompanyToDtoMapper.class);

    CompanyDto fromCompany(Company company);
}
