package com.fepweb.demo.repository;

import com.fepweb.demo.model.Empresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {
}
