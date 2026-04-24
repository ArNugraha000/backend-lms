package id.ac.astra.polytechnic.ta_backend_lms.repository;



import id.ac.astra.polytechnic.ta_backend_lms.model.Materi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MateriRepository extends JpaRepository<Materi, Long> {
    List<Materi> findByStatus(Integer status);
}