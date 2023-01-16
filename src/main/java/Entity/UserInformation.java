package Entity;

import lombok.Data;
import lombok.Builder;
import lombok.ToString;

@Data
@Builder
@ToString
public class UserInformation {

    private String username;

    private String password;

    private String email;

    private String last_name;

    private String first_name;
}
