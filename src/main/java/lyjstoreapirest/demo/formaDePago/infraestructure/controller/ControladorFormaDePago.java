package lyjstoreapirest.demo.formaDePago.infraestructure.controller;

import com.fasterxml.jackson.annotation.OptBoolean;
import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.formaDePago.domain.model.FormaDePago;
import lyjstoreapirest.demo.formaDePago.domain.service.FormaDePagoServicio;
import lyjstoreapirest.demo.tiposDeCuenta.domain.model.TipoDeCuenta;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/listar")
    public ResponseEntity<List<FormaDePago>> listarFormasDePago(){
        return new ResponseEntity<>(formaDePagoServicio.listarFormasDePago(),HttpStatus.OK);
    }

    @GetMapping("{idFormaDePago}")
    public ResponseEntity<FormaDePago> buscarFormaDePagoPorId(@PathVariable("idFormaDePago") Long idFormaDePago){
        Optional<FormaDePago> formaDePagoABuscar = formaDePagoServicio.buscarFormaDePagoPorId(idFormaDePago);
        if (formaDePagoABuscar.isEmpty()){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/api/v1/formadepagos/"+idFormaDePago);
            return  new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(formaDePagoABuscar.get(),HttpStatus.OK);
        }
    }

    @DeleteMapping("/{idFormaDePago}")
    public  ResponseEntity<HttpStatus> eliminarFormaDePagoPorId(@PathVariable("idFormaDePago") Long id){
        Optional<FormaDePago> formaDePagoAEliminar = formaDePagoServicio.buscarFormaDePagoPorId(id);
        if(formaDePagoAEliminar.isEmpty())
        {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Location", "/api/v1/formadepago/"+id);
            return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
        }
        formaDePagoServicio.eliminarFormaDePagoPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
