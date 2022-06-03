package ru.geekbrains.fundamentals_spring_framework_lesson3_spring_mvc_hw.services;

import ru.geekbrains.fundamentals_spring_framework_lesson3_spring_mvc_hw.model.Product;
import ru.geekbrains.fundamentals_spring_framework_lesson3_spring_mvc_hw.repositories.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> findProductsAll(){
        return productDao.findAll();
    }
    public Product findProductId(Long id){
        return productDao.findById(id);
    }
    public void saveNewProduct(String title, int cost){
        productDao.saveNewProduct(title, cost);
    }
    public void incCostOfProductByOne(Long id){
        productDao.incCostByOne(id);
    }
    public void decCostOfProductByOne(Long id){
        productDao.decCostByOne(id);
    }
    public void deleteProduct(Long id){
        productDao.deleteById(id);
    }
    public void updateCost(Long id, int cost){
        productDao.updateCost(id, cost);
    }
}
