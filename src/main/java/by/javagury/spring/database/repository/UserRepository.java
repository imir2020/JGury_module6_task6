package by.javagury.spring.database.repository;

import by.javagury.spring.database.entity.Company;
import by.javagury.spring.database.entity.User;
import by.javagury.spring.database.pool.ConnectionPool;
import by.javagury.spring.utils.HibernateUtil;
import lombok.*;
import org.hibernate.SessionFactory;
import org.mapstruct.control.MappingControl;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@ToString
@Repository
public class UserRepository {
    private static SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

    public List<User> findAll() {
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        List<User> list = session.createQuery("select u from User u",User.class).list();
        session.getTransaction().commit();
        return list;
    }

    public Optional<User> findById(Long id){
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.find(User.class,id);
        return Optional.ofNullable(user);
    }

    public User save(User user){
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        return user;
    }

    public void update(User user){
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(session.find(User.class,id));
        session.getTransaction().commit();
    }

}
