package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryImpl;
import africa.semicolon.trueCaller.data.repositories.UserRepository;
import africa.semicolon.trueCaller.data.repositories.UserRepositoryImpl;
import africa.semicolon.trueCaller.dto.requests.AddContactRequest;
import africa.semicolon.trueCaller.dto.requests.RegisterRequest;
import africa.semicolon.trueCaller.dto.responses.AddContactResponse;
import africa.semicolon.trueCaller.dto.responses.AllConTactResponse;
import africa.semicolon.trueCaller.dto.responses.RegisterResponse;
import africa.semicolon.trueCaller.exceptions.UserExistException;
import africa.semicolon.trueCaller.utils.Mapper;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements iUserService{
    private UserRepository userRepository = new UserRepositoryImpl();
    private final ContactService contactService;
        User user = new User();

    public UserServiceImpl(UserRepository userRepository,ContactService contactService) {
        this.contactService = contactService;
        this.userRepository = userRepository;
    }
    public UserServiceImpl(){
        this.userRepository = new UserRepositoryImpl();
        ContactRepository contactRepository = new ContactRepositoryImpl();
        this.contactService = new ContactServiceImpl();

    }

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        RegisterResponse registerResponse = new RegisterResponse();
        // create a new user
        //copy fields from request to user
        //save new user to repository
        User user = new User();
        User savedUser = userRepository.findByEmail(registerRequest.getEmail());
        if(savedUser != null)throw new UserExistException(registerRequest.getEmail()+" already exists");

        Mapper.map(registerRequest , user);


        userRepository.save(user);
        registerResponse.setMessage("User created successfully");
        return registerResponse;

    }

    @Override
    public AddContactResponse addContact(AddContactRequest addContactResponse) {
        // create a contact
        //save contact to repository
        //find user by email
        //add contact to user contact list
        //save user to repository
        Contact contact = new Contact();
        contact.setEmail(addContactResponse.getEmail());
        contact.setFirstName(addContactResponse.getFirstName());
        contact.setLastName(addContactResponse.getLastName());
        contact.setPhoneNumber(addContactResponse.getPhoneNumber());
       Contact savedContact =  contactService.addNewContact(contact);

       User user = userRepository.findByEmail(addContactResponse.getUserEmail());
       user.getContacts().add(savedContact);
       userRepository.save(user);
        return null;
    }

    @Override
    public int getNoOfUsers() {
        return userRepository.count();
    }

    @Override
    public List<AllConTactResponse> findContactBelongsToUser(String userEmail) {
        List<Contact> allUserContact = user.getContacts();
        user = userRepository.findByEmail(userEmail);
        List<AllConTactResponse> allConTactResponses = new ArrayList<>();
        for (var contact : allUserContact) {
            AllConTactResponse singleResponse = new AllConTactResponse();
            singleResponse.setId(contact.getId() + "");
            singleResponse.setFirstName(contact.getFirstName());
            singleResponse.setLastName(contact.getLastName());
        }
        allUserContact.forEach(contact -> {
            AllConTactResponse singleResponse = new AllConTactResponse();
            singleResponse.setId(contact.getId() + "");
            singleResponse.setFirstName(contact.getFirstName());
            singleResponse.setLastName(contact.getLastName());
            allConTactResponses.add(singleResponse);
        });
        return allConTactResponses;
    }
}
