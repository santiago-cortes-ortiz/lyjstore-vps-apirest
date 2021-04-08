package lyjstoreapirest.demo.empleado.infraestructure.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.empleado.domain.model.Empleado;
import lyjstoreapirest.demo.empleado.domain.service.EmpleadoServicio;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/empleado")
@AllArgsConstructor
public class ControladorEmpleado {

    private EmpleadoServicio empleadoServicio;

    //USAR TRY CATCH

    @PostMapping
    public ResponseEntity<HttpHeaders> adicionarMetodoDePago(@RequestBody Empleado empleado){
        Long idEmpleado = empleadoServicio.guardar(empleado);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/empleado/"+idEmpleado);
        return  new  ResponseEntity<>(headers, HttpStatus.CREATED);
        /*{
            "estatus":"201",
            "Ok":"true"
        }
        {
            "estatus":"BADREQUEST",
            "Ok":"false"
        }*/
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Empleado>> listarEmpleados(){
        return new ResponseEntity<>(empleadoServicio.listarEmpleado(),HttpStatus.OK);
    }

    @GetMapping("/{idEmpleado}")
    public ResponseEntity<Empleado> buscarEmpleadoPorId(@PathVariable("idEmpleado") Long id ){
        Optional<Empleado> empleadoABuscar = empleadoServicio.buscarEmpleadoPorId(id);
        if (empleadoABuscar.isEmpty()){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/api/v1/empleado/"+id);
            return  new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(empleadoABuscar.get(),HttpStatus.OK);
        }
    }

}
