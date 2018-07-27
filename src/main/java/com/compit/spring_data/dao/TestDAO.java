package com.compit.spring_data.dao;

import com.compit.spring_data.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDAO extends JpaRepository<Test, Long>{

//    List<Test> getAll();

}
