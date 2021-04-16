package lyjstoreapirest.demo.pedidoProducto.infraestructure.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.pedidoProducto.domain.PedidoProducto;
import lyjstoreapirest.demo.pedidoProducto.domain.service.PedidoProductoCrud;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/productopedido")
@AllArgsConstructor
public class ControladorPedidoProducto {

    private PedidoProductoCrud pedidoProductoCrud;

    @PostMapping
    public ResponseEntity<HttpHeaders> adicionarPedidoProducto(@RequestBody PedidoProducto pedidoProducto){
        /*Long idPedidoProducto = courierCrud.guardar(courier);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/courier/"+idCourier);
        return  new  ResponseEntity<>(headers, HttpStatus.CREATED);*/
        return null;
    }
}
