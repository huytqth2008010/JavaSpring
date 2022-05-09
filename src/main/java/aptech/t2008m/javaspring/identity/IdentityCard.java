package aptech.t2008m.javaspring.identity;

import aptech.t2008m.javaspring.account.Account;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "identity_cards")
public class IdentityCard {
    @Id
    private String number;
    private String fullName;
    private Integer gender;
    private Date birthday;
    private String address;
    private String description;
    private String createdBy;
    private Date createdAt;
    private Date updatedAt;
    private Integer status;
    @OneToOne(mappedBy = "identityCard")
    private Account account;
}
