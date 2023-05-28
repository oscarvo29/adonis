package com.example.adonis.repositories;

import com.example.adonis.models.Preference;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PreferenceRepository extends JpaRepository<Preference, Long> {
}
