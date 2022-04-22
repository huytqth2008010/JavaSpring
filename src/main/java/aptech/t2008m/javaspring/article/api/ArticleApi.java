package aptech.t2008m.javaspring.article.api;

import aptech.t2008m.javaspring.article.entity.Article;
import aptech.t2008m.javaspring.article.model.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/articles")
public class ArticleApi {

    @Autowired
    ArticleRepository articleRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Article> getList(@RequestParam(defaultValue = "") String title,
                                 @RequestParam(defaultValue = "")String category){
        if(title.length() > 0 || category.length() > 0){
            return articleRepository.search(title, category);
        }else{
            return articleRepository.findAll();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Article save(@RequestBody Article article){
        articleRepository.save(article);
        return article;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Article getDetail(@PathVariable int id){
        return articleRepository.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public boolean delete(@PathVariable int id){
        articleRepository.deleteById(id);
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public Article update(@PathVariable int id, @RequestBody Article updateArticle){
        Article existing = articleRepository.findById(id).get();
        existing.setTitle(updateArticle.getTitle());
        existing.setDescription(updateArticle.getDescription());
        existing.setImage(updateArticle.getImage());
        existing.setContent(updateArticle.getContent());
        existing.setCategory(updateArticle.getCategory());
        existing.setCreatedAt(updateArticle.getCreatedAt());
        existing.setUpdatedAt(updateArticle.getUpdatedAt());
        existing.setStatus(updateArticle.getStatus());
        articleRepository.save(existing);
        return updateArticle;
    }
}
