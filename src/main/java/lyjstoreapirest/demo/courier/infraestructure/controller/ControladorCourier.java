package lyjstoreapirest.demo.courier.infraestructure.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.banco.domain.model.Banco;
import lyjstoreapirest.demo.courier.domain.model.Courier;
import lyjstoreapirest.demo.courier.domain.service.CourierServicio;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courier")
@AllArgsConstructor
public class ControladorCourier {
    private CourierServicio courierServicio;
    @PostMapping
    public ResponseEntity<HttpHeaders> adicionarCourier(@RequestBody Courier banco){
        Long idCourier = courierServicio.guardar(banco);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/courier/"+idCourier);
        return  new  ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Courier>> listarCouriers(){
        return new ResponseEntity<>(courierServicio.listarCouriers(),HttpStatus.OK);
    }
}
