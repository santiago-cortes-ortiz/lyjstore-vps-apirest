package lyjstoreapirest.demo.tiposDeCuenta.infraestructure.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.tiposDeCuenta.domain.model.TipoDeCuenta;
import lyjstoreapirest.demo.tiposDeCuenta.application.TiposDeCuentaServicio;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tipodecuenta")
@AllArgsConstructor
public class ControladorTiposDeCuenta {

    private TiposDeCuentaServicio tiposDeCuentaServicio;

    @PostMapping
    public ResponseEntity<HttpHeaders> adicionarTipoDeCuenta(@RequestBody TipoDeCuenta tipoDeCuenta){
        Long idTipoDeCuenta = tiposDeCuentaServicio.guardar(tipoDeCuenta);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/tipodecuenta/"+idTipoDeCuenta);
        return  new  ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TipoDeCuenta>> listarTiposDeCuenta(){
        return new ResponseEntity<>(tiposDeCuentaServicio.listarTiposDeCuenta(),HttpStatus.OK);
    }

    @GetMapping("/{idTipoDeCuenta}")
    public ResponseEntity<TipoDeCuenta> buscarTipoDeCuentaPorId(@PathVariable("idTipoDeCuenta") Long idTipoDeCuenta){
        Optional<TipoDeCuenta> tipoDeCuenta = tiposDeCuentaServicio.buscarTiposDeCuentaPorId(idTipoDeCuenta);
        if (tipoDeCuenta.isEmpty()){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/api/v1/tipodecuenta/"+idTipoDeCuenta);
            return new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(tipoDeCuenta.get(),HttpStatus.OK);
        }
    }

    @PutMapping("/actualizar/{idTipoDeCuenta}")
    public ResponseEntity<Optional<TipoDeCuenta>> actualizarTipo(@RequestBody TipoDeCuenta nuevoTipo, @PathVariable("idTipoDeCuenta") Long idTipoDeCuenta){
        Optional<TipoDeCuenta> tipoABuscar = tiposDeCuentaServicio.buscarTiposDeCuentaPorId(idTipoDeCuenta);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/tipodecuenta/"+idTipoDeCuenta);
        if (tipoABuscar.isEmpty()){
            tiposDeCuentaServicio.guardar(nuevoTipo);
            return new ResponseEntity<>(headers,HttpStatus.CREATED);
        }
        else{
            tipoABuscar.get().setTipo(nuevoTipo.getTipo());
            tiposDeCuentaServicio.guardar(tipoABuscar.get());
            return new ResponseEntity<>(headers,HttpStatus.OK);
        }
    }

    @DeleteMapping("/{idTipoDeCuenta}")
    public  ResponseEntity<HttpStatus> eliminarTipoDeCuentaPorId(@PathVariable("idTipoDeCuenta") Long id){
        Optional<TipoDeCuenta> tipoDeCuentaAEliminar = tiposDeCuentaServicio.buscarTiposDeCuentaPorId(id);
        if(tipoDeCuentaAEliminar.isEmpty())
        {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Location", "/api/v1/tipodecuenta/"+id);
            return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
        }
        tiposDeCuentaServicio.eliminarTiposDeCuentaPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
