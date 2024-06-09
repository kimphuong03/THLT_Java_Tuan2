package Lab02.controller;

import Lab02.model.Book;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;


@Controller
public class BookController {

    @Autowired
    private List<Book> listBook;

    @GetMapping("/books")
    public String showAllBooks(Model model) {
        model.addAttribute("listBook", listBook);
        model.addAttribute("title", "Danh sách cuốn sách");
        return "book/list";
    }

    @GetMapping("/books/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @PostMapping("/books/add")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Trả về view với thông tin lỗi
            return "book/add";
        }

        // Nếu không có lỗi, thêm sách mới vào danh sách
        listBook.add(book);
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{id}")
    public String editBookForm(@PathVariable("id") Long id, Model model) {
        Optional<Book> editBook = listBook.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
        if (editBook.isPresent()) {
            model.addAttribute("book", editBook.get());
            return "book/edit";
        } else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editBook(@ModelAttribute("book") Book updatedBook) {
        listBook.stream()
                .filter(book -> book.getId().equals(updatedBook.getId()))
                .findFirst()
                .ifPresent(book -> listBook.set(listBook.indexOf(book), updatedBook));
        return "redirect:/books";
    }


    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id)
    {
        listBook.removeIf(book -> book.getId().equals(id));
        return "redirect:/books";
    }

}
