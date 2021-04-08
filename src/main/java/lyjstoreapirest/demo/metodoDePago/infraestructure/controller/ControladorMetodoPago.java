package lyjstoreapirest.demo.metodoDePago.infraestructure.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.metodoDePago.application.MetodoDePagoServicio;
import lyjstoreapirest.demo.metodoDePago.domain.model.MetodoPago;
import lyjstoreapirest.demo.pedido.domain.model.Pedido;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/metodopago")
@AllArgsConstructor
public class ControladorMetodoPago {

    private MetodoDePagoServicio metodoDePagoServicio;

    @PostMapping
    public ResponseEntity<HttpHeaders> adicionarMetodoDePago(@RequestBody MetodoPago metodoPago){
        Long idMetodoPago = metodoDePagoServicio.guardar(metodoPago);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/metodopago/"+idMetodoPago);
        return  new  ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MetodoPago>> listarMetodosPago(){
        return new ResponseEntity<>(metodoDePagoServicio.listarMetodosPago(),HttpStatus.OK);
    }

    @GetMapping("{idMetodoPago}")
    public ResponseEntity<MetodoPago> buscarMetodoPagoPorId(@PathVariable("idMetodoPago") Long idMetodoPago){
        Optional<MetodoPago> metodoPagoABuscar = metodoDePagoServicio.buscarMetodoPagoPorId(idMetodoPago);
        if (metodoPagoABuscar.isEmpty()){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/api/v1/metodopago/"+idMetodoPago);
            return  new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(metodoPagoABuscar.get(),HttpStatus.OK);
        }
    }


}
