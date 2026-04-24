package id.ac.astra.polytechnic.ta_backend_lms.dao;


import id.ac.astra.polytechnic.ta_backend_lms.model.Seksie;
import id.ac.astra.polytechnic.ta_backend_lms.vo.SeksieVo;

import java.util.List;

public interface SeksieDao {

    List<SeksieVo> getAll();

    Seksie findById(Long id);

    Seksie save(Seksie s);


}