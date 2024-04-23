package com.yash.productservice.dtos;


import com.yash.productservice.models.Category;
import com.yash.productservice.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private double price;
    private Category category;
    private String description;
    private String image;

    public Product toProduct(){
        Product product = new Product();

        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImage(image);
        product.setCategory(category);

        return product;
    }
}
