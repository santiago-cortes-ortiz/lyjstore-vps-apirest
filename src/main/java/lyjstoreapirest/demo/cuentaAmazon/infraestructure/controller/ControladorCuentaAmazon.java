package lyjstoreapirest.demo.cuentaAmazon.infraestructure.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.cuentaAmazon.domain.model.CuentaAmazon;
import lyjstoreapirest.demo.cuentaAmazon.application.CuentaAmazonServicio;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/listar")
    public ResponseEntity<List<CuentaAmazon>> listarCuentasAmazon(){
        return new ResponseEntity<>(cuentaAmazonServicio.listarCuentasAmazon(),HttpStatus.OK);
    }

    @GetMapping("{idCuentaAmazon}")
    public ResponseEntity<CuentaAmazon> buscarCuentaAmazonPorId(@PathVariable("idCuentaAmazon") Long idCuentaAmazon){
        Optional<CuentaAmazon> cuentaAmazonABuscar = cuentaAmazonServicio.buscarCuentaAmazonPorId(idCuentaAmazon);
        if (cuentaAmazonABuscar.isEmpty()){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/api/v1/amazoncuenta/"+idCuentaAmazon);
            return  new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(cuentaAmazonABuscar.get(),HttpStatus.OK);
        }
    }

    @DeleteMapping("/{idCuentaAmazon}")
    public  ResponseEntity<HttpStatus> eliminarCuentaAmazonPorId(@PathVariable("idCuentaAmazon") Long id){
        Optional<CuentaAmazon> cuentaAmazonAEliminar = cuentaAmazonServicio.buscarCuentaAmazonPorId(id);
        if(cuentaAmazonAEliminar.isEmpty())
        {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Location", "/api/v1/amazoncuenta/"+id);
            return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
        }
        cuentaAmazonServicio.eliminarCuentaAmazonPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
