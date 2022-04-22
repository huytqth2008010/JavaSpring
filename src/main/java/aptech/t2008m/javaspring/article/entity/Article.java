package aptech.t2008m.javaspring.article.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //Gia tri tu tang
    private int id;

//    @Column(name = "name", columnDefinition = "varchar(250)")
    private String title;
    private String description;
    private String image;
    private String content;
    private String Category;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    private int status;

}
