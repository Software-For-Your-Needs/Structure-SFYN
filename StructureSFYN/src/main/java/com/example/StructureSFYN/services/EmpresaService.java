package com.example.StructureSFYN.services;

import com.example.StructureSFYN.entities.Empresa;
import com.example.StructureSFYN.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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
    public List<Empresa> getListaEmpresa(){
        return empresaRepository.findAll();
    }
    // @Override
    public Empresa getEmpresa(int id){
        if(!this.empresaRepository.findById(id).isEmpty()){
            return this.empresaRepository.findById(id).get();
        }else{return null;}
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

        if (Objects.nonNull(empresa.getId())) {
            empresaBD.setNombreEmpresa(empresa.getNombreEmpresa());
            empresaBD.setCiudadEmpresa(empresa.getCiudadEmpresa());
            empresaBD.setDireccionEmpresa(empresa.getDireccionEmpresa());
            empresaBD.setNitEmpresa(empresa.getNitEmpresa());
            empresaBD.setCorreoEmpresa(empresa.getCorreoEmpresa());
            empresaBD.setTipoEmpresa(empresa.getTipoEmpresa());
            empresaBD.setTelefonoEmpresa(empresa.getTelefonoEmpresa());
            empresaBD.setTransacciones(empresa.getTransacciones());
            empresaBD.setEmpleados(empresa.getEmpleados());
            empresaBD.setUpdatedAt(new Date());
        }
        return empresaRepository.save(empresaBD);
    }


}
