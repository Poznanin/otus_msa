package arch.homework.webapp.dao.entity;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "user", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(doNotUseGetters = true, onlyExplicitlyIncluded = true)
@ToString(doNotUseGetters = true)
public class User {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone")
    private String phone;

    @PrePersist
    protected void onCreate() {
        if (Objects.isNull(this.id)) {
            this.id = UUID.randomUUID();
        }
    }

}
