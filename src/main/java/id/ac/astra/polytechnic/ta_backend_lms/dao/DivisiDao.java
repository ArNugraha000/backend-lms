package id.ac.astra.polytechnic.ta_backend_lms.dao;


import id.ac.astra.polytechnic.ta_backend_lms.model.Divisi;
import id.ac.astra.polytechnic.ta_backend_lms.model.User;
import id.ac.astra.polytechnic.ta_backend_lms.vo.DivisiVo;
import id.ac.astra.polytechnic.ta_backend_lms.vo.UserVo;

import java.util.List;

public interface DivisiDao {

    List<DivisiVo> getAll();

    Divisi findById(Long id);

    Divisi save(Divisi d);
}