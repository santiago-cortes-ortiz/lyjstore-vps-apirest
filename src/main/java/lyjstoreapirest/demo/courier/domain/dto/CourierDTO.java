package lyjstoreapirest.demo.courier.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CourierDTO {
    private Long id;
    private String nombre;
}
