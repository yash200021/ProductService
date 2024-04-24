package com.yash.productservice.services;

import com.yash.productservice.dtos.ProductResponseDTO;
import com.yash.productservice.models.Category;
import com.yash.productservice.models.Product;
import com.yash.productservice.repository.CategoryRepository;
import com.yash.productservice.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfproductservice")
@Primary
public class UsersOwnProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public UsersOwnProductService(ProductRepository productRepository,CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long id) {
        return productRepository.findByIdIs(id);
    }

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public Product createProduct(ProductResponseDTO productResponseDTO) {
        Product product = new Product();

        product.setTitle(productResponseDTO.getTitle());
        product.setDescription(productResponseDTO.getDescription());
        product.setPrice(productResponseDTO.getPrice());
        product.setImage(productResponseDTO.getImage());

        Category categoryFromDatabase = categoryRepository.findByTitle(productResponseDTO.getCategory());
        if(categoryFromDatabase == null) {
            Category newCategory = new Category();
            newCategory.setTitle(productResponseDTO.getCategory());
            categoryFromDatabase = newCategory;
        }
        
        product.setCategory(categoryFromDatabase);
        return productRepository.save(product);
    }

    @Override
    public void updateProduct(Long id, ProductResponseDTO productResponseDTO) {

    }

    @Override
    public void deleteProduct(Long id) {

    }
}
