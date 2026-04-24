package id.ac.astra.polytechnic.ta_backend_lms.service.serviceImpl;


import id.ac.astra.polytechnic.ta_backend_lms.dao.QuizPilihanDao;
import id.ac.astra.polytechnic.ta_backend_lms.dao.QuizSoalDao;
import id.ac.astra.polytechnic.ta_backend_lms.respone.ResponseVo;
import id.ac.astra.polytechnic.ta_backend_lms.service.QuizSoalService;
import id.ac.astra.polytechnic.ta_backend_lms.vo.QuizSoalDetailVo;
import id.ac.astra.polytechnic.ta_backend_lms.vo.QuizSoalVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class QuizSoalServiceImpl implements QuizSoalService {

    @Autowired
    private QuizSoalDao quizSoalDAO;

    @Autowired
    private QuizPilihanDao quizPilihanDAO;

    @Override
    public ResponseVo<QuizSoalVo> createSoal(QuizSoalVo quizSoalVO) {
        try {
            if (quizSoalVO.getMqsTeksSoal() == null || quizSoalVO.getMqsTeksSoal().isEmpty()) {
                return ResponseVo.error("Teks soal tidak boleh kosong");
            }
            if (quizSoalVO.getMqsMtrId() == null) {
                return ResponseVo.error("ID Materi tidak boleh kosong");
            }

            QuizSoalVo saved = quizSoalDAO.save(quizSoalVO);
            return ResponseVo.success("Soal berhasil dibuat", saved);
        } catch (Exception e) {
            return ResponseVo.error("Gagal membuat soal: " + e.getMessage());
        }
    }

    @Override
    public ResponseVo<QuizSoalVo> updateSoal(QuizSoalVo quizSoalVO) {
        try {
            if (quizSoalVO.getMqsId() == null) {
                return ResponseVo.error("ID Soal tidak boleh kosong");
            }

            QuizSoalVo existing = quizSoalDAO.findById(quizSoalVO.getMqsId());
            if (existing == null) {
                return ResponseVo.error("Soal tidak ditemukan");
            }

            QuizSoalVo updated = quizSoalDAO.update(quizSoalVO);
            return ResponseVo.success("Soal berhasil diupdate", updated);
        } catch (Exception e) {
            return ResponseVo.error("Gagal update soal: " + e.getMessage());
        }
    }

    @Override
    public ResponseVo<String> deleteSoal(Long id) {
        try {
            if (id == null) {
                return ResponseVo.error("ID Soal tidak boleh kosong");
            }

            // Hapus pilihan jawaban terlebih dahulu
            quizPilihanDAO.deleteBySoalId(id);

            // Hapus soal
            boolean deleted = quizSoalDAO.delete(id);
            if (deleted) {
                return ResponseVo.success("Soal berhasil dihapus", null);
            } else {
                return ResponseVo.error("Soal tidak ditemukan");
            }
        } catch (Exception e) {
            return ResponseVo.error("Gagal hapus soal: " + e.getMessage());
        }
    }

    @Override
    public ResponseVo<QuizSoalVo> getSoalById(Long id) {
        try {
            QuizSoalVo soal = quizSoalDAO.findById(id);
            if (soal != null) {
                return ResponseVo.success(soal);
            } else {
                return ResponseVo.error("Soal tidak ditemukan");
            }
        } catch (Exception e) {
            return ResponseVo.error("Gagal mengambil data soal: " + e.getMessage());
        }
    }

    @Override
    public ResponseVo<List<QuizSoalVo>> getSoalByMateriId(Long materiId) {
        try {
            List<QuizSoalVo> soalList = quizSoalDAO.findByMateriId(materiId);
            return ResponseVo.success(soalList);
        } catch (Exception e) {
            return ResponseVo.error("Gagal mengambil data soal: " + e.getMessage());
        }
    }

    @Override
    public ResponseVo<List<QuizSoalVo>> getSoalByMateriIdAndJenis(Long materiId, String jenis) {
        try {
            List<QuizSoalVo> soalList = quizSoalDAO.findByMateriIdAndJenis(materiId, jenis);
            return ResponseVo.success(soalList);
        } catch (Exception e) {
            return ResponseVo.error("Gagal mengambil data soal: " + e.getMessage());
        }
    }

    @Override
    public ResponseVo<List<QuizSoalVo>> getAllSoal() {
        try {
            List<QuizSoalVo> soalList = quizSoalDAO.findAll();
            return ResponseVo.success(soalList);
        } catch (Exception e) {
            return ResponseVo.error("Gagal mengambil semua data soal: " + e.getMessage());
        }
    }

    @Override
    public ResponseVo<QuizSoalDetailVo> getSoalWithPilihan(Long soalId) {
        try {
            QuizSoalDetailVo detail = quizSoalDAO.findSoalWithPilihan(soalId);
            if (detail != null) {
                return ResponseVo.success(detail);
            } else {
                return ResponseVo.error("Soal tidak ditemukan");
            }
        } catch (Exception e) {
            return ResponseVo.error("Gagal mengambil detail soal: " + e.getMessage());
        }
    }

    @Override
    public ResponseVo<List<QuizSoalDetailVo>> getAllSoalWithPilihanByMateri(Long materiId) {
        try {
            List<QuizSoalDetailVo> detailList = quizSoalDAO.findAllSoalWithPilihanByMateri(materiId);
            return ResponseVo.success(detailList);
        } catch (Exception e) {
            return ResponseVo.error("Gagal mengambil data soal lengkap: " + e.getMessage());
        }
    }

    @Override
    public ResponseVo<List<QuizSoalDetailVo>> getAllSoalWithPilihanByMateriAndJenis(Long materiId, String jenis) {
        try {
            List<QuizSoalDetailVo> detailList = quizSoalDAO.findAllSoalWithPilihanByMateriAndJenis(materiId, jenis);
            return ResponseVo.success(detailList);
        } catch (Exception e) {
            return ResponseVo.error("Gagal mengambil data soal lengkap: " + e.getMessage());
        }
    }

    @Override
    public ResponseVo<Integer> getTotalSoalByMateri(Long materiId) {
        try {
            int total = quizSoalDAO.countByMateriId(materiId);
            return ResponseVo.success(total);
        } catch (Exception e) {
            return ResponseVo.error("Gagal menghitung total soal: " + e.getMessage());
        }
    }
}
