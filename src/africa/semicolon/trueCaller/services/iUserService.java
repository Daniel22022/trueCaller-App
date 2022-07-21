package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.dto.requests.RegisterRequest;
import africa.semicolon.trueCaller.dto.responses.RegisterResponse;

public interface iUserService {

    RegisterResponse register(RegisterRequest registerRequest);

    int getNoOfUsers();
}
