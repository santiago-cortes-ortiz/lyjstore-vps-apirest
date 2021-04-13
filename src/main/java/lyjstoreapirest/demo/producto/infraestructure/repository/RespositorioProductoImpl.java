package lyjstoreapirest.demo.producto.infraestructure.repository;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.general_service.Repositorio;
import lyjstoreapirest.demo.producto.domain.model.Producto;
import lyjstoreapirest.demo.producto.domain.repository.JpaMetodosProducto;
import lyjstoreapirest.demo.producto.domain.repository.RespositorioProducto;

import java.util.List;
import java.util.Optional;

@Repositorio
@AllArgsConstructor
public class RespositorioProductoImpl implements RespositorioProducto {


    private JpaMetodosProducto jpaMetodosProducto;
    @Override
    public Long guardar(Producto producto) {
        return jpaMetodosProducto.save(producto).getIdProducto();
    }

    @Override
    public Optional<Producto> buscarProductoPorId(Long idProducto) {
        return jpaMetodosProducto.findById(idProducto);
    }

    @Override
    public Optional<Producto> eliminarProductoPorId(Long idProducto) {

        jpaMetodosProducto.deleteById(idProducto);
        return Optional.empty();
    }

    @Override
    public List<Producto> listarProductos() {
        return jpaMetodosProducto.findAll();
    }
}
