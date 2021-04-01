package lyjstoreapirest.demo.tiposDeCuenta.infraestructure.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.tiposDeCuenta.domain.model.TipoDeCuenta;
import lyjstoreapirest.demo.tiposDeCuenta.domain.service.TiposDeCuentaServicio;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tipodecuenta")
@AllArgsConstructor
public class ControladorTiposDeCuenta {

    private TiposDeCuentaServicio tiposDeCuentaServicio;

    @PostMapping
    public ResponseEntity<HttpHeaders> adicionarTipoDeCuenta(@RequestBody TipoDeCuenta tipoDeCuenta){
        Long idTipoDeCuenta = tiposDeCuentaServicio.guardar(tipoDeCuenta);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/tipodecuenta/"+idTipoDeCuenta);
        return  new  ResponseEntity<>(headers, HttpStatus.CREATED);
    }

}
