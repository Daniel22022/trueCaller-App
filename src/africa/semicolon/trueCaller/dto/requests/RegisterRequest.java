package africa.semicolon.trueCaller.dto.requests;

import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String email;


}
