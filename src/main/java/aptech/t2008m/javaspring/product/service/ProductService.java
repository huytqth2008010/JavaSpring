package aptech.t2008m.javaspring.product.service;

import aptech.t2008m.javaspring.manytomany.usercompositekey.Grade;
import aptech.t2008m.javaspring.manytomany.usercompositekey.Student;
import aptech.t2008m.javaspring.manytomany.usercompositekey.StudentGrade;
import aptech.t2008m.javaspring.manytomany.usercompositekey.StudentGradeId;
import aptech.t2008m.javaspring.order.Order;
import aptech.t2008m.javaspring.order.OrderDetail;
import aptech.t2008m.javaspring.order.OrderDetailId;
import aptech.t2008m.javaspring.product.entity.Product;
import aptech.t2008m.javaspring.product.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Page<Product> findAll(int page, int limit) {
        return productRepository.findAll(
                PageRequest.of(page - 1, limit));
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public List<Product> findByNameAndPrice(String name, double price) {
        return productRepository.findAllByNameContainsAndPriceLessThanEqual(name, price);
    }

    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    public boolean addProductToClass(Product product, Order order) {
        try {
            //Lấy thông tin lớp học hiện tại cảu sinh viên
            Set<OrderDetail> orderDetails = product.getOrderDetailSet();
            if (orderDetails == null){
                //Trường hợp chưa join lớp nào thì mới set.
                orderDetails = new HashSet<>();
            }
            // tạo mới đối tượng orderDetail
            OrderDetail orderDetail = new OrderDetail() ;
            // set khoá chính phức hợp
            orderDetail.setId(new OrderDetailId(order.getId(), product.getId()));
            // set quan hệ ngược tại với order
            orderDetail.setOrder(order); ;
            // set quan hệ ngược lại với product
            orderDetail.setProduct(product); ;
            // đưa thông tin vào set
            orderDetails.add(orderDetail) ;
            // update trường orderdetail của product.
            product.setOrderDetailSet(orderDetails); ;
            // save thông tin product đồng thời Là save thông tin product order
            productRepository.save(product);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

}
