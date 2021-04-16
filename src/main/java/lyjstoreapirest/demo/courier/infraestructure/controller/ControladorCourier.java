package lyjstoreapirest.demo.courier.infraestructure.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.courier.domain.dto.CourierDTO;
import lyjstoreapirest.demo.courier.domain.service.CourierCrud;
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

    private CourierCrud courierCrud;

    @PostMapping
    public ResponseEntity<HttpHeaders> adicionarCourier(@RequestBody CourierDTO courier){
        Long idCourier = courierCrud.guardar(courier);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/courier/"+idCourier);
        return  new  ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CourierDTO>> listarCouriers(){
        return new ResponseEntity<>(courierCrud.listarCouriers(),HttpStatus.OK);
    }

    @GetMapping("/{idCourier}")
    public ResponseEntity<CourierDTO> buscarCourierPorId(@PathVariable("idCourier") Long idCourier){

        try {
            CourierDTO courier = courierCrud.buscarCourierPorId(idCourier);
            return new ResponseEntity<>(courier,HttpStatus.OK);
        }catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/api/v1/courier/"+idCourier);
            return new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping("/actualizar/{idCourier}")
    public ResponseEntity<HttpStatus> actualizarNombre(@RequestBody CourierDTO nuevoCourier, @PathVariable("idCourier") Long idCourier){
        try{
            courierCrud.actualizarCourier(nuevoCourier,idCourier);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{idCourier}")
    public  ResponseEntity<HttpStatus> eliminarCourierPorId(@PathVariable("idCourier") Long id){
        try {
            courierCrud.eliminarCourierPorId(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/api/v1/courier/"+id);
            return new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
        }

    }


}
