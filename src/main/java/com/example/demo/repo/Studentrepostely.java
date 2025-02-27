package com.example.demo.repo;

import com.example.demo.model.Stutnt;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Studentrepostely extends JpaRepository<Stutnt, Long> {
    List<Stutnt> findByName(String name);

    List<Stutnt> findByNameContainingIgnoreCase(String name);
}
