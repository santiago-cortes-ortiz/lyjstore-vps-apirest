package lyjstoreapirest.demo.usuario.infraestructure.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.tiposDeCuenta.domain.model.TipoDeCuenta;
import lyjstoreapirest.demo.usuario.domain.dto.UsuarioDTO;
import lyjstoreapirest.demo.usuario.domain.service.UsuarioCRUD;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable("idUsuario") String idUsuario){
        Optional<UsuarioDTO> usuarioDTO = usuarioCRUD.buscarUsuarioPorId(idUsuario);
        if (usuarioDTO.isEmpty()){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/api/v1/usuario/"+idUsuario);
            return new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(usuarioDTO.get(),HttpStatus.OK);
        }
    }

}
