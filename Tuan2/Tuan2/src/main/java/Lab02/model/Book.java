package Lab02.model;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @NotNull(message = "ID khong duoc de trong")
    @Min(value = 1, message = "ID phai la so nguyen duong lon hon 0")
    private Long Id;

    @NotBlank(message = "Tieu de khong duoc de trong")
    @Size(max = 100, message = "Tieu de khong duoc vuot qua 100 ki tu")
    private String title;

    @NotBlank(message = "Tac gia khong duoc de trong")
    @Size(max = 100, message = "Ten tac gia khong duoc vuot qua 100 ki tu"  )
    private String author;
    @NotNull(message = "Gia khong duoc de trong")
    @Min(value = 1, message = "Gia phai la mot so khong am")
    private Double price;
    @NotBlank(message = "The loai khong duoc de trong")
    @Pattern(regexp = "^[A-Za-z]+$", message = "The loai chi chap nhan chu cai va khoang trang")
    private String category;


}
