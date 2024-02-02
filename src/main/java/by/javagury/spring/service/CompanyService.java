package by.javagury.spring.service;

import by.javagury.spring.database.repository.CompanyRepository;
import by.javagury.spring.dto.CompanyDto;
import by.javagury.spring.listener.EntityAfterEvent;
import by.javagury.spring.listener.EntityBeforeEvent;
import by.javagury.spring.mapper.CompanyToDto;
import by.javagury.spring.mapper.DtoToCompany;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    private final DtoToCompany dtoToCompany;
    private final CompanyToDto companyToDto;
    private final CompanyRepository companyRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public CompanyService(DtoToCompany dtoToCompany, CompanyToDto companyToDto,
                          CompanyRepository companyRepository,
                          ApplicationEventPublisher applicationEventPublisher) {
        this.dtoToCompany = dtoToCompany;
        this.companyToDto = companyToDto;
        this.companyRepository = companyRepository;
        this.applicationEventPublisher = applicationEventPublisher;

    }


    public Optional<CompanyDto> findById(Long id) {
        applicationEventPublisher.publishEvent(new EntityBeforeEvent(companyRepository, "WILL FIND"));
        Optional<CompanyDto> companyDto = companyRepository.findById(id)
                .map(companyToDto::mapfrom);
        applicationEventPublisher.publishEvent(new EntityAfterEvent(companyDto, "WAS FIND"));
        return companyDto;
    }

    public List<CompanyDto> findAll() {
        applicationEventPublisher.publishEvent(new EntityBeforeEvent(companyRepository, "WILL FIND_ALL"));
        List<CompanyDto> list = companyRepository.findAll().stream()
                .map(companyToDto::mapfrom)
                .collect(Collectors.toList());
        applicationEventPublisher.publishEvent(new EntityAfterEvent(companyRepository, "WAS FIND_ALL"));
        return list;
    }

    public CompanyDto save(CompanyDto companyDto) {
        applicationEventPublisher.publishEvent(new EntityBeforeEvent(companyRepository, "WILL SAVE"));
        var company = dtoToCompany.mapfrom(companyDto);
        companyRepository.save(company);
        applicationEventPublisher.publishEvent(new EntityAfterEvent(companyRepository, "WAS SAVE"));
        return companyDto;
    }

    public void update(CompanyDto companyDto) {
        applicationEventPublisher.publishEvent(new EntityBeforeEvent(companyRepository, "WILL UPDATE"));
        companyRepository.update(dtoToCompany.mapfrom(companyDto));
        applicationEventPublisher.publishEvent(new EntityBeforeEvent(companyRepository, "WAS UPDATE"));
    }

    public void delete(Long id) {
        applicationEventPublisher.publishEvent(new EntityBeforeEvent(companyRepository, "WILL DELETE"));
        companyRepository.delete(id);
        applicationEventPublisher.publishEvent(new EntityBeforeEvent(companyRepository, "WAS DELETE"));

    }
}
