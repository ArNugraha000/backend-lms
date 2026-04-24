package id.ac.astra.polytechnic.ta_backend_lms.service;

import id.ac.astra.polytechnic.ta_backend_lms.model.Divisi;
import id.ac.astra.polytechnic.ta_backend_lms.model.Seksie;
import id.ac.astra.polytechnic.ta_backend_lms.respone.DtoResponse;
import id.ac.astra.polytechnic.ta_backend_lms.vo.DivisiVo;

import java.util.List;

public interface DivisiService {


    DtoResponse getAll();

    Divisi save(Divisi sek);

    List<Divisi> findAll();

    DtoResponse softDelete(Long id, String userName);

    DtoResponse update(DivisiVo vo);

}
