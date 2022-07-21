package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.data.repositories.UserRepository;
import africa.semicolon.trueCaller.data.repositories.UserRepositoryImpl;
import africa.semicolon.trueCaller.dto.requests.RegisterRequest;
import africa.semicolon.trueCaller.dto.responses.RegisterResponse;
import africa.semicolon.trueCaller.exceptions.UserExistException;

public class UserServiceImpl implements iUserService{
    private UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        // create a new user
        //copy fields from request to user
        //save new user to repository
        User savedUser = userRepository.findByEmail(registerRequest.getEmail());
        if(savedUser != null)throw new UserExistException(registerRequest.getEmail()+" already exists");


        User user = new User();
        user.setName(registerRequest.getFirstName() + " " + registerRequest.getLastName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setUsername(registerRequest.getUsername());


        userRepository.save(user);
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setMessage("User created successfully");
        return registerResponse;

    }

    @Override
    public int getNoOfUsers() {
        return userRepository.count();
    }
}
