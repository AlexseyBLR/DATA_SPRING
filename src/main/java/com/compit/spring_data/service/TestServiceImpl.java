package com.compit.spring_data.service;

import com.compit.spring_data.dao.TestDAO;
import com.compit.spring_data.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDAO testDAO;

    @Override
    public List<Test> getAll() {
        return testDAO.findAll();
    }
}
