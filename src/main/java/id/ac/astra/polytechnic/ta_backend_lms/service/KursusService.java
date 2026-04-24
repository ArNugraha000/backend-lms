package id.ac.astra.polytechnic.ta_backend_lms.service;

import id.ac.astra.polytechnic.ta_backend_lms.model.Kursus;
import id.ac.astra.polytechnic.ta_backend_lms.model.Seksie;
import id.ac.astra.polytechnic.ta_backend_lms.respone.DtoResponse;
import id.ac.astra.polytechnic.ta_backend_lms.vo.KursusVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface KursusService {

    DtoResponse getAllKursus();
    DtoResponse getAllPublishedKursus();
    DtoResponse getAllUnpublishedKursus();
    DtoResponse getKursusById(Long id);
    DtoResponse saveKursus(KursusVo kursusVo, MultipartFile file);
    DtoResponse updateKursus(KursusVo kursusVo, MultipartFile file);
    DtoResponse softDeleteKursus(Long id, String modifier);
    DtoResponse publishKursus(Long id, String modifier);

}
