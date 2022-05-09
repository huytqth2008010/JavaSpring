package aptech.t2008m.javaspring.product.seed;

import aptech.t2008m.javaspring.product.entity.Product;
import aptech.t2008m.javaspring.product.model.ProductRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class ProductDataLoader  {
    @Autowired
    ProductRepository productRepository;
    private static List<String> listImageUrl=
            Arrays.asList(
                    "https://jes.edu.vn/wp-content/uploads/2017/10/h%C3%ACnh-%E1%BA%A3nh.jpg"
            );

//    @Override
//    public void run(String... args) throws Exception {
//        Faker faker = new Faker();
//        productRepository.deleteAll();
//        List<Product> list = new ArrayList<>();
//        Random rand = new Random () ;
//        for (int i = 1; i < 100; i++) {
//            list.add(new Product(
//                    i,
//                    faker.name().title(),
//                    listImageUrl.get(rand.nextInt(listImageUrl.size())),
//                    faker.number().randomDouble(2, 10,100),
//                    faker.number().randomDigitNotZero()
//                )
//            );
//        }
//        productRepository.saveAll(list);
//        System.out.println("Save all seed data.");
//    }
}
