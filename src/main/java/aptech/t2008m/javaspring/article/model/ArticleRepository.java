package aptech.t2008m.javaspring.article.model;

import aptech.t2008m.javaspring.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    @Query(value = "SELECT * FROM articles a WHERE a.title LIKE %:title% and a.category LIKE %:category%",
            nativeQuery = true)
    List<Article> search(
            @Param("title") String title, @Param("category") String category);
}
