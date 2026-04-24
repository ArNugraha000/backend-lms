package id.ac.astra.polytechnic.ta_backend_lms.repository;

import id.ac.astra.polytechnic.ta_backend_lms.model.QuizPilihan;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuizPilihanRepository extends JpaRepository<QuizPilihan, Long> {

    List<QuizPilihan> findByQqpMqsIdOrderByQqpUrutanAsc(Long mqsId);

    List<QuizPilihan> findByQqpMqsId(Long mqsId);

    @Modifying
    @Transactional
    void deleteByQqpMqsId(Long mqsId);


}
