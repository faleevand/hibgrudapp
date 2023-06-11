package hgdapp.dao;

import hgdapp.model.User;

import java.util.List;

public interface UserDao {
    List<User> index();
    User show(int id);
     void save(User user);
    void update(int id, User updatedUser);
    void delete(int id);
}
