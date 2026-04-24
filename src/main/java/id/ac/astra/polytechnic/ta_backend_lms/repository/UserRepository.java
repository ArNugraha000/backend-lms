package id.ac.astra.polytechnic.ta_backend_lms.repository;

import id.ac.astra.polytechnic.ta_backend_lms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByUsrStatus(Integer status);

    List<User> findByUsrId(Long krsId);

    List<User> findByUsrNameAndUsrPassword(String usrName, String usrPassword);

}
