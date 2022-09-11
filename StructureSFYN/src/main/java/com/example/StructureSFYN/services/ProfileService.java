package com.example.StructureSFYN.services;

import com.example.StructureSFYN.entities.Profile;
import com.example.StructureSFYN.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProfileService {


    private ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> getListProfiles() {

        return this.profileRepository.findAll();
    }


    public Optional<Profile> getProfile(int id) {
        return this.profileRepository.findById(id);
    }


    public Profile crearProfile(Profile nuevoProfile) {
        return this.profileRepository.save(nuevoProfile);
    }


    public Profile editarProfile(Profile profile, int id) {
        Profile profileBD = this.profileRepository.findById(id).get();

        if (Objects.nonNull(profileBD.getId())){
                    profileBD.setNombre(profile.getNombre());
                    profileBD.setImage(profile.getImage());
                    profileBD.setPhone(profile.getPhone());
                    profileBD.setUpdatedAt(new Date());
        }
        return this.profileRepository.save(profileBD);

    }
    public void eliminarProfile(int id){
        Profile profileBD = this.profileRepository.findById(id).get();
        if (Objects.nonNull(profileBD.getId())){
            this.profileRepository.deleteById(id);
        }
        
    }
}