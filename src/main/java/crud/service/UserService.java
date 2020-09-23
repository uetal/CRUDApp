package crud.service;

import crud.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    void update(User user);
    void delete(User user);
    User getById(long id);
}
