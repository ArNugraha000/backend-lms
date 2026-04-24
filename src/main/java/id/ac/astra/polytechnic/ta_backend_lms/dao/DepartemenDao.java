package id.ac.astra.polytechnic.ta_backend_lms.dao;


import id.ac.astra.polytechnic.ta_backend_lms.model.Departemen;
import id.ac.astra.polytechnic.ta_backend_lms.model.User;
import id.ac.astra.polytechnic.ta_backend_lms.vo.DepartemenVo;
import id.ac.astra.polytechnic.ta_backend_lms.vo.UserVo;

import java.util.List;

public interface DepartemenDao {


    List<DepartemenVo> getAll();

    Departemen findById(Long id);

    Departemen save(Departemen d);
}