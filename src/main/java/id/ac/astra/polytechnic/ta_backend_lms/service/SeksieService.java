package id.ac.astra.polytechnic.ta_backend_lms.service;

import id.ac.astra.polytechnic.ta_backend_lms.model.Seksie;
import id.ac.astra.polytechnic.ta_backend_lms.respone.DtoResponse;
import id.ac.astra.polytechnic.ta_backend_lms.vo.SeksieVo;
import org.apache.catalina.connector.Response;

import java.util.List;

public interface SeksieService {


    DtoResponse getAll();

    List<Seksie> getAlls();

    Seksie save(Seksie sek);

    DtoResponse update(SeksieVo vo);

    DtoResponse softDelete(Long id, String userName);

//    Kursus saveKursus(Kursus kursus);
//
//    void deleteKursus(Long id);
//
//    List<Kursus> getAll();
//
//    Kursus save(Kursus kursus);


}
