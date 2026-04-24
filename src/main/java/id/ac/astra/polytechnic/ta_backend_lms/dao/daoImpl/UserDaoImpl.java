package id.ac.astra.polytechnic.ta_backend_lms.dao.daoImpl;

import id.ac.astra.polytechnic.ta_backend_lms.dao.UserDao;
import id.ac.astra.polytechnic.ta_backend_lms.model.User;
import id.ac.astra.polytechnic.ta_backend_lms.repository.UserRepository;
import id.ac.astra.polytechnic.ta_backend_lms.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserVo> getAllUser() {

        List<User> userDBS = userRepository.findAll();
        List<UserVo> userDBVos = new ArrayList<>();

        for (User item : userDBS) {
            UserVo userDBVo = new UserVo(item);
            userDBVos.add(userDBVo);
        }

        return userDBVos;
    }

    @Override
    public List<User> findByUsrId(Long usrId) {
        return userRepository.findByUsrId(usrId);
    }

    @Override
    public List<User> login(String usrName, String usrPassword) {
        return userRepository.findByUsrNameAndUsrPassword(usrName, usrPassword);
    }
}