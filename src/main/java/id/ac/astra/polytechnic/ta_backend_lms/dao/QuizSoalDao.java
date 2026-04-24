package id.ac.astra.polytechnic.ta_backend_lms.dao;

import id.ac.astra.polytechnic.ta_backend_lms.vo.QuizSoalDetailVo;
import id.ac.astra.polytechnic.ta_backend_lms.vo.QuizSoalVo;

import java.util.List;

public interface QuizSoalDao {
    QuizSoalVo save(QuizSoalVo quizSoalVO);
    QuizSoalVo update(QuizSoalVo QuizSoalVo);
    boolean delete(Long id);
    QuizSoalVo findById(Long id);
    List<QuizSoalVo> findByMateriId(Long materiId);
    List<QuizSoalVo> findAll();
    QuizSoalDetailVo findSoalWithPilihan(Long soalId);
    List<QuizSoalDetailVo> findAllSoalWithPilihanByMateri(Long materiId);
    int countByMateriId(Long materiId);
    List<QuizSoalVo> findByMateriIdAndJenis(Long materiId, String jenis);  // ✅ Tambahan
    List<QuizSoalDetailVo> findAllSoalWithPilihanByMateriAndJenis(Long materiId, String jenis);  // ✅ Tambahan

}
