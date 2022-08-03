package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryImpl;
import africa.semicolon.trueCaller.data.repositories.UserRepository;
import africa.semicolon.trueCaller.dto.requests.AddContactRequest;
import africa.semicolon.trueCaller.dto.requests.RegisterRequest;
import africa.semicolon.trueCaller.exceptions.UserExistException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class UserServiceImplTest {

    private iUserService userService;
    private ContactService contactService;
    private UserRepository userRepository;
    @BeforeEach
    public void setUp(){
        ContactRepository contactRepository = new ContactRepositoryImpl();
        contactService = new ContactServiceImpl();
        userService = new UserServiceImpl(userRepository , contactService);
    }



@Test
    public void register(){
    iUserService userService = new UserServiceImpl();
    // given
    // there is a request form
    RegisterRequest request = new RegisterRequest();
    request.setEmail("JohnDoe@Gmail.com");
    request.setUsername("John");
//    request.setLastName("Doe");
//    request.setPhoneNumber("123456789");
    request.setPassword("123456");

    // when
    userService.register(request);
    // i try to register

    // assert
    //repository size is one
    assertEquals(1, userService.getNoOfUsers());
    }
    @Test
    public void duplicateEmailThrowsException(){
        iUserService userService = new UserServiceImpl();
        // given
        // there is a request form
        RegisterRequest request = new RegisterRequest();
        request.setEmail("JohnDoe@Gmail.com");
//        request.setFirstName("John");
//        request.setLastName("Doe");
        request.setPassword("123456");
        request.setUsername("JohnDoyeee");
        userService.register(request);
        RegisterRequest request2 = new RegisterRequest();
        request2.setEmail("JaneDoe@gmail.com");
//        request2.setFirstName("Jane");
//        request2.setLastName("Doe");
        request2.setPassword("123456");
        request2.setUsername("JaneDusty");
        userService.register(request2);

        assertThrows(UserExistException.class, () -> userService.register(request2));
        assertEquals(2, userService.getNoOfUsers());

}
    @Test
    public void addContactTest(){
    // given that i have a user
        iUserService userService = new UserServiceImpl();
        // given
        // there is a request form
        RegisterRequest request = new RegisterRequest();
        request.setEmail("JohnDoe@Gmail.com");
        request.setUsername("John");
//        request.setLastName("Doe");
//        request.setPhoneNumber("123456789");
        request.setPassword("123456");

        // when
        userService.register(request);

    //when i have contact
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setEmail("JohnDoe@gmail.com");
        addContactRequest.setFirstName("Jane");
        addContactRequest.setLastName("Doe");
        addContactRequest.setPhoneNumber("123456789");
        addContactRequest.setUserEmail("JohnDoe@gmail.com");
        userService.addContact(addContactRequest);
    // check that contacts size has increased
       assertEquals (1, userService.findContactBelongsToUser("JohnDoe@gmail.com").size());
    }
}
