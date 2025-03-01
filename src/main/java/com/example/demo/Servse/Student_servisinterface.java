package com.example.demo.Servse;

import com.example.demo.model.Stutnt;

import java.util.List;

public interface Student_servisinterface {
  void sevestudent(Stutnt student);
  boolean updetstudent(Stutnt student);
  boolean delstudent(Long id);
   Stutnt findById(Long id);
   List<Stutnt> findAll();
    List<Stutnt> findByName(String name);
    List<Stutnt> findicloding (String surname);
    List<String> findAllNames();
    List<Stutnt> findByNameLike(String name);



}
