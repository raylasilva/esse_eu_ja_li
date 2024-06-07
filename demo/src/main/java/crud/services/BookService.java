package crud.services;

import crud.models.Books;
import crud.models.Usuario;
import crud.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

@Autowired
    BookRepository bookRepository;

    public List<Books> findAll(){
      return  bookRepository.findAll();
    }

    public Optional<Books> findById(Long idBook){
        return bookRepository.findById(idBook);

    }


}
