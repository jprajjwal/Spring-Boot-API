package com.prajjwal.SpringBootAPI.Repository;

import com.prajjwal.SpringBootAPI.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p " +
            "WHERE LOWER(p.prodName) LIKE LOWER(CONCAT('%', :name, '%')) " +
            "AND p.prodPrice >= :minPrice")
    List<Product> searchByNameAndMinPrice(
            @Param("name") String name,
            @Param("minPrice") int minPrice);
}

