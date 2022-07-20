package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{
    private int counter;
    private final List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        User lookForUser = findById(user.getId());
        if (lookForUser != null) {
            user.setUsername(user.getUsername());
            user.setEmail(user.getEmail());
            user.setPassword(user.getPassword());
            user.setName(user.getName());
        } else {
            counter++;
            user.setId(counter);
            users.add(user);

        }
        return user;
    }

    @Override
    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void deleteByUser(User user) {
        users.remove(user);

    }

    @Override
    public void deleteByUser(int id) {
        User foundUser = findById(id);
        users.remove(foundUser);

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public int count() {
        return users.size();
    }
}
