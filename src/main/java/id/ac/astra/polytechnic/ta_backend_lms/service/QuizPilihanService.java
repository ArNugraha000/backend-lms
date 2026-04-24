package id.ac.astra.polytechnic.ta_backend_lms.service;

import id.ac.astra.polytechnic.ta_backend_lms.respone.ResponseVo;
import id.ac.astra.polytechnic.ta_backend_lms.vo.QuizPilihanVo;

import java.util.List;

public interface QuizPilihanService {

    ResponseVo<QuizPilihanVo> createPilihan(QuizPilihanVo quizPilihanVO);
    ResponseVo<QuizPilihanVo> updatePilihan(QuizPilihanVo quizPilihanVO);
    ResponseVo<String> deletePilihan(Long id);
    ResponseVo<QuizPilihanVo> getPilihanById(Long id);
    ResponseVo<List<QuizPilihanVo>> getPilihanBySoalId(Long soalId);
    ResponseVo<List<QuizPilihanVo>> getAllPilihan();
    ResponseVo<String> saveAllPilihan(List<QuizPilihanVo> pilihanList, Long soalId);
}
