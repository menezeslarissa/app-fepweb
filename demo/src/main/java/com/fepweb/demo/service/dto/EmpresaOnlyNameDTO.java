package com.fepweb.demo.service.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class EmpresaOnlyNameDTO {

    @NotEmpty(message = "{validation.nome.NotEmpty}")
    private String nome;

}
