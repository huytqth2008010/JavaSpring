package aptech.t2008m.javaspring.product.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //Gia tri tu tang
    private int id;

//    @Column(name = "name", columnDefinition = "varchar(250)")
    private String name;
    private String description;
    private Double price;
    private int status;

    public Product(String name, String description, Double price, int status) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
    }
}
