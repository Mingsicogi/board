package mins.study.board.app.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class SignUpUserDTO {

    @NotBlank(message = "firstName cannot be null or empty")
    private String firstName;

    @NotBlank(message = "lastName cannot be null or empty")
    private String lastName;

    @NotBlank(message = "username cannot be null or empty")
    private String username;

    @NotBlank
    private String address;

//    @NotNull
    private List<String> hobbies;
//    @NotNull
    private List<String> likeFoods;

    private String workAddress;
}
