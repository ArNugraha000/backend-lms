package id.ac.astra.polytechnic.ta_backend_lms.service;

import id.ac.astra.polytechnic.ta_backend_lms.model.Departemen;
import id.ac.astra.polytechnic.ta_backend_lms.model.Seksie;
import id.ac.astra.polytechnic.ta_backend_lms.respone.DtoResponse;
import id.ac.astra.polytechnic.ta_backend_lms.vo.DepartemenVo;

import java.util.List;

public interface DepartemenService {


    DtoResponse getAll();

    List<DepartemenVo> getAlls();

    Departemen save(Departemen sek);

    DtoResponse update(DepartemenVo vo);

    DtoResponse softDelete(Long id, String userName);

//    Kursus saveKursus(Kursus kursus);
//
//    void deleteKursus(Long id);
//
//    List<Kursus> getAll();
//
//    Kursus save(Kursus kursus);


}
