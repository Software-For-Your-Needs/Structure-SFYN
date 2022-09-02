package com.example.StructureSFYN.repositories;

import com.example.StructureSFYN.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository <Empleado, Long>{

}
