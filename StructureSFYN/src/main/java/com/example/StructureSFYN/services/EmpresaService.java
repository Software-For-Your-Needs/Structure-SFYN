package com.example.StructureSFYN.services;

import com.example.StructureSFYN.entities.Empresa;
import com.example.StructureSFYN.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    private EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository){
        this.repository = repository;
    }
    public List<Empresa> getListaEmpresa(){

        return this.repository.findAll();
    }

    public Optional<Empresa> getEmpresa(Long id) {
        return this.repository.findById(id);
    }



}
