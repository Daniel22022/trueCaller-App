package africa.semicolon.trueCaller.controllers;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.dto.requests.AddContactRequest;
import africa.semicolon.trueCaller.dto.requests.RegisterRequest;
import africa.semicolon.trueCaller.dto.responses.AddContactResponse;
import africa.semicolon.trueCaller.dto.responses.RegisterResponse;
import africa.semicolon.trueCaller.services.UserServiceImpl;

import java.util.List;

public class UserController {

    private UserServiceImpl userService = new UserServiceImpl();
    public RegisterResponse registerUser(RegisterRequest registerRequest) {
        return userService.register(registerRequest);
    }
    public AddContactResponse addContact(AddContactRequest addContactRequest){
    return userService.addContact(addContactRequest);
    }
    public List<Contact> findContactBelongingTo(String email){
        return userService.findContactBelongsToUser(email);
    }
}