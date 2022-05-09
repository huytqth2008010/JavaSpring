package aptech.t2008m.javaspring.product.api;

import aptech.t2008m.javaspring.manytomany.usercompositekey.Grade;
import aptech.t2008m.javaspring.manytomany.usercompositekey.GradeService;
import aptech.t2008m.javaspring.manytomany.usercompositekey.Student;
import aptech.t2008m.javaspring.manytomany.usercompositekey.StudentService;
import aptech.t2008m.javaspring.order.Order;
import aptech.t2008m.javaspring.order.OrderService;
import aptech.t2008m.javaspring.product.entity.Product;
import aptech.t2008m.javaspring.product.model.ProductRepository;
import aptech.t2008m.javaspring.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/products")
public class ProductApi {

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;
    //    private  static List<Product> productList ;
//    static {
//        productList = new ArrayList<>();
//        productList.add(new Product(1,"Huy 1","abc",1.1,1));
//        productList.add(new Product(2,"Huy 2","abc",2.1,1));
//        productList.add(new Product(3,"Huy 3","abc",3.1,1));
//        productList.add(new Product(4,"Huy 4","abc",4.1,1));
//    }
    @RequestMapping(method = RequestMethod.GET)
    public Page<Product> getList(@RequestParam(defaultValue = "1") int page,
                                 @RequestParam(defaultValue = "1") int limit) {
        return productService.findAll(page, limit);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/get-all")
    public List<Product> getList() {
        return productService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product save(@RequestBody Product product) {
//        productList.add(product);
        productService.save(product);
        return product;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Product getDetail(@PathVariable int id) {
//        Product found = null;
//        for (Product product:
//                productList) {
//            if (product.getId() == id){
//                found = product;
//                break;
//            }
//        }

//        return found;
        return productService.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public boolean delete(@PathVariable int id) {
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
        productService.deleteById(id);
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public Product update(@PathVariable int id, @RequestBody Product updateProduct) {
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
        Product existing = productService.findById(id).get();
        existing.setName(updateProduct.getName());
        existing.setDescription(updateProduct.getDescription());
        existing.setPrice(updateProduct.getPrice());
        productService.save(existing);
        return updateProduct;
    }

    @RequestMapping(method = RequestMethod.GET, path = "add-order")
    public ResponseEntity<?> addProductToOrder(
            @RequestParam int orderId,
            @RequestParam int productId) {
        // check sự tồn tại cùa product
        Optional<Product> optionalProduct = productService.findById(productId) ;
        // check sự tồn tại của order
        Optional<Order> optionalOrder = orderService.findById(orderId) ;
        // trà về not found nếu một trong 2 trường hợp không tìm thấy
        if (!optionalProduct.isPresent() || !optionalOrder.isPresent()){
            return new ResponseEntity<>( "Not found", HttpStatus.NOT_FOUND) ;
        }
        boolean resutlt = productService.addProductToClass(optionalProduct.get(), optionalOrder.get());
        if (!resutlt) {
            return new ResponseEntity<>("Add product error!", HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
        return new ResponseEntity<>( "Add product success!", HttpStatus.OK);
    }
}
