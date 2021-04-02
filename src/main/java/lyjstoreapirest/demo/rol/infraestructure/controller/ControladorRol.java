package lyjstoreapirest.demo.rol.infraestructure.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.rol.domain.model.Rol;
import lyjstoreapirest.demo.rol.domain.service.RolServicio;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/rol")
@AllArgsConstructor
public class ControladorRol {

    private RolServicio rolServicio;

    @PostMapping
    public ResponseEntity<HttpHeaders> adicionarRol(@RequestBody Rol rol){
        Long idRol = rolServicio.guardar(rol);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/rol/"+idRol);
        return  new  ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Rol>> listarRoles(){
        return new ResponseEntity<>(rolServicio.listarRoles(),HttpStatus.OK);
    }

    @GetMapping("{idRol}")
    public ResponseEntity<Rol> buscarRolPorId(@PathVariable("idRol") Long idRol){
        Optional<Rol> rolABuscar = rolServicio.buscarRolPorId(idRol);
        if (rolABuscar.isEmpty()){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/api/v1/rol/"+idRol);
            return  new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(rolABuscar.get(),HttpStatus.OK);
        }
    }

    @PutMapping("/actualizar/{idRol}")
    public ResponseEntity<Optional<Rol>> actualizarRol(@RequestBody Rol nuevoRol, @PathVariable("idRol") Long idRol){
        Optional<Rol> rolABuscar = rolServicio.buscarRolPorId(idRol);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/rol/"+idRol);
        if (rolABuscar.isEmpty()){
            rolServicio.guardar(nuevoRol);
            return new ResponseEntity<>(headers,HttpStatus.CREATED);
        }
        else{
            rolABuscar.get().setRol(nuevoRol.getRol());
            rolServicio.guardar(rolABuscar.get());
            return new ResponseEntity<>(headers,HttpStatus.OK);
        }
    }

    @DeleteMapping("/{idRol}")
    public  ResponseEntity<HttpStatus> eliminarFormaDePagoPorId(@PathVariable("idRol") Long id){
        Optional<Rol> formaRolAEliminar = rolServicio.buscarRolPorId(id);
        if(formaRolAEliminar.isEmpty())
        {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Location", "/api/v1/rol/"+id);
            return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
        }
        rolServicio.eliminarRolPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
