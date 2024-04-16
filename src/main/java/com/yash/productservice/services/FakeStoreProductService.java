package com.yash.productservice.services;

import com.yash.productservice.dtos.FakeStoreProductDTO;
import com.yash.productservice.dtos.ProductResponseDTO;
import com.yash.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private final RestTemplate restTemplate;

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

        String url = "https://fakestoreapi.com/products";
        FakeStoreProductDTO[] products = restTemplate.getForObject(url, FakeStoreProductDTO[].class);

        List<Product> productList = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO : products){
            productList.add(fakeStoreProductDTO.toProduct());
        }
        return productList;
    }

    @Override
    public Product createProduct(ProductResponseDTO productResponseDTO) {
        String url="https://fakestoreapi.com/products";
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(productResponseDTO.getTitle());
        fakeStoreProductDTO.setDescription(productResponseDTO.getDescription());
        fakeStoreProductDTO.setPrice(productResponseDTO.getPrice());
        fakeStoreProductDTO.setImage(productResponseDTO.getImage());
        fakeStoreProductDTO.setCategory(productResponseDTO.getCategory());
        FakeStoreProductDTO fakeStoreProductDTO1 = restTemplate.postForObject(url,fakeStoreProductDTO,FakeStoreProductDTO.class);
        Product product = fakeStoreProductDTO1.toProduct();
        return product;
    }

    @Override
    public void updateProduct(Long id, ProductResponseDTO productResponseDTO) {
        String url="https://fakestoreapi.com/products/";
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(productResponseDTO.getTitle());
        fakeStoreProductDTO.setDescription(productResponseDTO.getDescription());
        fakeStoreProductDTO.setPrice(productResponseDTO.getPrice());
        fakeStoreProductDTO.setImage(productResponseDTO.getImage());
        fakeStoreProductDTO.setCategory(productResponseDTO.getCategory());
        restTemplate.put(url + id,fakeStoreProductDTO);
    }


}
