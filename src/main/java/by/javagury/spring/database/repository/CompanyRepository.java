package by.javagury.spring.database.repository;

import by.javagury.spring.database.entity.Company;
import by.javagury.spring.service.CompanyService;
import by.javagury.spring.utils.HibernateUtil;
import lombok.Cleanup;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompanyRepository {
    private static SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

    public List<Company> findAll() {
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        List<Company> list = session.createQuery("select c from Company c", Company.class).list();
        session.getTransaction().commit();
        return list;
    }

    public Optional<Company> findById(Long id) {
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        Company company = session.find(Company.class, id);
        return Optional.of(company);
    }

    public Company save(Company company) {
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(company);
        session.getTransaction().commit();
        return company;
    }

    public void update(Company company) {
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(company);
        session.getTransaction().commit();
    }

    public void delete(Long id) {
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(session.find(Company.class, id));
        session.getTransaction().commit();
    }
}
