import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();



        transaction.begin();


        //yazar
        Author author = new Author();
        author.setName("Reşat Nuri Güntekin");
        author.setBirthday(LocalDate.parse("1889-02-02"));
        author.setCountry("İstanbul");
        entityManager.persist(author);

        Author author1 = new Author();
        author1.setName("Sarah JIO");
        author1.setBirthday(LocalDate.parse("2013-11-02"));
        author1.setCountry("Seattle");
        entityManager.persist(author1);

        Author author2 = new Author();
        author2.setName("Sait Faik Abasıyanık");
        author2.setBirthday(LocalDate.parse("1906-11-18"));
        author2.setCountry("Adapazarı");
        entityManager.persist(author2);

        Author author3 = new Author();
        author3.setName("Kimberley Freeman");
        author3.setBirthday(LocalDate.parse("1975-11-18"));
        author3.setCountry("Londra");
        entityManager.persist(author3);



        //yayınevi
        Publisher publisher = new Publisher();
        publisher.setPublisherName("İnkılap");
        publisher.setAddress("Istanbul");
        publisher.setEstablishmentYear(1927);
        entityManager.persist(publisher);

        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("Arkadya");
        publisher1.setAddress("Istanbul");
        publisher1.setEstablishmentYear(1980);
        entityManager.persist(publisher1);

        Publisher publisher2 = new Publisher();
        publisher2.setPublisherName("YKY");
        publisher2.setAddress("Istanbul");
        publisher2.setEstablishmentYear(1992);
        entityManager.persist(publisher2);

        //Kİtap
        Book book = new Book();
        book.setName("Acımak");
        book.setPublicationYear(1928);
        book.setStock(200);
        book.setAuthor(author);
        book.setPublisher(publisher);
        entityManager.persist(book);

        Book book1 = new Book();
        book1.setName("Böğürtlen Kışı");
        book1.setPublicationYear(2013);
        book1.setStock(200);
        book1.setAuthor(author1);
        book1.setPublisher(publisher1);
        entityManager.persist(book1);

        Book book2 = new Book();
        book2.setName("Alemdağ'da Var Bir Yılan");
        book2.setPublicationYear(1954);
        book2.setStock(200);
        book2.setAuthor(author2);
        book2.setPublisher(publisher2);
        entityManager.persist(book2);

        Book book3 = new Book();
        book3.setName("Lüzumsuz Adam");
        book3.setPublicationYear(1948);
        book3.setStock(100);
        book3.setAuthor(author2);
        book3.setPublisher(publisher2);
        entityManager.persist(book3);

        Book book4 = new Book();
        book4.setName("Çalıkuşu");
        book4.setPublicationYear(1954);
        book4.setStock(200);
        book4.setAuthor(author);
        book4.setPublisher(publisher);
        entityManager.persist(book4);

        Book book5 = new Book();
        book5.setName("Kır Çiçeği Tepesi");
        book5.setPublicationYear(2013);
        book5.setStock(200);
        book5.setAuthor(author3);
        book5.setPublisher(publisher1);
        entityManager.persist(book5);

        BookBorrowing bookBorrowing = new BookBorrowing();
        bookBorrowing.setBorrowingDate(LocalDate.parse("2023-10-15"));
        bookBorrowing.setBook(book);
        bookBorrowing.setReturnDate(LocalDate.now().plusDays(5));
        bookBorrowing.setBorrowerName("Ayşe Tunç");
        entityManager.persist(bookBorrowing);

        BookBorrowing borrowing = entityManager.find(BookBorrowing.class,1);
        borrowing.setReturnDate(LocalDate.parse("2023-10-15"));
        entityManager.persist(borrowing);

        BookBorrowing bookBorrowing1 = new BookBorrowing();
        bookBorrowing1.setBorrowingDate(LocalDate.parse("2023-05-15"));
        bookBorrowing1.setBook(book1);
        bookBorrowing1.setReturnDate(LocalDate.now().plusDays(4));
        bookBorrowing1.setBorrowerName("Sümeyye Bal");
        entityManager.persist(bookBorrowing1);

        BookBorrowing borrowing1 = entityManager.find(BookBorrowing.class,2);
        borrowing1.setReturnDate(LocalDate.parse("2023-05-15"));
        entityManager.persist(borrowing1);



        Category category = new Category();
        category.setName("Duygusal");
        category.setDescription("Duygusal Konular");
        entityManager.persist(category);

        Category category1 = new Category();
        category1.setName("Siyasi");
        category1.setDescription("Siyasi Konular");
        entityManager.persist(category1);

        Category category2 = new Category();
        category2.setName("Kurgu");
        category2.setDescription("Kurgu Konular");
        entityManager.persist(category2);


        List<Category> categoryList = new ArrayList<>();
        categoryList.add(category);
        book5.setCategoryList(categoryList);
        book1.setCategoryList(categoryList);



        transaction.commit();
    }
}
