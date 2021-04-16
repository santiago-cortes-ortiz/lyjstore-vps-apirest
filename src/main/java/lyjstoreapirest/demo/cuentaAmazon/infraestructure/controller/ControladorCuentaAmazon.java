package lyjstoreapirest.demo.cuentaAmazon.infraestructure.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.cuentaAmazon.domain.dto.CuentaAmazonDTO;
import lyjstoreapirest.demo.cuentaAmazon.infraestructure.entity.CuentaAmazon;
import lyjstoreapirest.demo.cuentaAmazon.domain.service.CuentaAmazonServicio;
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
    public ResponseEntity<HttpHeaders> adicionarCuentaAmazon(@RequestBody CuentaAmazonDTO cuentaAmazon){
        Long idCuentaAmazon = cuentaAmazonServicio.guardar(cuentaAmazon);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/amazoncuenta/"+idCuentaAmazon);
        return  new  ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CuentaAmazonDTO>> listarCuentasAmazon(){
        return new ResponseEntity<>(cuentaAmazonServicio.listarCuentasAmazon(),HttpStatus.OK);
    }

    @GetMapping("{idCuentaAmazon}")
    public ResponseEntity<CuentaAmazonDTO> buscarCuentaAmazonPorId(@PathVariable("idCuentaAmazon") Long idCuentaAmazon){
        try {
            CuentaAmazonDTO cuentaAmazonABuscar = cuentaAmazonServicio.buscarCuentaAmazonPorId(idCuentaAmazon);
            return new ResponseEntity<>(cuentaAmazonABuscar,HttpStatus.OK);
        }
        catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/api/v1/amazoncuenta/"+idCuentaAmazon);
            return  new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{idCuentaAmazon}")
    public  ResponseEntity<HttpStatus> eliminarCuentaAmazonPorId(@PathVariable("idCuentaAmazon") Long id){

        try {
            cuentaAmazonServicio.eliminarCuentaAmazonPorId(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Location", "/api/v1/amazoncuenta/"+id);
            return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
        }

    }

}
