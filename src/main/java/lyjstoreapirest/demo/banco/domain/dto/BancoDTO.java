package lyjstoreapirest.demo.banco.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class BancoDTO {

    private Long id;
    private String nombre;

}
