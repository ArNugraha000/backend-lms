package id.ac.astra.polytechnic.ta_backend_lms.dao;


import id.ac.astra.polytechnic.ta_backend_lms.vo.KursusVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface KursusDao {


    List<KursusVo> getAllKursus();
    List<KursusVo> getAllPublishedKursus();
    List<KursusVo> getAllUnpublishedKursus();
    Optional<KursusVo> getKursusById(Long id);
    KursusVo saveKursus(KursusVo kursusVo, MultipartFile file);
    KursusVo updateKursus(KursusVo kursusVo, MultipartFile file);
    boolean softDeleteKursus(Long id, String modifier);
    boolean publishKursus(Long id, String modifier);
}