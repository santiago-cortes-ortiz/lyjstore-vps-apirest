package lyjstoreapirest.demo.rol.infraestructure.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.formaDePago.domain.model.FormaDePago;
import lyjstoreapirest.demo.rol.domain.model.Rol;
import lyjstoreapirest.demo.rol.domain.service.RolServicio;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rol")
@AllArgsConstructor
public class ControladorRol {

    private RolServicio rolServicio;

    @PostMapping
    public ResponseEntity<HttpHeaders> adicionarRol(@RequestBody Rol rol){
        Long idRol = rolServicio.guardar(rol);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/rol/"+idRol);
        return  new  ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
