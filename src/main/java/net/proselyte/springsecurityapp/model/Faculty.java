package net.proselyte.springsecurityapp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @Column(name = "facultyID")
    private int facultyID;

    @Column(name = "facultyName")
    private String facultyName;

    public int getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyID=" + facultyID +
                ", facultyName='" + facultyName + '\'' +
                '}';
    }
}
