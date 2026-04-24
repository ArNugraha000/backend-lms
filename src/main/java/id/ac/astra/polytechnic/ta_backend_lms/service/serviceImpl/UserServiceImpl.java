package id.ac.astra.polytechnic.ta_backend_lms.service.serviceImpl;



import id.ac.astra.polytechnic.ta_backend_lms.dao.UserDao;
import id.ac.astra.polytechnic.ta_backend_lms.model.User;
import id.ac.astra.polytechnic.ta_backend_lms.repository.UserRepository;
import id.ac.astra.polytechnic.ta_backend_lms.respone.DtoResponse;
import id.ac.astra.polytechnic.ta_backend_lms.service.UserService;
import id.ac.astra.polytechnic.ta_backend_lms.vo.UserVo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static id.ac.astra.polytechnic.ta_backend_lms.constant.KursusConstant.mEmptyData;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDBDao;

    @Autowired
    private UserRepository userDBRepository;

    @Override
    public DtoResponse getAllUser() {
        List<UserVo> userList = userDBDao.getAllUser();

        if (userList != null && !userList.isEmpty()) {
            return new DtoResponse(200, "Data user berhasil ditemukan", userList);
        }
        return new DtoResponse(404, "Data user tidak ditemukan", null);
    }

    @Override
    public List<UserVo> getUserById(Long usrId) {
        List<User> users = userDBDao.findByUsrId(usrId);

        return users.stream()
                .map(UserVo::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserVo> login(String usrName, String usrPassword) {

        List<User> users = userDBDao.login(usrName, usrPassword);

        return users.stream()
                .map(UserVo::new)
                .collect(Collectors.toList());
    }







}
