package lyjstoreapirest.demo.banco.infrastucture.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.banco.domain.dto.BancoDTO;
import lyjstoreapirest.demo.banco.domain.service.BancoController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/banco")
@AllArgsConstructor
public class ControladorBanco{

    private final BancoController bancoController;

    /*@PostMapping
    public ResponseEntity<HttpHeaders> adicionarBanco(@RequestBody BancoDTO banco){
        Long idBanco = bancoCrud.guardar(banco);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/banco/"+idBanco);
        return  new  ResponseEntity<>(headers, HttpStatus.CREATED);
    }*/

    @GetMapping("/listar")
    public ResponseEntity<List<BancoDTO>> listarBancos(){
        return new ResponseEntity<>(bancoController.listarBancos(),HttpStatus.OK);
    }

    @GetMapping("/{idBanco}")
    public ResponseEntity<BancoDTO> buscarPorId(@PathVariable("idBanco") Long idBanco){
        Optional<BancoDTO> bancoABuscar =bancoController.buscarBancoPorId(idBanco);
        if (bancoABuscar.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bancoABuscar.get(),HttpStatus.OK);
    }

    @PutMapping("/{idBanco}")
    public ResponseEntity<HttpStatus> guardarBanco(@RequestBody BancoDTO nuevoBanco, @PathVariable("idBanco") Long idBanco){
        Long idBancoCreado;
        HttpHeaders headers = new HttpHeaders();
        if (bancoController.buscarBancoPorId(idBanco).isEmpty()){
            idBancoCreado = bancoController.guardar(nuevoBanco);
            headers.add("Location","/api/v1/banco/"+idBancoCreado);
            return  new  ResponseEntity<>(headers, HttpStatus.CREATED);
        }else{
            idBancoCreado = bancoController.actualizarBanco(nuevoBanco,idBanco);
            headers.add("Location","/api/v1/banco/"+idBancoCreado);
            return  new ResponseEntity<>(headers,HttpStatus.ACCEPTED);
        }

    }


    @DeleteMapping("/{idBanco}")
    public  ResponseEntity<HttpStatus> eliminarBancoPorId(@PathVariable("idBanco") Long id){
        if (bancoController.eliminarBancoPorId(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Location", "/api/v1/banco/"+id);
            return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
        }
    }


}

