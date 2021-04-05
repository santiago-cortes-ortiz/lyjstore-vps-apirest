package lyjstoreapirest.demo.cuentaAzure.infraestructure.controller;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.cuentaAzure.domain.service.CuentaAzureServicio;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/azurecuenta")
@AllArgsConstructor
public class ControladorCuentaAzure {
    private CuentaAzureServicio cuentaAzureServicio;
}
