package africa.semicolon.trueCaller.controllers;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.dto.requests.AddContactRequest;
import africa.semicolon.trueCaller.dto.requests.RegisterRequest;
import africa.semicolon.trueCaller.dto.responses.AddContactResponse;
import africa.semicolon.trueCaller.dto.responses.RegisterResponse;
import africa.semicolon.trueCaller.services.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserServiceImpl userService = new UserServiceImpl();

    @PostMapping("/user")
    public RegisterResponse registerUser(@RequestBody RegisterRequest registerRequest) {
        return userService.register(registerRequest);
    }

    @PatchMapping("/user")
    public AddContactResponse addContact(@RequestBody AddContactRequest addContactRequest) {
        return userService.addContact(addContactRequest);
    }

    @GetMapping("/user/{email}")
    public List<Contact> findContactBelongingTo(@PathVariable String email) {
        return userService.findContactBelongsToUser(email);
    }
}