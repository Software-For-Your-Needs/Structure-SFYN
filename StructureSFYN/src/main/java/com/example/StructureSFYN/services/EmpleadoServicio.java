package com.example.StructureSFYN.services;

import com.example.StructureSFYN.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadoServicio {

    @Autowired
    private EmpleadoRepository empleadoRepository;
}
