package web.service;



import web.model.User;

import java.util.List;

public interface UserService {
        List<User> getAllUsers();
        User getUserById(int id);
        void saveUser(User user);
        void updateUser(User updatedUser);
        void deleteUserById(int id);
}