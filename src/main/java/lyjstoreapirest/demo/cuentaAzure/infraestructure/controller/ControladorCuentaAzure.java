package lyjstoreapirest.demo.cuentaAzure.infraestructure.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.cuentaAzure.application.CuentaAzureServicio;
import lyjstoreapirest.demo.cuentaAzure.domain.model.CuentaAzure;
import lyjstoreapirest.demo.producto.domain.model.Producto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/azurecuenta")
@AllArgsConstructor
public class ControladorCuentaAzure {

    private CuentaAzureServicio cuentaAzureServicio;

    @PostMapping
    public ResponseEntity<HttpHeaders> adicionarCuentaAzure(@RequestBody CuentaAzure cuentaAzure){
        Long idCuentaAzure = cuentaAzureServicio.guardar(cuentaAzure);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/azurecuenta/"+idCuentaAzure);
        return  new  ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CuentaAzure>> listarCuentasAzure(){
        return new ResponseEntity<>(cuentaAzureServicio.listarCuentasAzure(),HttpStatus.OK);
    }

    @GetMapping("{idCuentaAzure}")
    public ResponseEntity<CuentaAzure> buscarProductoPorId(@PathVariable("idCuentaAzure") Long idCuentaAzure){
        Optional<CuentaAzure> cuentaAzureABuscar = cuentaAzureServicio.buscarCuentaAzurePorId(idCuentaAzure);
        if (cuentaAzureABuscar.isEmpty()){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/api/v1/azurecuenta/"+idCuentaAzure);
            return  new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(cuentaAzureABuscar.get(),HttpStatus.OK);
        }
    }

    @DeleteMapping("/{idCuentaAzure}")
    public  ResponseEntity<HttpStatus> eliminarCuentaAzurePorId(@PathVariable("idCuentaAzure") Long id){
        Optional<CuentaAzure> productoAEliminar = cuentaAzureServicio.buscarCuentaAzurePorId(id);
        if(productoAEliminar.isEmpty())
        {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Location", "/api/v1/azurecuenta/"+id);
            return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
        }
        cuentaAzureServicio.eliminarCuentaAzurePorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
