package hgdapp.service;

import hgdapp.model.User;

import java.util.List;

public interface UserService {
    List<User> allusers();
    User show(int id);
    void save(User user);
    void update(int id, User updatedUser);
    void delete(int id);
}
