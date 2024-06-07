package crud.controllers;

import crud.models.Books;
import crud.models.Usuario;
import crud.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/mostrarnome/{nome}")
    public String mostrarNome(@PathVariable String nome){
        return "Olá, " + nome + ", bem vindo(a)";
    }

//Criar usuario
    @PostMapping("/criarUsuario")
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
        usuarioService.save(usuario);
        return new ResponseEntity<>(usuario,HttpStatus.CREATED);
    }

    //mostrar Usuario
    @GetMapping("/mostrarUsuario")
    public ResponseEntity<List<Usuario>> mostrarUsuario(){
        List<Usuario> usuarios = usuarioService.findAll();
        if(usuarios.isEmpty()){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        }
    }

    //Mostrar usuario por id

    @GetMapping("/mostrarUsuario/{idUsuario}")
    public ResponseEntity<Usuario> mostrarId(@PathVariable Long idUsuario){
       return usuarioService.findById(idUsuario)
               .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
               .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));


    }
    @PutMapping("/alterarUsuario/{idUsuario}")
    public ResponseEntity<Usuario> alterarPorId(@PathVariable Long idUsuario, @RequestBody Usuario usuario){
       Usuario updateUsuario = usuarioService.updateById(idUsuario,usuario);
        return new ResponseEntity<>(updateUsuario,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idUsuario}")
    public ResponseEntity<Usuario> deletarPorId(@PathVariable Long idUsuario){
        usuarioService.deleteById(idUsuario);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    //Ranking de usuarios
    @GetMapping("/rankingUsuarios")
    public ResponseEntity<List<Usuario>> mostrarRanking(){
        List<Usuario> usuarios = usuarioService.findAllRanking();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

}
