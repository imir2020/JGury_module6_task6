package repository;

import by.javagury.spring.database.entity.Company;
import by.javagury.spring.database.repository.CompanyRepository;
import by.javagury.spring.utils.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.hql.internal.ast.tree.ComponentJoin;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class CompanyRepositoryTest {
    private final CompanyRepository companyRepository = new CompanyRepository();

    @Test
    public void findAll() {
        List<Company> list = companyRepository.findAll();
        list.forEach(System.out::println);
        assertTrue(list.size() > 0);
    }

    @Test
    public void update() {
        Long id = 2L;
        Company company = companyRepository.findById(id).get();
        company.setName("Yandex");
        companyRepository.update(company);

        Company companyBeforeUpdate = companyRepository.findById(id).get();
        assertEquals(company,companyBeforeUpdate);
    }
}
