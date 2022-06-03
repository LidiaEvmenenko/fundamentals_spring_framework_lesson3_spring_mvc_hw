package ru.geekbrains.fundamentals_spring_framework_lesson3_spring_mvc_hw.repositories;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Factory {
    private SessionFactory factory;

    public void init() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public Factory() {
    }

    public SessionFactory getFactory() {
        return factory;
    }

}
