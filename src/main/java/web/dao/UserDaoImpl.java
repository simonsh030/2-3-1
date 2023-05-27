package web.dao;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    @Autowired
    private EntityManager entityManager;

    public UserDaoImpl(){}

    @Override
    public List<User> index() {
    List<User>resultList = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    return resultList;
    }


    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User updatedUser) {

        entityManager.merge(updatedUser);
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(show(id));
    }
}