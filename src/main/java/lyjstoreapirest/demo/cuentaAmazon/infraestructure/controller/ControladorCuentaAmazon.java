package lyjstoreapirest.demo.cuentaAmazon.infraestructure.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.cuentaAmazon.domain.model.CuentaAmazon;
import lyjstoreapirest.demo.cuentaAmazon.domain.service.CuentaAmazonServicio;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/amazoncuenta")
@AllArgsConstructor
public class ControladorCuentaAmazon {

    private CuentaAmazonServicio cuentaAmazonServicio;

    @PostMapping
    public ResponseEntity<HttpHeaders> adicionarCuentaAmazon(@RequestBody CuentaAmazon cuentaAmazon){
        Long idCuentaAmazon = cuentaAmazonServicio.guardar(cuentaAmazon);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/amazoncuenta/"+idCuentaAmazon);
        return  new  ResponseEntity<>(headers, HttpStatus.CREATED);
    }

}
