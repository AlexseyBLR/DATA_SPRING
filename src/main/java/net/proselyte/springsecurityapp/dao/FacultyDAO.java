package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyDAO extends JpaRepository<Faculty, Long> {
}
