package aptech.t2008m.javaspring.order;

import aptech.t2008m.javaspring.manytomany.usercompositekey.Grade;
import aptech.t2008m.javaspring.manytomany.usercompositekey.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/orders")
public class OrderApi {
    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public Order save(@RequestBody Order order){
        return orderService.save(order);
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Order> findAll(){
        return orderService.findAll();
    }
}
