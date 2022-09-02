package com.example.StructureSFYN.services;

import com.example.StructureSFYN.entities.Empresa;
import com.example.StructureSFYN.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    public Empresa crearEmpresa(Empresa nuevaEmpresa){
        return this.repository.save(nuevaEmpresa);
    }

    public Empresa editarEmpresa(Empresa empresa, Long id){
        Empresa empresaBD = repository.findById(id).get();

        if (Objects.nonNull(
                empresa.getNombreEmpresa())
                && !"".equalsIgnoreCase(
                empresa.getNombreEmpresa())) {
            empresaBD.setNombreEmpresa(
                    empresa.getNombreEmpresa());
        }

        if (Objects.nonNull(empresa.getNitEmpresa())
                && !"".equalsIgnoreCase(
                empresa.getNitEmpresa().toString())) {
            empresaBD.setNitEmpresa(
                    empresa.getNitEmpresa());
        }

        if (Objects.nonNull(empresa.getCiudadEmpresa())
                && !"".equalsIgnoreCase(
                empresa.getCiudadEmpresa())) {
            empresaBD.setCiudadEmpresa(
                    empresa.getCiudadEmpresa());
        }

        if (Objects.nonNull(empresa.getDireccionEmpresa())
                && !"".equalsIgnoreCase(
                empresa.getDireccionEmpresa())) {
            empresaBD.setDireccionEmpresa(
                    empresa.getDireccionEmpresa());
        }

        if (Objects.nonNull(empresa.getTelefonoEmpresa())
                && !"".equalsIgnoreCase(
                empresa.getTelefonoEmpresa())) {
            empresaBD.setTelefonoEmpresa(
                    empresa.getTelefonoEmpresa());
        }

        if (Objects.nonNull(empresa.getTipoEmpresa())
                && !"".equalsIgnoreCase(
                empresa.getTipoEmpresa())) {
            empresaBD.setTipoEmpresa(
                    empresa.getTipoEmpresa());
        }

        if (Objects.nonNull(empresa.getCorreoEmpresa())
                && !"".equalsIgnoreCase(
                empresa.getCorreoEmpresa())) {
            empresaBD.setCorreoEmpresa(
                    empresa.getCorreoEmpresa());
        }


        return repository.save(empresaBD);
    }


    public void eliminarEmpresa(Long id){
        this.repository.deleteById(id);
    }
}
