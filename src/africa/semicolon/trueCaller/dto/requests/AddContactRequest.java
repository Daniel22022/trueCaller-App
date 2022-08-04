package africa.semicolon.trueCaller.dto.requests;

import lombok.Data;

@Data
public class AddContactRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String userEmail;


    }

