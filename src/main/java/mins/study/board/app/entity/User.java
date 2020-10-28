package mins.study.board.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    private String lastName;
    private String userName;

    public User(String firstName, String lastName, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }
}
