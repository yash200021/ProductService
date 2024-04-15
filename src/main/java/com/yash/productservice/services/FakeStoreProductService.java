package com.yash.productservice.services;

import com.yash.productservice.dtos.FakeStoreProductDTO;
import com.yash.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    @Autowired
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    @Override
    public Product getSingleProduct(Long productId) {
        FakeStoreProductDTO fakeStoreProductResponse = restTemplate.getForObject("https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDTO.class);

        return fakeStoreProductResponse.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
