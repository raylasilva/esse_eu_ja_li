package crud.services;

import crud.models.Usuario;
import crud.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;
    public boolean autentificar(String email, String senha){

        Usuario email1 = loginRepository.findByEmail(email);

        if (email1 != null) {
            // Verifica se a senha inserida corresponde à senha armazenada no banco de dados

            return senha.equals(email1.getSenha());
        }
        return false;
    }
    }

