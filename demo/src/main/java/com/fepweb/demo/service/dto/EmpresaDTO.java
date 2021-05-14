package com.fepweb.demo.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class EmpresaDTO {

    @JsonIgnore
    private Long id;

    @NotEmpty(message = "{validation.nome.NotEmpty}")
    private String nome;

    @NotEmpty(message = "{validation.cnpj.NotEmpty}")
    @Size(min = 14, max = 14, message = "{validation.cnpj.Size}")
    private String cnpj;

    @JsonIgnore
    private Date createdAt;

}
