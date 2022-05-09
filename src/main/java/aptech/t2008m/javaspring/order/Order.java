package aptech.t2008m.javaspring.order;

import aptech.t2008m.javaspring.manytomany.Author;
import aptech.t2008m.javaspring.product.BaseEntity;
import aptech.t2008m.javaspring.product.entity.Product;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int customerId;
    private Double totalPrice;
    private String shipName;
    private String shipAddress;
    private int shipPhone;
    private Date createsAt;
    private Date updateAt;
    private int status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetailSet;
}
