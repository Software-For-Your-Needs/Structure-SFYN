package com.example.StructureSFYN.controller;


import com.example.StructureSFYN.entities.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


@Service
@RestController
@RequestMapping("/sfyn")
public class EmpleadoControlador {
   // @Autowired
    //Empleado empleado=new Empleado();

    @GetMapping("/prueba")
    public String prueba(){

        return "231";

    }
}
