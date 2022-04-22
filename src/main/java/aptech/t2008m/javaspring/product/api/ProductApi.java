package aptech.t2008m.javaspring.product.api;

import aptech.t2008m.javaspring.product.entity.Product;
import aptech.t2008m.javaspring.product.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/products")
public class ProductApi {

    @Autowired
    ProductRepository productRepository;

//    private  static List<Product> productList ;
//    static {
//        productList = new ArrayList<>();
//        productList.add(new Product(1,"Huy 1","abc",1.1,1));
//        productList.add(new Product(2,"Huy 2","abc",2.1,1));
//        productList.add(new Product(3,"Huy 3","abc",3.1,1));
//        productList.add(new Product(4,"Huy 4","abc",4.1,1));
//    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getList(@RequestParam(defaultValue = "1") int page,
                                 @RequestParam(defaultValue = "10")int limit){
//        System.out.println("Page" + page);
//        System.out.println("Limit" + limit);
        return productRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product save(@RequestBody Product product){
//        productList.add(product);
        productRepository.save(product);
        return product;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Product getDetail(@PathVariable int id){
//        Product found = null;
//        for (Product product:
//                productList) {
//            if (product.getId() == id){
//                found = product;
//                break;
//            }
//        }

//        return found;
        return productRepository.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public boolean delete(@PathVariable int id){
//        Product found = null;
//        for (Product product:
//                productList) {
//            if (product.getId()  == id){
//                found = product;
//                break;
//            }
//        }
//        if (found != null){
//            productList.remove(found);
//        }
        productRepository.deleteById(id);
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public Product update(@PathVariable int id, @RequestBody Product updateProduct){
//        Product found = null;
//        for (Product product:
//                productList) {
//            if (product.getId() == id){
//                found = product;
//                break;
//            }
//        }
//        if (found != null){
//            found.setName(updateProduct.getName());
//            found.setDescription(updateProduct.getDescription());
//            found.setStatus(updateProduct.getStatus());
//        }
//        return found;
        Product existing = productRepository.findById(id).get();
        existing.setName(updateProduct.getName());
        existing.setDescription(updateProduct.getDescription());
        existing.setPrice(updateProduct.getPrice());
        productRepository.save(existing);
        return updateProduct;
    }
}
