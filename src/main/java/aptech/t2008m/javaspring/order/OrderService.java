package aptech.t2008m.javaspring.order;

import aptech.t2008m.javaspring.manytomany.usercompositekey.Grade;
import aptech.t2008m.javaspring.manytomany.usercompositekey.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Order save(Order grade){
        orderRepository.save(grade);
        return grade;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> findById(int orderId) {
        return orderRepository.findById(orderId);
    }
}
