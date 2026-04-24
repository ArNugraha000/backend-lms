package id.ac.astra.polytechnic.ta_backend_lms.service;

import id.ac.astra.polytechnic.ta_backend_lms.respone.DtoResponse;
import id.ac.astra.polytechnic.ta_backend_lms.vo.UserVo;

import java.util.List;

public interface UserService {


    DtoResponse getAllUser();

    List<UserVo> getUserById(Long usrId);

    List<UserVo> login(String usrName, String usrPassword);

//    Kursus saveKursus(Kursus kursus);
//
//    void deleteKursus(Long id);
//
//    List<Kursus> getAll();
//
//    Kursus save(Kursus kursus);


}
