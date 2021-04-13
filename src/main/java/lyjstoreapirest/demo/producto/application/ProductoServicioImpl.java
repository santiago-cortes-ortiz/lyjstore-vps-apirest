package lyjstoreapirest.demo.producto.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.producto.domain.service.ProductoServicio;
import lyjstoreapirest.demo.producto.domain.model.Producto;
import lyjstoreapirest.demo.producto.domain.repository.RespositorioProducto;
import lyjstoreapirest.demo.general_service.Servicio;

import java.util.List;
import java.util.Optional;

@Servicio
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {

    private RespositorioProducto respositorioProducto;

    @Override
    public Long guardar(Producto producto) {
        return respositorioProducto.guardar(producto);

    }

    @Override
    public Optional<Producto> buscarProductoPorId(Long idProducto) {
        return respositorioProducto.buscarProductoPorId(idProducto);
    }

    @Override
    public Optional<Producto> eliminarProductoPorId(Long idProducto) {
        respositorioProducto.eliminarProductoPorId(idProducto);
        return Optional.empty();
    }

    @Override
    public List<Producto> listarProductos() {
        return respositorioProducto.listarProductos();
    }
}
