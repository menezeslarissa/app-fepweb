package com.fepweb.demo.service;

import com.fepweb.demo.model.Empresa;
import com.fepweb.demo.repository.EmpresaRepository;
import com.fepweb.demo.service.dto.EmpresaDTO;
import com.fepweb.demo.service.dto.EmpresaOnlyNameDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    @Override
    public List<EmpresaDTO> listarTodas() {
        return empresaRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public EmpresaDTO atualizar(EmpresaOnlyNameDTO onlyNameDTO, Long id) {
        Optional<Empresa> result = empresaRepository.findById(id);
        Empresa empresa = null;
        result.get().setNome(onlyNameDTO.getNome());
        empresa = empresaRepository.save(result.get());

        return convertToDto(empresa);
    }

    @Override
    public EmpresaDTO getOne(Long id) {
        return convertToDto(empresaRepository.getOne(id));
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
