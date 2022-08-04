package africa.semicolon.trueCaller.data.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document("Users")
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String email;

    @DBRef
    private List<Contact> contacts = new ArrayList<>();
}
