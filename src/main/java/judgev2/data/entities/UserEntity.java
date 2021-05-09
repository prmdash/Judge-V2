package judgev2.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity extends BaseEntity {

    @Column(name = "username", nullable = false, unique = true)
    @Length(min = 2, message = "The username must be at least 2 characters long")
    private String username;

    @Column(name = "password", nullable = false)
    @Length(min = 3, message = "The password must be at least 3 characters long")
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Invalid email")
    private String email;

    /* TODO pattern
     https:/github.com/{username}/SpringTestData/
    */
    @Column(name = "github_address", nullable = false, unique = true)
    private String githubAddress;

    @ManyToOne
    private RoleEntity role;
}
