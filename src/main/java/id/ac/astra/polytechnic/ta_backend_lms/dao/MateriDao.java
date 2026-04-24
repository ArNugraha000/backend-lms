package id.ac.astra.polytechnic.ta_backend_lms.dao;


import id.ac.astra.polytechnic.ta_backend_lms.model.Departemen;
import id.ac.astra.polytechnic.ta_backend_lms.model.Materi;
import id.ac.astra.polytechnic.ta_backend_lms.vo.DepartemenVo;

import java.util.List;

public interface MateriDao {


    List<Materi> getAll();
    Materi getById(Long id);
    Materi save(Materi materi);
    void delete(Materi materi);
}