package lyjstoreapirest.demo.banco.infrastucture.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.banco.domain.model.Banco;
import lyjstoreapirest.demo.banco.domain.service.BancoServicio;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/banco")
@AllArgsConstructor
public class ControladorBanco{

    private BancoServicio bancoServicio;

    @PostMapping
    public ResponseEntity<HttpHeaders> guardarBanco(@RequestBody Banco banco){
        Long idBanco = bancoServicio.guardar(banco);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/banco/"+idBanco);
        return  new  ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/{idBanco}")
    public ResponseEntity<Banco> findById(@PathVariable("idBanco") Long idBanco){
        Optional<Banco> student = bancoServicio.buscarBancoPorId(idBanco);
        if (student.isEmpty()){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/api/v1/banco/"+idBanco);
            return new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(student.get(),HttpStatus.OK);
        }
    }


}
