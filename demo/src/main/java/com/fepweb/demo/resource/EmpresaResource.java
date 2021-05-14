package com.fepweb.demo.resource;

import com.fepweb.demo.service.EmpresaServiceInterface;
import com.fepweb.demo.service.dto.EmpresaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaResource {

    @Autowired
    private EmpresaServiceInterface empresaService;

    @PostMapping
    public ResponseEntity<EmpresaDTO> salvar(@RequestBody EmpresaDTO empresaDTO) {
        return ResponseEntity.ok(empresaService.salvar(empresaDTO));
    }
}
