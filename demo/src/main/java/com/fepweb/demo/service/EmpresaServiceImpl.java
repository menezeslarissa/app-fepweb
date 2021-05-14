package com.fepweb.demo.service;

import com.fepweb.demo.model.Empresa;
import com.fepweb.demo.repository.EmpresaRepository;
import com.fepweb.demo.service.dto.EmpresaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImpl implements EmpresaServiceInterface{

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmpresaDTO salvar(EmpresaDTO empresaDTO) {
        return convertToDto(empresaRepository.save(convertToEntity(empresaDTO)));
    }


    private EmpresaDTO convertToDto(Empresa empresa) {
        EmpresaDTO empresaDTO = modelMapper.map(empresa, EmpresaDTO.class);
        return empresaDTO;
    }

    private Empresa convertToEntity(EmpresaDTO empresaDTO) {
        Empresa empresa = modelMapper.map(empresaDTO, Empresa.class);

        if (empresa.getId() != null) {
            Empresa oldEmpresa = empresaRepository.findById(empresaDTO.getId()).get();
            empresa.setNome(oldEmpresa.getNome());
            empresa.setCnpj(oldEmpresa.getCnpj());
            empresa.setCreatedAt(oldEmpresa.getCreatedAt());
        }
        return empresa;
    }
}
