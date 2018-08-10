package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.Speciality;

import java.util.List;

public interface SpecialityService {

    List<Speciality> getAll();

    void save(Speciality speciality);

    Speciality findByID(int ID);

}
