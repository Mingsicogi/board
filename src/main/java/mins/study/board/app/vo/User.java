package mins.study.board.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * user domain
 *
 * @author minssogi
 */
@Data
@AllArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private String username;
}
