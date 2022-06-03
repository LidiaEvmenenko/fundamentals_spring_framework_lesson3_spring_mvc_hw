package ru.geekbrains.fundamentals_spring_framework_lesson3_spring_mvc_hw.repositories;
import ru.geekbrains.fundamentals_spring_framework_lesson3_spring_mvc_hw.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class ProductDao {
    private SessionFactory factory;

    @PostConstruct
    public void setFactory(){
        Factory f = new Factory();
        f.init();
        this.factory = f.getFactory();
    }

    public ProductDao() {
    }

    public List<Product> findAll(){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("select p from Product p").getResultList();
        session.getTransaction().commit();
        return products;
    }
    public Product findById(Long id) {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }catch (NullPointerException e){
            System.out.println("Нет продукта.");
        }
        return null;
    }
    public void deleteById(Long id){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.delete(product);
        session.getTransaction().commit();
    }
    public void saveNewProduct(String title, int cost){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Product product = new Product(title, cost);
        session.save(product);
        session.getTransaction().commit();
    }
    public void incCostByOne(Long id){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        product.setCost(product.getCost() + 1);
        session.getTransaction().commit();
    }
    public void decCostByOne(Long id){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        product.setCost(product.getCost() - 1);
        session.getTransaction().commit();
    }
    public void updateCost(Long id, int cost){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        product.setCost(cost);
        session.getTransaction().commit();
    }
}
