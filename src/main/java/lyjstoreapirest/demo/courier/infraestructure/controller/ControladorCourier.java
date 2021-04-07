package lyjstoreapirest.demo.courier.infraestructure.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.courier.domain.model.Courier;
import lyjstoreapirest.demo.courier.application.CourierServicio;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/courier")
@AllArgsConstructor
public class ControladorCourier {

    private CourierServicio courierServicio;

    @PostMapping
    public ResponseEntity<HttpHeaders> adicionarCourier(@RequestBody Courier courier){
        Long idCourier = courierServicio.guardar(courier);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/courier/"+idCourier);
        return  new  ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Courier>> listarCouriers(){
        return new ResponseEntity<>(courierServicio.listarCouriers(),HttpStatus.OK);
    }

    @GetMapping("/{idCourier}")
    public ResponseEntity<Courier> buscarCourierPorId(@PathVariable("idCourier") Long idCourier){
        Optional<Courier> courier = courierServicio.buscarCourierPorId(idCourier);
        if (courier.isEmpty()){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/api/v1/courier/"+idCourier);
            return new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(courier.get(),HttpStatus.OK);
        }
    }
    @PutMapping("/actualizar/{idCourier}")
    public ResponseEntity<Optional<Courier>> actualizarNombre(@RequestBody Courier nuevoCourier, @PathVariable("idCourier") Long idCourier){
        Optional<Courier> courierABuscar = courierServicio.buscarCourierPorId(idCourier);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/courier/"+idCourier);
        if (courierABuscar.isEmpty()){
            courierServicio.guardar(nuevoCourier);
            return new ResponseEntity<>(headers,HttpStatus.CREATED);
        }
        else{
            courierABuscar.get().setNombre(nuevoCourier.getNombre());
            courierServicio.guardar(courierABuscar.get());
            return new ResponseEntity<>(headers,HttpStatus.OK);
        }
    }

    @DeleteMapping("/{idCourier}")
    public  ResponseEntity<HttpStatus> eliminarCourierPorId(@PathVariable("idCourier") Long id){
        Optional<Courier> courierParaEliminar = courierServicio.buscarCourierPorId(id);
        if(courierParaEliminar.isEmpty())
        {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Location", "/api/v1/courier/"+id);
            return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
        }
        courierServicio.eliminarCourierPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
