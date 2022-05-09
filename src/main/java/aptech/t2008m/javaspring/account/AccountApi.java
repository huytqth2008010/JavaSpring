//package aptech.t2008m.javaspring.account;
//
//import aptech.t2008m.javaspring.identity.IdentityCard;
//import aptech.t2008m.javaspring.manytomany.Author;
//import aptech.t2008m.javaspring.manytomany.Book;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Calendar;
//import java.util.HashSet;
//import java.util.List;
//
//@RestController
//@RequestMapping(path = "api/v1/accounts")
//public class AccountApi {
//
//    @Autowired
//    private AccountRepository accountRepository; // test dung tam
//    @Autowired
//    private AuthorRepository authorRepository;
//
//    @RequestMapping(method = RequestMethod.GET, path = "/test01")
//    public ResponseEntity<?> test01() {
//        Account account = new Account();
//        IdentityCard identityCard = new IdentityCard();
//        identityCard.setAddress("HN");
//        identityCard.setBirthday(Calendar.getInstance().getTime());
//        identityCard.setCreatedAt(Calendar.getInstance().getTime());
//        identityCard.setUpdatedAt(Calendar.getInstance().getTime());
//        identityCard.setDescription("DES");
//        identityCard.setGender(1);
//        identityCard.setFullName("Full Name");
//        identityCard.setNumber("00123001234");
//        identityCard.setStatus(1);
//        account.setStatus(1);
//        account.setIdentityCard(identityCard); // tao quan he
//        account.setUsername("account01");
//        accountRepository.save(account);
//        System.out.println(accountRepository.findAll().get(0).getIdentityCard());
//        return ResponseEntity.status(HttpStatus.OK).body("Okie");
//    }
//
//    @RequestMapping(method = RequestMethod.GET, path = "/test02")
//    public ResponseEntity<?> test02() {
//        Author author = new Author();
//        author.setName("Tacgia 01");
//
//        Book book = new Book();
//        book.setName("Sach 01");
//
//        HashSet<Book> books = new HashSet<>();
//        books.add(book);
//
//        author.setBooks(books)
//        ;
//
//        authorRepository.save(author);
//
//        List<Author> list = authorRepository.findAll();
//        System.out.println(list.size());
//        return ResponseEntity.status(HttpStatus.OK).body("Okie");
//    }
//}