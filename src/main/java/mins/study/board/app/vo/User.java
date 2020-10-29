package mins.study.board.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * user domain
 *
 * @author minssogi
 */
@Data
@AllArgsConstructor
public class User extends CommonPagingVO {

    @NotBlank(message = "firstName cannot be null or empty")
    private String firstName;

    @NotBlank(message = "lastName cannot be null or empty")
    private String lastName;

    @NotBlank(message = "username cannot be null or empty")
    private String username;

    private String address;

    private List<String> hobbies;
    private List<String> likeFoods;

    private String workAddress;

    public User(String firstName, String lastName, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    // VO vs DTO?

    // Value Object vs Data Transfer Object

    // DTO => 데이터를 전달하거나 전달 받거나~

    // VO => RDB column 과 거의 일치하는 object


    // HTTP protocol => OSI7 layer => application layer
    // METHOD 어떤 방식으로 데이터를 전달 할거냐 + 클라에서 요청한 액션 타입이 뭐야?

    // RESTful API


    // URL(uniform resource locator), URI(Uniform Resource Identifier)
    // URL : dns + /sdfsdf/sdfsdf => naver.com/user
    // URI : /user
}
