package com.example.demo.repo;

import com.example.demo.model.Stutnt;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface Studentrepostely extends JpaRepository<Stutnt, Long> {
    List<Stutnt> findByName(String name);

    List<Stutnt> findByNameContainingIgnoreCase(String name);
    @Query("SELECT name FROM Stutnt ")
    List<String> findAllNames();
    @Query("SELECT s FROM Stutnt s WHERE s.name LIKE CONCAT('%', :name, '%')")
    List<Stutnt> findByNameLike(String name);





}
