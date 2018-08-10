package net.proselyte.springsecurityapp.model;


import javax.persistence.*;

@Entity
@Table(name = "speciality")
public class Speciality {

    @Id
    @Column(name = "specialityID")
    private int specialityID;

    @ManyToOne
    @JoinColumn(name = "facultyID")
    private Speciality facultyID;

    @Column(name = "specialityName")
    private String specialityName;

    public int getSpecialityID() {
        return specialityID;
    }

    public void setSpecialityID(int specialityID) {
        this.specialityID = specialityID;
    }

    public Speciality getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(Speciality facultyID) {
        this.facultyID = facultyID;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "specialityID=" + specialityID +
//                ", facultyID=" + facultyID +
                ", specialityName='" + specialityName + '\'' +
                '}';
    }
}
