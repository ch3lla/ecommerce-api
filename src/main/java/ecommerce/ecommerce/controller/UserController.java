package ecommerce.ecommerce.controller;

import ecommerce.ecommerce.model.Product;
import ecommerce.ecommerce.model.User;
import ecommerce.ecommerce.repository.ProductRepository;
import ecommerce.ecommerce.service.ProductService;
import ecommerce.ecommerce.service.UserService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> allUsers(){
        return new ResponseEntity<>(userService.allUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<User>> getSingleUser (@PathVariable ObjectId id){
        return  new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        try {
            User newUser = userService.createUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable ObjectId id, @RequestBody User updateUser){
        try {
            User updateUserData = userService.updateUser(id, updateUser);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser (@PathVariable ObjectId id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> allProducts () {
        return new ResponseEntity<>(productService.allProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/{productName}")
    public ResponseEntity<Optional<Product>> getSingleProduct ( @PathVariable String productName) {
        return new ResponseEntity<>(productService.getSingleProduct(productName), HttpStatus.OK);
    }

    @GetMapping("/products/brand/{productBrand}")
    public ResponseEntity<List<Product>> getProductBrand (@PathVariable String productBrand){
        return new ResponseEntity<List<Product>>(productService.getProductBrand(productBrand), HttpStatus.OK);
    }

}