package lyjstoreapirest.demo.banco.infrastucture.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.banco.domain.dto.BancoDTO;
import lyjstoreapirest.demo.banco.infrastucture.entity.Banco;
import lyjstoreapirest.demo.banco.domain.service.BancoCrud;
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

    private BancoCrud bancoCrud;

    @PostMapping
    public ResponseEntity<HttpHeaders> adicionarBanco(@RequestBody BancoDTO banco){
        Long idBanco = bancoCrud.guardar(banco);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/banco/"+idBanco);
        return  new  ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<BancoDTO>> listarBancos(){
        return new ResponseEntity<>(bancoCrud.listarBancos(),HttpStatus.OK);
    }

    @GetMapping("/{idBanco}")
    public ResponseEntity<BancoDTO> buscarPorId(@PathVariable("idBanco") Long idBanco){

        try {
            BancoDTO bancos = bancoCrud.buscarBancoPorId(idBanco);
            return new ResponseEntity<>(bancos,HttpStatus.OK);

        } catch (Exception e) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/api/v1/banco/"+idBanco);
            return new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{idBanco}")
    public ResponseEntity<HttpStatus> actualizarBanco(@RequestBody BancoDTO nuevoBanco, @PathVariable("idBanco") Long idBanco){
        try{
             bancoCrud.actualizarBanco(nuevoBanco,idBanco);
             return  new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        catch(Exception e){
            Long idBancoCreado = bancoCrud.guardar(nuevoBanco);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/api/v1/banco/"+idBancoCreado);
            return  new  ResponseEntity<>(headers, HttpStatus.CREATED);
        }
    }


    @DeleteMapping("/{idBanco}")
    public  ResponseEntity<HttpStatus> eliminarBancoPorId(@PathVariable("idBanco") Long id){
        try {
            bancoCrud.eliminarBancoPorId(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Location", "/api/v1/banco/"+id);
            return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
        }
    }


}

