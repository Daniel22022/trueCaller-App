package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    User findById(int id);

    void deleteByUser(User user);
    void deleteByUser(int id);

    List<User>findAll();
    int count();
}
