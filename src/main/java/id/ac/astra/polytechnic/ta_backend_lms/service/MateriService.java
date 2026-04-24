package id.ac.astra.polytechnic.ta_backend_lms.service;

import id.ac.astra.polytechnic.ta_backend_lms.model.Divisi;
import id.ac.astra.polytechnic.ta_backend_lms.model.Materi;
import id.ac.astra.polytechnic.ta_backend_lms.respone.DtoResponse;
import id.ac.astra.polytechnic.ta_backend_lms.vo.DivisiVo;
import id.ac.astra.polytechnic.ta_backend_lms.vo.MateriVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MateriService {


    List<Materi> getAll();
    Materi getById(Long id);
    Materi create(MateriVo vo, MultipartFile file, String userName);
    Materi update(Long id, MateriVo vo, MultipartFile file, String userName);
    void softDelete(Long id, String userName);

}
