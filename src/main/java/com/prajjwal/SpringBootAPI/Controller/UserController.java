//package com.prajjwal.DemoSpring.Controller;
//
//import com.prajjwal.DemoSpring.Model.Product;
//import com.prajjwal.DemoSpring.Services.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class ProductController {
//    @Autowired
//    ProductService service;
//
//    @GetMapping("/product")
//    public List<Product> getProduct(){
//        return service.getProduct();
//    }
//
//    @GetMapping("/product/{prodId}")
//    public Product getProductById(@PathVariable int prodId){
//        return service.getProductById(prodId);
//    }
//
//    @PostMapping("/product")
//    public void addProduct(@RequestBody Product prod){
//        service.addProduct(prod);
//        System.out.println("Product added Successfully");
//    }
//    @PutMapping("/product")
//    public void updateProduct(@RequestBody Product prod){
//        service.updateProduct(prod);
//    }
//
//    @DeleteMapping("/product/{prodId}")
//    public void deleteProduct(@PathVariable int prodId){
//        service.deleteProduct(prodId);
//    }
//
//
//}

package com.prajjwal.SpringBootAPI.Controller;

import com.prajjwal.SpringBootAPI.Model.Product;
import com.prajjwal.SpringBootAPI.Services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    ProductService service;

    @GetMapping("/user/product")
    public ResponseEntity<List<Product>> getProduct() {
        return new ResponseEntity<>(service.getProduct(), HttpStatus.OK);
    }

    @GetMapping("/user/product/{prodId}")
    public ResponseEntity<Product> getProductById(@PathVariable int prodId) {
        Product product=service.getProductById(prodId);
        if(product!=null){
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user/product")
    public ResponseEntity<String> addProduct(@RequestBody Product prod) {
        try {
            service.addProduct(prod);
            return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error adding product", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/user/product")
    public ResponseEntity<String> updateProduct(@RequestBody Product prod) {
        Product existing = service.getProductById(prod.getProdId());

        if (existing != null) {
            service.updateProduct(prod);
            return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/admin/product/{prodId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteProduct(@PathVariable int prodId) {

        Product existing = service.getProductById(prodId);

        if (existing != null) {
            service.deleteProduct(prodId);
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/product/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam String name, @RequestParam int minPrice) {
        List<Product> products = service.searchByNameAndMinPrice(name, minPrice);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/admin/CSRF-Token")
    public CsrfToken getToken(HttpServletRequest req){
        return (CsrfToken) req.getAttribute("_csrf");
    }


}
