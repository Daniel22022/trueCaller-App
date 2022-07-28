package africa.semicolon.trueCaller.utils;

import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.dto.requests.RegisterRequest;

public class Mapper {
    public static void map(RegisterRequest registerRequest, User user) {
        user.setName(registerRequest.getFirstName() + " " + registerRequest.getLastName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setUsername(registerRequest.getUsername());

    }
}
