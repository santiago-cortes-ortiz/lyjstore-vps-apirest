package lyjstoreapirest.demo.banco.infrastucture.repository;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.banco.domain.dto.BancoDTO;
import lyjstoreapirest.demo.banco.infrastucture.entity.Banco;
import lyjstoreapirest.demo.banco.infrastucture.mapper.BancoMapper;
import lyjstoreapirest.demo.banco.domain.repository.RespositorioBanco;
import lyjstoreapirest.demo.general_service.Repositorio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repositorio
@AllArgsConstructor
public class RespositorioBancoImpl implements RespositorioBanco  {

    private JpaMetodosBanco jpaMetodosBanco;
    private BancoMapper bancoMapper;


    @Override
    public Long guardar(BancoDTO bancoDTO) {
        return jpaMetodosBanco.save(bancoMapper.bancoDtoToBanco(bancoDTO)).getId();
    }

    @Override
    public Optional<BancoDTO> buscarBancoPorId(Long idBanco){
        return Optional.ofNullable(bancoMapper.bancoToBancoDto(jpaMetodosBanco.findById(idBanco).get()));
    }

    @Override
    public boolean eliminarBancoPorId(Long idBanco) {
        try{
            jpaMetodosBanco.deleteById(idBanco);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<BancoDTO> listarBancos() {
        List<Banco> listaBancoNormales = jpaMetodosBanco.findAll();
        List<BancoDTO> listaBancoDto = listaBancoNormales.stream().map(listaDto -> BancoDTO.builder()
                .id(listaDto.getId())
                .nombre(listaDto.getNombre())
                .build())
                .collect(Collectors.toList());
        return listaBancoDto;
    }

    @Override
    public Long actualizarBanco(BancoDTO bancoDTO, Long id) {
        Banco bancoAGuardar = jpaMetodosBanco.findById(id).get();
        bancoAGuardar.setNombre(bancoDTO.getNombre());
        return jpaMetodosBanco.save(bancoAGuardar).getId();
    }
}
