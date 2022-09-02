package com.example.StructureSFYN.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
@Repository
public interface EmpresaRepository extends JpaRepository <Empresa, Long> {

}
