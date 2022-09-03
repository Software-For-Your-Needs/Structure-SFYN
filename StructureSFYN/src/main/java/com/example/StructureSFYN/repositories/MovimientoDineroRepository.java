package com.example.StructureSFYN.repositories;

import com.example.StructureSFYN.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoDineroRepository extends JpaRepository <MovimientoDinero, Integer> {




}
