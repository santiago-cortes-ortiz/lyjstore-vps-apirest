package lyjstoreapirest.demo.producto.infraestructure.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.producto.domain.model.Producto;
import lyjstoreapirest.demo.producto.domain.service.ProductoServicio;
import lyjstoreapirest.demo.rol.domain.model.Rol;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/producto")
@AllArgsConstructor
public class ControladorProducto {

    private ProductoServicio productoServicio;

    @PostMapping
    public ResponseEntity<HttpHeaders> adicionarProducto(@RequestBody Producto producto){
        Long idRol = productoServicio.guardar(producto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/producto/"+idRol);
        return  new  ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listarProductos(){
        return new ResponseEntity<>(productoServicio.listarProductos(),HttpStatus.OK);
    }

}
