package ru.geekbrains.fundamentals_spring_framework_lesson3_spring_mvc_hw.repositories;

import ru.geekbrains.fundamentals_spring_framework_lesson3_spring_mvc_hw.model.Product;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;
    @PostConstruct
    public void init(){
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Хлеб", 50),
                new Product(2L, "Мука", 95),
                new Product(3L, "Яйцо", 75),
                new Product(4L, "Сметана", 54),
                new Product(5L, "Творог", 159),
                new Product(6L, "Колбаса", 360),
                new Product(7L, "Сыр", 650),
                new Product(8L, "Конфеты", 400),
                new Product(9L, "Сок", 80),
                new Product(10L, "Шоколад", 100)
        ));
    }
    public List<Product> findProductsAll(){
        return Collections.unmodifiableList(products);
    }
    public Product findProductId(Long id){
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().get();
    }
    public void saveNewProduct(Product product){
        Long newId = products.stream().mapToLong(Product::getId).max().getAsLong() + 1;
        product.setId(newId);
        products.add(product);
    }
    public void incCostByOne(Long id){
        Product product = findProductId(id);
        product.setCost(product.getCost() + 1);
    }
    public void decCostByOne(Long id){
        Product product = findProductId(id);
        product.setCost(product.getCost() - 1);
    }
}
