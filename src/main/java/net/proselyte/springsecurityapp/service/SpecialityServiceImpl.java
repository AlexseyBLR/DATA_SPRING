package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.SpecialityDAO;
import net.proselyte.springsecurityapp.model.Speciality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    private SpecialityDAO specialityDAO;

    @Override
    public List<Speciality> getAll() {
        return specialityDAO.findAll();
    }

    @Override
    public void save(Speciality speciality) {
        specialityDAO.save(speciality);
    }

    @Override
    public Speciality findByID(int ID) {
        return specialityDAO.findByID(ID);
    }

}
