package crud.controllers;

import crud.models.Books;
import crud.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.List;

@RestController
public class BookController {

    BookService bookService;

    //Visualizar livro
    @GetMapping("/mostrarBook/{idBook}")
    public ResponseEntity<Books> mostrarBookId(@PathVariable Long idBook) {
        return bookService.findById(idBook)
                .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //Visualizar lista de livros
    @GetMapping("mostrarBooks")
    public ResponseEntity<List<Books>> mostrarBook(){
        List<Books> livros = bookService.findAll();
        if (livros.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(livros, HttpStatus.OK);
        }

    }

}
