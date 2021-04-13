package lyjstoreapirest.demo.banco.infrastucture.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.banco.domain.dto.BancoDTO;
import lyjstoreapirest.demo.banco.domain.model.Banco;
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
        Optional<BancoDTO> bancos = bancoCrud.buscarBancoPorId(idBanco);
        if (bancos.isEmpty()){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/api/v1/banco/"+idBanco);
            return new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(bancos.get(),HttpStatus.OK);
        }
    }

    @PutMapping("/actualizar/{idBanco}")
    public ResponseEntity<Optional<Banco>> actualizarNombre(@RequestBody Banco nuevoBanco, @PathVariable("idBanco") Long idBanco){
        /*Optional<Banco> bancoABuscar = bancoCrud.buscarBancoPorId(idBanco);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/banco/"+idBanco);
        if (bancoABuscar.isEmpty()){
            bancoCrud.guardar(nuevoBanco);
            return new ResponseEntity<>(headers,HttpStatus.CREATED);
        }
        else{
            bancoABuscar.get().setNombre(nuevoBanco.getNombre());
            bancoCrud.guardar(bancoABuscar.get());
            return new ResponseEntity<>(headers,HttpStatus.OK);
        }*/
        return null;
    }


    @DeleteMapping("/{idBanco}")
    public  ResponseEntity<HttpStatus> eliminarBancoPorId(@PathVariable("idBanco") Long id){
        Optional<BancoDTO> bancoToDelete = bancoCrud.buscarBancoPorId(id);
        if(bancoToDelete.isEmpty())
        {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Location", "/api/v1/banco/"+id);
            return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
        }
        bancoCrud.eliminarBancoPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

