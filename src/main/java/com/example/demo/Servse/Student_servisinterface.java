package com.example.demo.Servse;

import com.example.demo.dto.Stutntdeto;
import com.example.demo.model.Stutnt;
import jakarta.transaction.SystemException;
import org.springframework.cglib.proxy.UndeclaredThrowableException;

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
    int changePassword(long id, String password);
    void sevestudentdeo(Stutntdeto student);
   void sevestudentexception(
           Stutntdeto student
   ) throws SystemException;




}
