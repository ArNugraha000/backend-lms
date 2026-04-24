package id.ac.astra.polytechnic.ta_backend_lms.service.serviceImpl;

import id.ac.astra.polytechnic.ta_backend_lms.constant.KursusConstant;
import id.ac.astra.polytechnic.ta_backend_lms.dao.KursusDao;
import id.ac.astra.polytechnic.ta_backend_lms.respone.DtoResponse;
import id.ac.astra.polytechnic.ta_backend_lms.service.KursusService;
import id.ac.astra.polytechnic.ta_backend_lms.vo.KursusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class KursusServiceImpl implements KursusService {

    @Autowired
    private KursusDao kursusDao;

    @Override
    public DtoResponse getAllKursus() {
        List<KursusVo> kursusList = kursusDao.getAllKursus();
        if (kursusList.isEmpty()) {
            return new DtoResponse(404, KursusConstant.mEmptyData, null);
        }
        return new DtoResponse(200, KursusConstant.mSuccessGet, kursusList);
    }

    @Override
    public DtoResponse getAllPublishedKursus() {
        List<KursusVo> kursusList = kursusDao.getAllPublishedKursus();
        return new DtoResponse(200, KursusConstant.mSuccessGet, kursusList);
    }

    @Override
    public DtoResponse getAllUnpublishedKursus() {
        List<KursusVo> kursusList = kursusDao.getAllUnpublishedKursus();
        return new DtoResponse(200, KursusConstant.mSuccessGet, kursusList);
    }

    @Override
    public DtoResponse getKursusById(Long id) {
        Optional<KursusVo> kursus = kursusDao.getKursusById(id);
        if (kursus.isPresent()) {
            return new DtoResponse(200, KursusConstant.mSuccessGet, kursus.get());
        }
        return new DtoResponse(404, KursusConstant.mEmptyData, null);
    }

    @Override
    public DtoResponse saveKursus(KursusVo kursusVo, MultipartFile file) {
        if (kursusVo.getKrsNama() == null || kursusVo.getKrsNama().isEmpty()) {
            return new DtoResponse(400, "Nama kursus harus diisi", null);
        }

        KursusVo saved = kursusDao.saveKursus(kursusVo, file);
        if (saved != null) {
            return new DtoResponse(201, KursusConstant.mSuccessSave, saved);
        }
        return new DtoResponse(500, KursusConstant.mFailedSave, null);
    }

    @Override
    public DtoResponse updateKursus(KursusVo kursusVo, MultipartFile file) {
        if (kursusVo.getKrsId() == null) {
            return new DtoResponse(400, "ID kursus harus diisi", null);
        }

        Optional<KursusVo> existing = kursusDao.getKursusById(kursusVo.getKrsId());
        if (existing.isEmpty()) {
            return new DtoResponse(404, KursusConstant.mEmptyData, null);
        }

        KursusVo updated = kursusDao.updateKursus(kursusVo, file);
        if (updated != null) {
            return new DtoResponse(200, KursusConstant.mSuccessUpdate, updated);
        }
        return new DtoResponse(500, KursusConstant.mFailedUpdate, null);
    }

    @Override
    public DtoResponse softDeleteKursus(Long id, String modifier) {
        Optional<KursusVo> existing = kursusDao.getKursusById(id);
        if (existing.isEmpty()) {
            return new DtoResponse(404, KursusConstant.mEmptyData, null);
        }

        boolean deleted = kursusDao.softDeleteKursus(id, modifier);
        if (deleted) {
            return new DtoResponse(200, KursusConstant.mSuccessDelete, null);
        }
        return new DtoResponse(500, KursusConstant.mFailedDelete, null);
    }

    @Override
    public DtoResponse publishKursus(Long id, String modifier) {
        Optional<KursusVo> existing = kursusDao.getKursusById(id);
        if (existing.isEmpty()) {
            return new DtoResponse(404, KursusConstant.mEmptyData, null);
        }

        boolean published = kursusDao.publishKursus(id, modifier);
        if (published) {
            return new DtoResponse(200, KursusConstant.mSuccessPublish, null);
        }
        return new DtoResponse(500, KursusConstant.mFailedPublish, null);
    }
}