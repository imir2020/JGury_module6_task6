package by.javagury.spring.mapper;

import by.javagury.spring.database.entity.Company;
import by.javagury.spring.dto.CompanyDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-02T19:14:46+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.8 (Oracle Corporation)"
)
public class DtoToCompanyMapperImpl implements DtoToCompanyMapper {

    @Override
    public Company fromDto(CompanyDto companyDto) {
        if ( companyDto == null ) {
            return null;
        }

        Company.CompanyBuilder company = Company.builder();

        company.id( companyDto.id() );
        company.name( companyDto.name() );

        return company.build();
    }
}
