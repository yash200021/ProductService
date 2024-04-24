package com.yash.productservice.repository;

import com.yash.productservice.models.Product;
import lombok.experimental.PackagePrivate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
     Optional<Product> findById(Long id);

     Product save(Product product);

     List<Product> findAll();

     Product findByIdIs(Long id);

     /*
     We don't always need the whole object in order to get the resultset
     Ex:- Suppose we are querying product table by category,
     We can call method as List<Product> findAllByCategory(Category c);
     But We can just call the same by Id or any other attribute of Category by giving "_"
     like :- List<Product> findAllByCategory_Id(Long id);
     Here we are using id of Category table to query Product table;
      */
     //HQL -> Hibernate Query Language
     @Query("select title from Product where description = :description")
     public Product findProductByDescription(@Param("description") String description);

     //Writing Native Query, it will run as it is, nothing to be added by Hibernate
     @Query(value = "select * from Product WHERE title = :title",nativeQuery = true)
     Product getProductByNativeQuery(@Param("title") String title);


     // Learn about Projections if possible
}
