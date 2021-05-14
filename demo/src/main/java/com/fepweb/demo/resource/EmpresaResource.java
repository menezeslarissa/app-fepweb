package com.fepweb.demo.resource;

import com.fepweb.demo.service.EmpresaServiceInterface;
import com.fepweb.demo.service.dto.BasicResponse;
import com.fepweb.demo.service.dto.EmpresaDTO;
import com.fepweb.demo.service.dto.EmpresaOnlyNameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins = "*")
public class EmpresaResource {

    @Autowired
    private EmpresaServiceInterface empresaService;

    @PostMapping
    public ResponseEntity<EmpresaDTO> salvar(@RequestBody EmpresaDTO empresaDTO) {
        return ResponseEntity.ok(empresaService.salvar(empresaDTO));
    }

    @GetMapping
    public ResponseEntity<List<EmpresaDTO>> listarTodas() {
        return ResponseEntity.ok(empresaService.listarTodas());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@RequestBody EmpresaOnlyNameDTO onlyNameDTO, @PathVariable("id") Long id) {
        if(id == null) {
            return ResponseEntity.badRequest().body(new BasicResponse("id", "id não pode ser nulo"));
        } else {
            if(empresaService.getOne(id) == null) {
                return ResponseEntity.badRequest().body(new BasicResponse("id", "id não encontrado"));
            } else {
                return ResponseEntity.ok(empresaService.atualizar(onlyNameDTO, id));
            }
        }
    }


}
