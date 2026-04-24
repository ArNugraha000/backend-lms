package id.ac.astra.polytechnic.ta_backend_lms.service;

import id.ac.astra.polytechnic.ta_backend_lms.respone.ResponseVo;
import id.ac.astra.polytechnic.ta_backend_lms.vo.QuizSoalDetailVo;
import id.ac.astra.polytechnic.ta_backend_lms.vo.QuizSoalVo;

import java.util.List;

public interface QuizSoalService {
    ResponseVo<QuizSoalVo> createSoal(QuizSoalVo quizSoalVO);
    ResponseVo<QuizSoalVo> updateSoal(QuizSoalVo quizSoalVO);
    ResponseVo<String> deleteSoal(Long id);
    ResponseVo<QuizSoalVo> getSoalById(Long id);
    ResponseVo<List<QuizSoalVo>> getSoalByMateriId(Long materiId);
    ResponseVo<List<QuizSoalVo>> getSoalByMateriIdAndJenis(Long materiId, String jenis);
    ResponseVo<List<QuizSoalVo>> getAllSoal();
    ResponseVo<QuizSoalDetailVo> getSoalWithPilihan(Long soalId);
    ResponseVo<List<QuizSoalDetailVo>> getAllSoalWithPilihanByMateri(Long materiId);
    ResponseVo<List<QuizSoalDetailVo>> getAllSoalWithPilihanByMateriAndJenis(Long materiId, String jenis);  // ✅ Tambahan
    ResponseVo<Integer> getTotalSoalByMateri(Long materiId);
}
