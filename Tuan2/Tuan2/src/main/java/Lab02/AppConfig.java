package Lab02;


import Lab02.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public List<Book> getBooks()
    {
        List<Book> listBooks = new ArrayList<>();

        Book book1 = Book.builder()
                .Id(1L)
                .title("Hary Potter")
                .author("Hary")
                .price(100.00)
                .category("Khoa Học Viễn Tưởng")
                .build();
        listBooks.add(book1);

        Book book2 = Book.builder()
                .Id(2L)
                .title("Cây Cam Ngọt Của Tôi")
                .author("Phuong")
                .price(200.00)
                .category("Văn Học Nước Ngoài")
                .build();
        listBooks.add(book2);

        Book book3 = Book.builder()
                .Id(3L)
                .title("Bí Ẩn Phòng Giam Số 7")
                .author("Kiến Hôi")
                .price(300.00)
                .category("Văn Học Nước Ngoài")
                .build();
        listBooks.add(book3);

        Book book4 = Book.builder()
                .Id(4L)
                .title("Conna Thám Tử Lừng Danh")
                .author("Conan")
                .price(400.00)
                .category("Truyện Tranh Trinh Thám")
                .build();
        listBooks.add(book4);

        return listBooks;
    }

}
