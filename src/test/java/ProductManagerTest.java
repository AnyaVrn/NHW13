import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.example.Book;
import org.example.Product;
import org.example.SmartPhone;
import org.example.ProductManager;

public class ProductManagerTest {

    ProductManager manager = new ProductManager();

    Book book1 = new Book(1, "Stop doing this shit", "Bishep");
    Book book2 = new Book(2, "Yourself", "Gary");
    Book book3 = new Book(3, "Fun Yourself", "Gary");
    SmartPhone smartphone1 = new SmartPhone(4, "Iphone14", "USA");
    SmartPhone smartphone2 = new SmartPhone(5, "Iphone15", "USA");
    SmartPhone smartphone3 = new SmartPhone(6, "Honor50Pro", "China");

    @Nested
    class setupTests {
        @BeforeEach
        public void setup() {
            manager.add(book1);
            manager.add(book2);
            manager.add(book3);
            manager.add(smartphone1);
            manager.add(smartphone2);
            manager.add(smartphone3);

        }

        @Test
        void shouldManagerAddProduct() {

            Product[] actual = manager.findAll();
            Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        void shouldManagerFindSmartphoneByName() {

            Product[] actual = manager.searchBy("Honor");
            Product[] expected = {smartphone3};

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        void shouldManagerFindTwoSmartphonesByName() {

            Product[] actual = manager.searchBy("Iphone");
            Product[] expected = {smartphone1, smartphone2};

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        void shouldManagerFindSmartphoneByManufacturer() {

            Product[] actual = manager.searchBy("China");
            Product[] expected = {smartphone3};

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        void shouldManagerFindTwoSmartphonesByManufacturer() {

            Product[] actual = manager.searchBy("USA");
            Product[] expected = {smartphone1, smartphone2};

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        void shouldManagerFindBookByName() {

            Product[] actual = manager.searchBy("Stop");
            Product[] expected = {book1};

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        void shouldManagerFindTwoBooksByName() {

            Product[] actual = manager.searchBy("Yourself");
            Product[] expected = {book2, book3};

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        void shouldManagerFindBookByAuthor() {

            Product[] actual = manager.searchBy("Bishep");
            Product[] expected = {book1};

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        void shouldManagerFindTwoBooksByAuthor() {

            Product[] actual = manager.searchBy("Gary");
            Product[] expected = {book2, book3};

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        void shouldManagerSearchNotFound() {

            Product[] actual = manager.searchBy("John");
            Product[] expected = {};

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        void shouldRepositoryDeleteById() {

            manager.deleteById(2);
            manager.deleteById(3);
            manager.deleteById(5);

            Product[] actual = manager.findAll();
            Product[] expected = {book1, smartphone1, smartphone3};

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        void shouldRepositoryDeleteByNullId() {

            manager.deleteById(9);

            Product[] actual = manager.findAll();
            Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};

            Assertions.assertArrayEquals(expected, actual);
        }
    }

    @Nested
    class standAloneTests {
        @Test
        void shouldRepositoryDeleteByIdZeroArray() {
            manager.deleteById(1);

            Product[] actual = manager.findAll();
            Product[] expected = {};

            Assertions.assertArrayEquals(expected, actual);
        }
    }
}


