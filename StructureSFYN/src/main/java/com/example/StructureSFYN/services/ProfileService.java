package com.example.StructureSFYN.services;

import com.example.StructureSFYN.entities.Profile;
import com.example.StructureSFYN.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

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
        Profile profileBD = profileRepository.findById(id).get();

        if (Objects.nonNull(
                profileBD.getNombre())
                && !"".equalsIgnoreCase(
                profile.getNombre())) {
            profileBD.setNombre(
                    profile.getNombre());
        }

        if (Objects.nonNull(
                profileBD.getImage())
                && !"".equalsIgnoreCase(
                profile.getImage())) {
            profileBD.setImage(
                    profile.getImage());
        }


        if (Objects.nonNull(
                profileBD.getPhone())
                && !"".equalsIgnoreCase(
                profile.getPhone())) {
            profileBD.setPhone(
                    profile.getPhone());
        }

        if (Objects.nonNull(
                profileBD.getCreatedAt())
                && !"".equalsIgnoreCase(
                profile.getCreatedAt().toString())) {
            profileBD.setCreatedAt(
                    profile.getCreatedAt());
        }

        if (Objects.nonNull(
                profileBD.getUpdatedAt())
                && !"".equalsIgnoreCase(
                profile.getUpdatedAt().toString())) {
            profileBD.setUpdatedAt(
                    profile.getUpdatedAt());
        }

        return this.profileRepository.save(profileBD);

    }
    public void eliminarProfile(int id){
        this.profileRepository.deleteById(id);
    }
}