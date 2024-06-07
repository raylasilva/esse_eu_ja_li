package crud.controllers;

import crud.models.Usuario;
import crud.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<Usuario> acesso(@RequestBody Usuario loginRequest) {
        String username = loginRequest.getEmail();
        String password = loginRequest.getSenha();
        boolean user = loginService.autentificar(username, password);

        // Lógica para verificar o usuário e senha
        Usuario usuario = new Usuario();
        if (user == true) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
