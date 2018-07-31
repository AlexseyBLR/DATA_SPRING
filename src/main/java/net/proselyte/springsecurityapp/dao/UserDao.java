package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Long> {

    @Query("select u from User u where u.username = :username")
    User findUserByUsername(@Param("username") String username);

//    @Modifying
//    @Query("update User u set u.firstname=:firstname, u.lastname=:lastname, u.patronymic=:patronymic," +
//            " u.age=:age, u.sex=:sex, u.profile=:profile where u.username=:username")
//    void updateUserInfo(@Param("firstname") String firstname, @Param("lastname") String lastname, @Param("patronymic") String patronymic,
//                        @Param("age") String age, @Param("sex") String sex, @Param("profile") String profile,
//                        @Param("username") String username);
//
//    @Modifying
//    @Query("update User u set mathResult=:mathResult, physResult=:physResult, langResult=:langResult, himResult=:himResult, " +
//            "bioResult=:bioResult, englResult=:englResult where u.username=:username")
//    void updateUserResults(@Param("mathResult") String mathResult, @Param("physResult") String physResult, @Param("langResult") String langResult,
//                           @Param("himResult") String himResult, @Param("bioResult") String bioResult, @Param("englResult") String englResult,
//                           @Param("username") String username);

}
