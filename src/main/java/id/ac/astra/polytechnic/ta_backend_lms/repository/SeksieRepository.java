package id.ac.astra.polytechnic.ta_backend_lms.repository;

import id.ac.astra.polytechnic.ta_backend_lms.model.Seksie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SeksieRepository extends JpaRepository<Seksie, Long> {

}
