package com.example.StructureSFYN.repositories;

import com.example.StructureSFYN.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
