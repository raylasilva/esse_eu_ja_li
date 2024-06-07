package crud.services;

import crud.models.Books;
import crud.models.Usuario;
import crud.repositories.BookRepository;
import crud.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    BookRepository bookRepository;

    public Usuario save(Usuario usuario){
      return usuarioRepository.save(usuario);

    }

    public List<Usuario> findAll(){
    return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long idUsuario){
        return usuarioRepository.findById(idUsuario);
    }
    public Usuario updateById(Long idUsuario, Usuario usuario){
        usuario.setIdUsuario(idUsuario);
        return usuarioRepository.save(usuario);
    }
    public void deleteById(Long idUsuario){
     usuarioRepository.deleteById(idUsuario);

    }

    public List<Usuario> findAllRanking(){
    return usuarioRepository.findAllByOrderByPontosDesc();
    }


}
