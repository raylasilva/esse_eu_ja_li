package crud.repositories;

import crud.models.Books;
import crud.models.Usuario;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u JOIN u.books b GROUP BY u.idUsuario ORDER BY SUM(b.pontos) DESC")
    List<Usuario> findAllByOrderByPontosDesc();



}
