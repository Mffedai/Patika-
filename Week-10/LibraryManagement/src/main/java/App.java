
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        //Author Adding
        Author author = new Author();
        author.setName("Dan Brown");
        author.setBirthday(LocalDate.ofEpochDay(22/06/1964));
        author.setCountry("American");
        entityManager.persist(author);

        //Publisher Adding
        Publisher publisher = new Publisher();
        publisher.setName("Pegasus");
        publisher.setAddress("İstanbul/Beyoğlu");
        publisher.setEstablishmentYear(2006);
        entityManager.persist(publisher);

        //Category Adding
        Category categoryNovel = new Category();
        categoryNovel.setName("Novel");
        categoryNovel.setDefiniton("a fictitious prose narrative of book length, typically representing character and action with some degree of realism.");
        entityManager.persist(categoryNovel);

        Category categoryAction = new Category();
        categoryAction.setName("Action");
        categoryAction.setDefiniton("Action fiction is a literary genre that focuses on stories that involve high-stakes, high-energy, and fast-paced events.");
        entityManager.persist(categoryAction);

        ArrayList<Category> categoryArrayList = new ArrayList<>();
        categoryArrayList.add(categoryNovel);
        categoryArrayList.add(categoryAction);

        //Book Adding
        Books books = new Books();
        books.setName("The Da Vinci Code");
        books.setPublicationYear(2003);
        books.setStock(90);
        books.setAuthor(author);
        books.setPublisher(publisher);
        books.setCategoryList(categoryArrayList);
        entityManager.persist(books);

        //BookBorrowing Adding
        BookBorrowing bookBorrowing = new BookBorrowing();
        bookBorrowing.setBorrowerName("Fatih Fedai");
        bookBorrowing.setBorrowingDate(LocalDate.ofEpochDay(02/05/2023));
        bookBorrowing.setReturnDate(LocalDate.ofEpochDay(16/05/2023));
        bookBorrowing.setBook(books);
        entityManager.persist(bookBorrowing);

        System.out.println(books);

        transaction.commit();

    }
}