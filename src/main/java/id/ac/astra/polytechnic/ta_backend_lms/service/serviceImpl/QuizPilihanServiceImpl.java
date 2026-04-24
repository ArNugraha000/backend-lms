package id.ac.astra.polytechnic.ta_backend_lms.service.serviceImpl;

import id.ac.astra.polytechnic.ta_backend_lms.dao.QuizPilihanDao;
import id.ac.astra.polytechnic.ta_backend_lms.dao.QuizSoalDao;
import id.ac.astra.polytechnic.ta_backend_lms.model.QuizPilihan;
import id.ac.astra.polytechnic.ta_backend_lms.repository.QuizPilihanRepository;
import id.ac.astra.polytechnic.ta_backend_lms.respone.ResponseVo;
import id.ac.astra.polytechnic.ta_backend_lms.service.QuizPilihanService;
import id.ac.astra.polytechnic.ta_backend_lms.vo.QuizPilihanVo;
import id.ac.astra.polytechnic.ta_backend_lms.vo.QuizSoalVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class QuizPilihanServiceImpl implements QuizPilihanService {

    @Autowired
    private QuizPilihanDao quizPilihanDAO;

    @Autowired
    private QuizSoalDao quizSoalDAO;

    @Autowired
    private QuizPilihanRepository quizPilihanRepository;
    @Override
    public ResponseVo<QuizPilihanVo> createPilihan(QuizPilihanVo quizPilihanVO) {
        try {
            if (quizPilihanVO.getQqpMqsId() == null) {
                return ResponseVo.error("ID Soal tidak boleh kosong");
            }
            if (quizPilihanVO.getQqpKodePilihan() == null || quizPilihanVO.getQqpKodePilihan().isEmpty()) {
                return ResponseVo.error("Kode pilihan tidak boleh kosong");
            }
            if (quizPilihanVO.getQqpTeksPilihan() == null || quizPilihanVO.getQqpTeksPilihan().isEmpty()) {
                return ResponseVo.error("Teks pilihan tidak boleh kosong");
            }

            // Cek apakah soal exist
            QuizSoalVo soal = quizSoalDAO.findById(quizPilihanVO.getQqpMqsId());
            if (soal == null) {
                return ResponseVo.error("Soal tidak ditemukan");
            }

            QuizPilihanVo saved = quizPilihanDAO.save(quizPilihanVO);
            return ResponseVo.success("Pilihan jawaban berhasil dibuat", saved);
        } catch (Exception e) {
            return ResponseVo.error("Gagal membuat pilihan: " + e.getMessage());
        }
    }

    @Override
    public ResponseVo<QuizPilihanVo> updatePilihan(QuizPilihanVo quizPilihanVO) {
        try {
            if (quizPilihanVO.getQqpId() == null) {
                return ResponseVo.error("ID Pilihan tidak boleh kosong");
            }

            QuizPilihanVo existing = quizPilihanDAO.findById(quizPilihanVO.getQqpId());
            if (existing == null) {
                return ResponseVo.error("Pilihan tidak ditemukan");
            }

            QuizPilihanVo updated = quizPilihanDAO.update(quizPilihanVO);
            return ResponseVo.success("Pilihan berhasil diupdate", updated);
        } catch (Exception e) {
            return ResponseVo.error("Gagal update pilihan: " + e.getMessage());
        }
    }

    @Override
    public ResponseVo<String> deletePilihan(Long id) {
        try {
            if (id == null) {
                return ResponseVo.error("ID Pilihan tidak boleh kosong");
            }

            boolean deleted = quizPilihanDAO.delete(id);
            if (deleted) {
                return ResponseVo.success("Pilihan berhasil dihapus", null);
            } else {
                return ResponseVo.error("Pilihan tidak ditemukan");
            }
        } catch (Exception e) {
            return ResponseVo.error("Gagal hapus pilihan: " + e.getMessage());
        }
    }

    @Override
    public ResponseVo<QuizPilihanVo> getPilihanById(Long id) {
        try {
            QuizPilihanVo pilihan = quizPilihanDAO.findById(id);
            if (pilihan != null) {
                return ResponseVo.success(pilihan);
            } else {
                return ResponseVo.error("Pilihan tidak ditemukan");
            }
        } catch (Exception e) {
            return ResponseVo.error("Gagal mengambil data pilihan: " + e.getMessage());
        }
    }

    @Override
    public ResponseVo<List<QuizPilihanVo>> getPilihanBySoalId(Long soalId) {
        try {
            List<QuizPilihanVo> pilihanList = quizPilihanDAO.findBySoalId(soalId);
            return ResponseVo.success(pilihanList);
        } catch (Exception e) {
            return ResponseVo.error("Gagal mengambil data pilihan: " + e.getMessage());
        }
    }

    @Override
    public ResponseVo<List<QuizPilihanVo>> getAllPilihan() {
        try {
            List<QuizPilihanVo> pilihanList = quizPilihanDAO.findAll();
            return ResponseVo.success(pilihanList);
        } catch (Exception e) {
            return ResponseVo.error("Gagal mengambil semua data pilihan: " + e.getMessage());
        }
    }


    @Override
    @Transactional
    public ResponseVo<String> saveAllPilihan(List<QuizPilihanVo> pilihanList, Long soalId) {
        try {
            // Validasi
            if (soalId == null) {
                return ResponseVo.error("ID Soal tidak boleh kosong");
            }
            if (pilihanList == null || pilihanList.isEmpty()) {
                return ResponseVo.error("Pilihan jawaban tidak boleh kosong");
            }

            // ✅ KRUSIAL: Hapus semua pilihan lama terlebih dahulu
            // Ini akan mencegah constraint violation
            quizPilihanRepository.deleteByQqpMqsId(soalId);

            // ✅ Insert pilihan baru
            for (QuizPilihanVo pilihan : pilihanList) {
                QuizPilihan entity = new QuizPilihan();
                entity.setQqpMqsId(soalId);
                entity.setQqpKodePilihan(pilihan.getQqpKodePilihan());
                entity.setQqpTeksPilihan(pilihan.getQqpTeksPilihan());
                entity.setQqpUrutan(pilihan.getQqpUrutan());
                entity.setQqpCreatedBy(pilihan.getQqpCreatedBy() != null ? pilihan.getQqpCreatedBy() : "ADMIN");
                entity.setQqpCreatedDate(new Date());
                entity.setQqpModifDate(new Date());
                // JANGAN set ID - biarkan sequence berjalan

                quizPilihanRepository.save(entity);
            }

            return ResponseVo.success("Pilihan berhasil disimpan");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVo.error("Gagal simpan pilihan: " + e.getMessage());
        }
    }
}
