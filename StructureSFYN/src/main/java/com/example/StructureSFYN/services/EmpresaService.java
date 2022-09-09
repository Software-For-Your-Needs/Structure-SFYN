package com.example.StructureSFYN.services;

import com.example.StructureSFYN.entities.Empresa;
import com.example.StructureSFYN.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    //Metodo constructor

    //@Override
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    //
    // @Override
    public List<Empresa>getListaEmpresa(){
        return this.empresaRepository.findAll();
    }
    // @Override
    public Empresa getEmpresa(int id){
        return this.empresaRepository.findById(id).get();
    }
    // @Override
    public Empresa crearEmpresa(Empresa newEmpresa){
        return  this.empresaRepository.save(newEmpresa);
    }

    //@Override
    public void eliminarEmpresa(int id){
        this.empresaRepository.deleteById(id);
    }

    // @Override
    public Empresa editarEmpresa(Empresa empresa, int id) {
        Empresa empresaBD = empresaRepository.findById(id).get();

        if (Objects.nonNull(
                empresa.getNombreEmpresa())
                && !"".equalsIgnoreCase(
                empresa.getNombreEmpresa())) {
            empresaBD.setNombreEmpresa(
                    empresa.getNombreEmpresa());
        }

        if (Objects.nonNull(
                empresa.getCiudadEmpresa())
                && !"".equalsIgnoreCase(
                empresa.getCiudadEmpresa())) {
            empresaBD.setCiudadEmpresa(
                    empresa.getCiudadEmpresa());
        }
        if (Objects.nonNull(
                empresa.getDireccionEmpresa())
                && !"".equalsIgnoreCase(
                empresa.getDireccionEmpresa())) {
            empresaBD.setDireccionEmpresa(
                    empresa.getDireccionEmpresa());
        }
        if (Objects.nonNull(
                empresa.getNitEmpresa())
                && !"".equalsIgnoreCase(
                empresa.getNitEmpresa().toString())) {
            empresaBD.setNitEmpresa(
                    empresa.getNitEmpresa());
        }
        if (Objects.nonNull(
                empresa.getCorreoEmpresa())
                && !"".equalsIgnoreCase(
                empresa.getCorreoEmpresa())) {
            empresaBD.setCorreoEmpresa(
                    empresa.getCorreoEmpresa());
        }
        if (Objects.nonNull(
                empresa.getTipoEmpresa())
                && !"".equalsIgnoreCase(
                empresa.getTipoEmpresa())) {
            empresaBD.setTipoEmpresa(
                    empresa.getTipoEmpresa());
        }
        if (Objects.nonNull(
                empresa.getTelefonoEmpresa())
                && !"".equalsIgnoreCase(
                empresa.getTelefonoEmpresa())) {
            empresaBD.setTelefonoEmpresa(
                    empresa.getTelefonoEmpresa());
        }

        if (Objects.nonNull(
                empresa.getTransacciones())
                && !"".equalsIgnoreCase(
                empresa.getTransacciones().toString())) {
            empresaBD.setTransacciones(
                    empresa.getTransacciones());
        }

        if (Objects.nonNull(
                empresa.getEmpleadoList())
                && !"".equalsIgnoreCase(
                empresa.getEmpleadoList().toString())) {
            empresaBD.setEmpleadoList(
                    empresa.getEmpleadoList());
        }
        if (Objects.nonNull(
                empresa.getCreatedAt())
                && !"".equalsIgnoreCase(
                empresa.getCreatedAt().toString())) {
            empresaBD.setCreatedAt(
                    empresa.getCreatedAt());
        }
        if (Objects.nonNull(
                empresa.getUpdatedAt())
                && !"".equalsIgnoreCase(
                empresa.getUpdatedAt().toString())) {
            empresaBD.setUpdatedAt(
                    empresa.getUpdatedAt());
        }
        return empresaRepository.save(empresaBD);
    }


}
