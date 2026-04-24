package id.ac.astra.polytechnic.ta_backend_lms.dao;


import id.ac.astra.polytechnic.ta_backend_lms.model.User;
import id.ac.astra.polytechnic.ta_backend_lms.vo.KursusVo;
import id.ac.astra.polytechnic.ta_backend_lms.vo.UserVo;

import java.util.List;

public interface UserDao {


    List<UserVo> getAllUser();

    List<User> findByUsrId(Long usrId);
    List<User> login(String usrName, String usrPassword);
}