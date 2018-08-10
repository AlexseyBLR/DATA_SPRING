package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.FacultyDAO;
import net.proselyte.springsecurityapp.model.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyDAO facultyDAO;

    @Override
    public List<Faculty> getAll() {
        return facultyDAO.findAll();
    }
}
