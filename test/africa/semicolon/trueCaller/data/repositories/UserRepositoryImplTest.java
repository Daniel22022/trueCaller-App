package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryImplTest {
    @Test
    void testThatUserCanSaveAccountTest() {
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setName("John Doe");
        user.setUsername("JohnDoeEasy");
        user.setPassword("Jondy123");
        user.setEmail("JohnDoe@gmail.com");
        userRepository.save(user);
        assertEquals(1, userRepository.count());
    }

    @Test
    void testThatUserCanFindAccountByIdTest() {
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setName("John Doe");
        user.setUsername("JohnDoeEasy");
        user.setPassword("Jondy123");
        user.setEmail("JohnDoe@gmaillcom");
        userRepository.save(user);
        User user2 = userRepository.findById(1);
        assertEquals("John Doe", user2.getName());
    }

    @Test
    void testThatUserCanDeleteAccountTest() {
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setName("John Doe");
        user.setUsername("JohnDoeEasy");
        user.setPassword("Jondy123");
        user.setEmail("JohnDoe@gmail.com");
        userRepository.save(user);
        assertEquals(1, userRepository.count());
        userRepository.deleteByUser(user);
        assertEquals(0 , userRepository.count());

    }
    @Test
    void testThatUserCanBeDeletedById(){
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setName("John Doe");
        user.setUsername("JohnDoeEasy");
        user.setPassword("Jondy123");
        user.setEmail("JohnDoe@gmail.com");
        userRepository.save(user);
        assertEquals(1, userRepository.count());
        User user2 = new User();
        user.setName("Jane Doe");
        user.setUsername("JaneDoeEasy");
        user.setPassword("Jandy123");
        user.setEmail("JaneDoe@gmail.com");
        userRepository.save(user2);
        assertEquals(2, userRepository.count());
        User user1 = userRepository.findById(1);
        userRepository.deleteByUser(1);
        assertEquals(1 , userRepository.count());

    }
    @Test
    void testThatUserCanUpdateUser(){
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setName("John Doe");
        user.setUsername("JohnDoeEasy");
        user.setPassword("Jondy123");
        user.setEmail("JohnDoe@gmail.com");
        userRepository.save(user);
        assertEquals(1, userRepository.count());

        user.setName("John Doe");
        user.setUsername("JohnDoeEasy");
        user.setPassword("Jondy1234");
        user.setEmail("JohnDoe@gmail.com");
        userRepository.save(user);
        assertEquals("Jondy1234" , user.getPassword());
    }
    // test that all users can be found
    @Test
    void saveUser_findAllUsersTest(){
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setName("John Doe");
        user.setUsername("JohnDoeEasy");
        user.setPassword("Jondy123");
        user.setEmail("JohnDoe@gmail.com");
        userRepository.save(user);
        assertEquals("JohnDoeEasy" , user.getUsername());

        User user2 = new User();
        user2.setName("Jane Doe");
        user2.setUsername("JaneDoeEasy");
        user2.setPassword("Jandy1234");
        user2.setEmail("JaneDoe@gmail.com");
        userRepository.save(user2);
        assertEquals("JaneDoeEasy" , user2.getUsername());


    }

}
