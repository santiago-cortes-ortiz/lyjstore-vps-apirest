package lyjstoreapirest.demo.pedido.infraestructure.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.pedido.domain.service.PedidoServicio;
import lyjstoreapirest.demo.pedido.domain.model.Pedido;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pedido")
@AllArgsConstructor
public class ControladorPedido {

    private PedidoServicio pedidoServicio;

    @PostMapping
    public ResponseEntity<HttpHeaders> adicionarPedido(@RequestBody Pedido pedido){
        Long idPedido = pedidoServicio.guardar(pedido);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/pedido/"+idPedido);
        return  new  ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Pedido>> listarPedidos(){
        return new ResponseEntity<>(pedidoServicio.listarPedidos(),HttpStatus.OK);
    }

    @GetMapping("{idPedido}")
    public ResponseEntity<Pedido> buscarPedidoPorId(@PathVariable("idPedido") Long idPedido){
        Optional<Pedido> pedidoABuscar = pedidoServicio.buscarPedidoPorId(idPedido);
        if (pedidoABuscar.isEmpty()){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/api/v1/pedido/"+idPedido);
            return  new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(pedidoABuscar.get(),HttpStatus.OK);
        }
    }

    @DeleteMapping("/{idPedido}")
    public  ResponseEntity<HttpStatus> eliminarPedidoPorId(@PathVariable("idPedido") Long id){
        Optional<Pedido> pedidoAEliminar = pedidoServicio.buscarPedidoPorId(id);
        if(pedidoAEliminar.isEmpty())
        {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Location", "/api/v1/pedido/"+id);
            return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
        }
        pedidoServicio.eliminarPedidoPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
