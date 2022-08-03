package africa.semicolon.trueCaller.controllers;

import africa.semicolon.trueCaller.dto.requests.AddContactRequest;
import africa.semicolon.trueCaller.dto.requests.RegisterRequest;
import africa.semicolon.trueCaller.dto.responses.AddContactResponse;
import africa.semicolon.trueCaller.dto.responses.AllConTactResponse;
import africa.semicolon.trueCaller.dto.responses.RegisterResponse;
import africa.semicolon.trueCaller.exceptions.UserExistException;
import africa.semicolon.trueCaller.services.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserServiceImpl userService = new UserServiceImpl();

    @PostMapping("/user")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        try {
            RegisterResponse serviceResponse = userService.register(registerRequest);
            return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
        } catch (UserExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/user")
    public AddContactResponse addContact(@RequestBody AddContactRequest addContactRequest) {
        return userService.addContact(addContactRequest);
    }

    @GetMapping("/user/{email}")
    public List<AllConTactResponse> findContactBelongingTo(@PathVariable String email) {
        return userService.findContactBelongsToUser(email);
    }
}