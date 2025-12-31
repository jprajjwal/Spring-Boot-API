//package com.prajjwal.DemoSpring.Services;
//
//import com.prajjwal.DemoSpring.Model.Product;
//import org.springframework.stereotype.Service;
//
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//@Service
//public class ProductService {
//
//    List<Product> products = new ArrayList<>(Arrays.asList(
//            new Product(101,"Nike",10000),
//            new Product(102,"Adidas",7000),
//            new Product(103,"Puma",4000)));
//
//    public List<Product> getProduct(){
//        return products;
//    }
//
//    public Product getProductById(int prodId) {
//        for(Product product:products){
//            if(prodId==product.getProdId()){
//                return product;
//            }
//        }
//        return new Product(100,"No product", 000);
//    }
//
//    public void addProduct(Product prod) {
//        products.add(prod);
//    }
//
//    public void updateProduct(Product prod) {
//        for(Product item: products){
//            if(item.getProdId()==prod.getProdId()){
//                products.set(products.indexOf(item),prod);
//                break;
//            }
//        }
//    }
//
//    public void deleteProduct(int prodId) {
//        int idx=-1;
//        for(Product item: products){
//            if(item.getProdId()==prodId){
//                idx=products.indexOf(item);
//                break;
//            }
//        }
//        if(idx==-1){
//            System.out.println("Product Not Found-404");
//        }
//        else{
//            products.remove(idx);
//        }
//    }
//}

package com.prajjwal.SpringBootAPI.Services;

import com.prajjwal.SpringBootAPI.Model.Product;
import com.prajjwal.SpringBootAPI.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getProduct() {
        return repo.findAll();
    }

    public Product getProductById(int prodId) {
        return repo.findById(prodId).orElse(null);
    }

    public void addProduct(Product prod) {
        repo.save(prod);
    }

    public void updateProduct(Product prod) {
        repo.save(prod);
    }

    public void deleteProduct(int prodId) {
        repo.deleteById(prodId);
    }

    public List<Product> searchByNameAndMinPrice(String name, int minPrice) {
        return repo.searchByNameAndMinPrice(name, minPrice);
    }

}

