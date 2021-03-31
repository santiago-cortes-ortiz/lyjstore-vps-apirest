package lyjstoreapirest.demo.banco.infrastucture.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.banco.domain.model.Banco;
import lyjstoreapirest.demo.banco.domain.service.BancoServicio;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("/all")
    public ResponseEntity<List<Banco>> listarBancos(){
        return new ResponseEntity<>(bancoServicio.listarBancos(),HttpStatus.OK);
    }

    @GetMapping("/{idBanco}")
    public ResponseEntity<Banco> buscarPorId(@PathVariable("idBanco") Long idBanco){
        Optional<Banco> bancos = bancoServicio.buscarBancoPorId(idBanco);
        if (bancos.isEmpty()){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/api/v1/banco/"+idBanco);
            return new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(bancos.get(),HttpStatus.OK);
        }
    }

    @DeleteMapping("/{idBanco}")
    public  ResponseEntity<HttpStatus> eliminarBancoPorId(@PathVariable("idBanco") Long id){
        Optional<Banco> bancoToDelete = bancoServicio.buscarBancoPorId(id);

        if(bancoToDelete.isEmpty())
        {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Location", "/api/v1/banco/"+id);
            return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
        }

        bancoServicio.eliminarBancoPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
