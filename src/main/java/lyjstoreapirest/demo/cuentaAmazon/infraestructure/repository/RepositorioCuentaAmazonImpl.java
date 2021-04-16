package lyjstoreapirest.demo.cuentaAmazon.infraestructure.repository;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.courier.domain.dto.CourierDTO;
import lyjstoreapirest.demo.courier.infraestructure.entity.Courier;
import lyjstoreapirest.demo.cuentaAmazon.domain.dto.CuentaAmazonDTO;
import lyjstoreapirest.demo.cuentaAmazon.infraestructure.entity.CuentaAmazon;
import lyjstoreapirest.demo.cuentaAmazon.domain.repository.RepositorioCuentaAmazon;
import lyjstoreapirest.demo.cuentaAmazon.infraestructure.mapper.CuentaAmazonMapper;
import lyjstoreapirest.demo.general_service.Repositorio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repositorio
@AllArgsConstructor


public class RepositorioCuentaAmazonImpl implements RepositorioCuentaAmazon {

    private final JpaMetodosCuentaAmazon jpaMetodosCuentaAmazon;
    private final CuentaAmazonMapper cuentaAmazonMapper;

    @Override
    public Long guardar(CuentaAmazonDTO cuentaAmazon) {
        return jpaMetodosCuentaAmazon.save(cuentaAmazonMapper.cuentaAmazonDtoToCuentaAmazon(cuentaAmazon)).getIdCuentaAmazon();
    }

    @Override
    public CuentaAmazonDTO buscarCuentaAmazonPorId(Long idCuentaAmazon) {
        return cuentaAmazonMapper.cuentaAmazonToCuentaAmazonDto(jpaMetodosCuentaAmazon.findById(idCuentaAmazon).get());
    }

    @Override
    public Optional<CuentaAmazonDTO> eliminarCuentaAmazonPorId(Long idCuentaAmazon) {
        jpaMetodosCuentaAmazon.deleteById(idCuentaAmazon);
        return Optional.empty();

    }

    @Override
    public List<CuentaAmazonDTO> listarCuentasAmazon() {
        List<CuentaAmazon> listaCuentasAmazonNormales = jpaMetodosCuentaAmazon.findAll();
        List<CuentaAmazonDTO> listaCuentasAmazonDto = listaCuentasAmazonNormales.stream().map(listaDto -> CuentaAmazonDTO.builder()
                .idCuentaAmazon(listaDto.getIdCuentaAmazon())
                .nombre(listaDto.getNombre())
                .correo(listaDto.getCorreo())
                .direccion(listaDto.getDireccion())
                .direccion2(listaDto.getDireccion2())
                .codigoPostal(listaDto.getCodigoPostal())
                .telefono(listaDto.getTelefono())
                .ciudad(listaDto.getCiudad())
                .estado(listaDto.getEstado())
                .build())
                .collect(Collectors.toList());
        return listaCuentasAmazonDto;
    }
}
