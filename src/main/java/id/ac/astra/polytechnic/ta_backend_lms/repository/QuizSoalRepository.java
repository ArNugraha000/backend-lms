package id.ac.astra.polytechnic.ta_backend_lms.repository;

import id.ac.astra.polytechnic.ta_backend_lms.model.QuizSoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuizSoalRepository extends JpaRepository<QuizSoal, Long> {

    List<QuizSoal> findByMqsMtrIdOrderByMqsNomorSoalAsc(Long mtrId);

    List<QuizSoal> findByMqsMtrId(Long mtrId);

    @Query("SELECT q FROM QuizSoal q WHERE q.mqsMtrId = :materiId ORDER BY q.mqsNomorSoal")
    List<QuizSoal> findSoalByMateriId(@Param("materiId") Long materiId);

    List<QuizSoal> findByMqsMtrIdAndMqsJenisOrderByMqsNomorSoalAsc(Long mtrId, String jenis);

    @Query("SELECT q FROM QuizSoal q WHERE q.mqsMtrId = :materiId AND q.mqsJenis = :jenis ORDER BY q.mqsNomorSoal")
    List<QuizSoal> findSoalByMateriIdAndJenis(@Param("materiId") Long materiId, @Param("jenis") String jenis);

}
