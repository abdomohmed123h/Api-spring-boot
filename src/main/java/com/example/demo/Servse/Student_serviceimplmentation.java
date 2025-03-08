package com.example.demo.Servse;

import com.example.demo.dto.Stutntdeto;
import com.example.demo.model.Stutnt;
import com.example.demo.repo.Studentrepostely;
import jakarta.transaction.SystemException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.UndeclaredThrowableException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service


public class Student_serviceimplmentation implements Student_servisinterface {
     @Autowired
    private Studentrepostely studentrepostely;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void sevestudent(Stutnt stutnt) {
        stutnt.setId(null); // Ensure ID is null before saving
        studentrepostely.save(stutnt);
}

    @Override
    public boolean  updetstudent(Stutnt student) {
        if (studentrepostely.findById(student.getId()) != null) {
            studentrepostely.save(student);
            return true;
        }else {
            return false;

        }
    }


    @Override
    public boolean delstudent(Long id) {
        Optional<Stutnt> student = studentrepostely.findById(id); // Correct check
        if (student.isPresent()) {
            studentrepostely.deleteById(id);
            return true;  // Successfully deleted
        }
        return false; // Student not found
}

    @Override
    public Stutnt findById(Long id) {
        return studentrepostely.findById(id).orElse(null);
    }

    @Override
    public List<Stutnt> findAll() {
        return studentrepostely.findAll();
    }

    @Override
    public List<Stutnt> findByName(String name) {
        if (studentrepostely.findByName(name).isEmpty()) {
            return null;


        }else {
            return studentrepostely.findByName(name);

        }
    }

    @Override
    public List<Stutnt> findicloding(String surname) {
        boolean surnamefound =studentrepostely.findByNameContainingIgnoreCase(surname).isEmpty();
        if (surnamefound) {
            return studentrepostely.findByNameContainingIgnoreCase(surname);

        }else {
            return null;
        }
    }

    @Override
    public List<String> findAllNames() {
        return studentrepostely.findAllNames();
    }

    @Override
    public List<Stutnt> findByNameLike(String name) {
        return studentrepostely.findByNameLike(name);
    }


    @Override
    public int changePassword(long id, String password) {
        return studentrepostely.updatePassword(id, password);
    }

    @Override
    public void sevestudentdeo(Stutntdeto student) {
        studentrepostely.save(modelMapper.map(student, Stutnt.class));
    }

    public void sevestudentexception(Stutntdeto student) throws SystemException {
        if (student.getId() != null) {

            throw new RuntimeException("inviled.id");
        } else {
          studentrepostely.save(modelMapper.map(student, Stutnt.class));
        }
    }



}




