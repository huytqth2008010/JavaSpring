package aptech.t2008m.javaspring.article.service;

import aptech.t2008m.javaspring.article.entity.Article;
import aptech.t2008m.javaspring.article.model.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    public List<Article> findAll(String title, String category){
        return articleRepository.search(title, category);
    }
    public Optional<Article> findById(Integer id) {
        return articleRepository.findById(id);
    }
    public Article save(Article article){
        return articleRepository.save(article);
    }
    public void deleteById(Integer id){
        articleRepository.deleteById(id);
    }
}
