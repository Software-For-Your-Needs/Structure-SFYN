package com.example.StructureSFYN.controllers;

import com.example.StructureSFYN.entities.Profile;
import com.example.StructureSFYN.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sfyn")
@Service
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }
    @GetMapping("/profile")
    public List<Profile> getListProfiles(){
        return this.profileService.getListProfiles();
    }
    @GetMapping("/profile/{id}")
    public Optional<Profile> getProfile(@PathVariable("id") int id){
        return this.profileService.getProfile(id);
    }
    @PostMapping("/profile")
    public Profile crearProfile(@RequestBody Profile profile){
        return this.profileService.crearProfile(profile);
    }
    @DeleteMapping("/profile/{id}")
    public String eliminarProfile(@PathVariable("id") int id){
        this.profileService.eliminarProfile(id);
        return "Se ha eliminado un registro";
    }
    @PutMapping("/profile/{id}")
    public Profile editarProfile(@PathVariable("id") int id, @RequestBody Profile profile){
        return this.profileService.editarProfile(profile, id);
    }
}
