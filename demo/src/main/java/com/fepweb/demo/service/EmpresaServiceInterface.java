package com.fepweb.demo.service;

import com.fepweb.demo.model.Empresa;
import com.fepweb.demo.service.dto.EmpresaDTO;
import com.fepweb.demo.service.dto.EmpresaOnlyNameDTO;

import java.util.List;

public interface EmpresaServiceInterface {

    EmpresaDTO salvar(EmpresaDTO empresaDTO);

    List<EmpresaDTO> listarTodas();

    EmpresaDTO atualizar(EmpresaOnlyNameDTO onlyNameDTO, Long id);

    EmpresaDTO getOne(Long id);
}
