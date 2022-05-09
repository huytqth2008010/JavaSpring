package aptech.t2008m.javaspring.account;

import aptech.t2008m.javaspring.identity.IdentityCard;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String passwordHash;
//    @Column(name = "identity_card_number")
//    private String identityCardNumber; //Khoa phu
    @OneToOne
//    @JoinColumn(name = "identity_card_number", insertable = false, updatable = false)
    @JoinColumn(name = "identity_card_number")

    private IdentityCard identityCard;
    private Integer status;
}
