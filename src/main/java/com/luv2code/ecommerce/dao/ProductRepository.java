package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

// accept calls from web browser scripts for this origin
// protocol + hostname + port
@CrossOrigin("http://localhost:4200/")
public interface ProductRepository extends JpaRepository<Product, Long> {

    // query method to find and match by category id
    // Behind the scenes, Spring will execute a query like
    // SELECT * FROM Product where category_id=?
    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);

    // SELECT * FROM Product p WHERE p.name LIKE CONCAT('%', :name, '%')
    Page<Product> findByNameContaining(@Param("name") String name, Pageable pageable);

}
