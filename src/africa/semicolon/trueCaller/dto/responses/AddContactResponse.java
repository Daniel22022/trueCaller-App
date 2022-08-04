package africa.semicolon.trueCaller.dto.responses;

import lombok.Data;

@Data
public class AddContactResponse {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

}
