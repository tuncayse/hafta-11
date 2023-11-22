import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("market");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
/*
        Code code = new Code();
        code.setSerial("1234");
        code.setGroup("1234");

        Product product = new Product();
        product.setName("Test");
        product.setStock(10);
        product.setPrice(123);
        product.setCategory(entityManager.find(Category.class,1));
        product.setSupplier(entityManager.find(Supplier.class,1));
        product.setCode(code);
        entityManager.persist(product);


 */

        transaction.commit();


    }
}
