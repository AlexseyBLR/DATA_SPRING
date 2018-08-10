package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpecialityDAO extends JpaRepository<Speciality, Long> {

    @Query("select s from Speciality s where s.specialityID = :specialityID")
    Speciality findByID(@Param("specialityID") int specialityID);

}
