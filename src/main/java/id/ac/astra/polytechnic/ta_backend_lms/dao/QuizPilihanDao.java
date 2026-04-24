package id.ac.astra.polytechnic.ta_backend_lms.dao;

import id.ac.astra.polytechnic.ta_backend_lms.vo.QuizPilihanVo;

import java.util.List;

public interface QuizPilihanDao {
    QuizPilihanVo save(QuizPilihanVo QuizPilihanVo);
    QuizPilihanVo update(QuizPilihanVo QuizPilihanVo);
    boolean delete(Long id);
    QuizPilihanVo findById(Long id);
    List<QuizPilihanVo> findBySoalId(Long soalId);
    List<QuizPilihanVo> findAll();
    void saveAll(List<QuizPilihanVo> pilihanList);
    void deleteBySoalId(Long soalId);
}
