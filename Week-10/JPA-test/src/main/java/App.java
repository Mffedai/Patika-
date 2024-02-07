import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("market");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();


        //Supplier Ekleme
        Supplier supplier = new Supplier();
        supplier.setPerson("Fatih");
        supplier.setCompany("patika");
        supplier.setAddress("adres");
        supplier.setContact("533322113");
        supplier.setMail("info@patika.com");
        entityManager.persist(supplier);

        //Category ekleme
        Category category = new Category();
        category.setName("Telefonlar");
        entityManager.persist(category);


        //Code ekleme
        Code code = new Code();
        code.setGroup("11123");
        code.setSerial("44456");
        entityManager.persist(code);

        //Product Ekleme
        Product product = new Product();
        product.setName("Iphone 15pro");
        product.setPrice(1234);
        product.setStock(100);
        product.setCode(code);
        product.setSupplier(supplier);
        product.setCategory(category);
        entityManager.persist(product);
        System.out.println(product);


        Color blue = new Color("blue");
        Color red = new Color("red");
        Color yellow = new Color("yellow");

        entityManager.persist(blue);
        entityManager.persist(red);
        entityManager.persist(yellow);

        List<Color> colorList = new ArrayList<>();
        colorList.add(blue);
        colorList.add(red);
        product.setColorList(colorList);

        entityManager.persist(product);
        System.out.println(product);

        transaction.commit();
    }
}
