package ru.geekbrains.fundamentals_spring_framework_lesson3_spring_mvc_hw.services;

import ru.geekbrains.fundamentals_spring_framework_lesson3_spring_mvc_hw.model.Product;
import ru.geekbrains.fundamentals_spring_framework_lesson3_spring_mvc_hw.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findProductsAll(){
        return productRepository.findProductsAll();
    }
    public Product findProductId(Long id){
        return productRepository.findProductId(id);
    }
    public void saveNewProduct(Product product){
        productRepository.saveNewProduct(product);
    }
    public void incCostOfProductByOne(Long id){
        productRepository.incCostByOne(id);
    }
    public void decCostOfProductByOne(Long id){
        productRepository.decCostByOne(id);
    }
}
