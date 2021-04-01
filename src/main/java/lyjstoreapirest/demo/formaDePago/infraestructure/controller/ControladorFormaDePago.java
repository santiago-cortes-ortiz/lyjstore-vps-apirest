package lyjstoreapirest.demo.formaDePago.infraestructure.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.formaDePago.domain.model.FormaDePago;
import lyjstoreapirest.demo.formaDePago.domain.service.FormaDePagoServicio;
import lyjstoreapirest.demo.tiposDeCuenta.domain.model.TipoDeCuenta;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/formadepago")
@AllArgsConstructor
public class ControladorFormaDePago {

    private FormaDePagoServicio formaDePagoServicio;

    @PostMapping
    public ResponseEntity<HttpHeaders> adicionarFormaDePago(@RequestBody FormaDePago formaDePago){
        Long idFormaDePago = formaDePagoServicio.guardar(formaDePago);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/formadepago/"+idFormaDePago);
        return  new  ResponseEntity<>(headers, HttpStatus.CREATED);
    }

}
