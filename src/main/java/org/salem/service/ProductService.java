package org.salem.service;


import org.springframework.stereotype.Service;


import org.salem.login.model.Product;

@Service
public interface ProductService {

    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);

}