package net.proselyte.springsecurityapp.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Simple JavaBean domain object that represents a User.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "age")
    private String age;

    @Column(name = "sex")
    private String sex;

    @Column(name = "profile")
    private String profile;

    @Column(name = "mathResult")
    private String mathResult;

    @Column(name = "physResult")
    private String physResult;

    @Column(name = "langResult")
    private String langResult;

    @Column(name = "himResult")
    private String himResult;

    @Column(name = "biolResult")
    private String biolResult;

    @Column(name = "englResult")
    private String englResult;

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getMathResult() {
        return mathResult;
    }

    public void setMathResult(String mathResult) {
        this.mathResult = mathResult;
    }

    public String getPhysResult() {
        return physResult;
    }

    public void setPhysResult(String physResult) {
        this.physResult = physResult;
    }

    public String getLangResult() {
        return langResult;
    }

    public void setLangResult(String langResult) {
        this.langResult = langResult;
    }

    public String getHimResult() {
        return himResult;
    }

    public void setHimResult(String himResult) {
        this.himResult = himResult;
    }

    public String getBiolResult() {
        return biolResult;
    }

    public void setBiolResult(String biolResult) {
        this.biolResult = biolResult;
    }

    public String getEnglResult() {
        return englResult;
    }

    public void setEnglResult(String englResult) {
        this.englResult = englResult;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", profile='" + profile + '\'' +
                ", mathResult='" + mathResult + '\'' +
                ", physResult='" + physResult + '\'' +
                ", langResult='" + langResult + '\'' +
                ", himResult='" + himResult + '\'' +
                ", biolResult='" + biolResult + '\'' +
                ", englResult='" + englResult + '\'' +
                '}'+"\n";
    }
}
