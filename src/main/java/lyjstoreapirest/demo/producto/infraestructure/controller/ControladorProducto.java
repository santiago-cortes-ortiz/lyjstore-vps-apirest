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
import java.util.Optional;

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

    @GetMapping("{idProducto}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable("idProducto") Long idProducto){
        Optional<Producto> productoABuscar = productoServicio.buscarProductoPorId(idProducto);
        if (productoABuscar.isEmpty()){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/api/v1/producto/"+idProducto);
            return  new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(productoABuscar.get(),HttpStatus.OK);
        }
    }

    @DeleteMapping("/{idProducto}")
    public  ResponseEntity<HttpStatus> eliminarProductoPorId(@PathVariable("idProducto") Long id){
        Optional<Producto> productoAEliminar = productoServicio.buscarProductoPorId(id);
        if(productoAEliminar.isEmpty())
        {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Location", "/api/v1/producto/"+id);
            return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
        }
        productoServicio.eliminarProductoPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
