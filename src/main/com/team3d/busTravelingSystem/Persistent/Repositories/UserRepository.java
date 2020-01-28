package main.com.team3d.busTravelingSystem.Persistent.Repositories;


import main.com.team3d.busTravelingSystem.Persistent.DbContext.HibernateUtil;
import main.com.team3d.busTravelingSystem.Persistent.Models.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.function.Predicate;

public class UserRepository extends CrudRepository<User,Long> {
    private static UserRepository userRepository;

    private UserRepository() {

    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }


    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
