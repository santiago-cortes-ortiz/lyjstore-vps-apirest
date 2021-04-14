package lyjstoreapirest.demo.usuario.infraestructure.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.usuario.domain.dto.UsuarioDTO;
import lyjstoreapirest.demo.usuario.domain.service.UsuarioCRUD;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuario")
@AllArgsConstructor
public class ControladorUsuario {

    private final UsuarioCRUD usuarioCRUD;

    @PostMapping
    public ResponseEntity<HttpHeaders> agregarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        String idUsuario = usuarioCRUD.guardarUsuario(usuarioDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/usuario/"+idUsuario);
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

}
