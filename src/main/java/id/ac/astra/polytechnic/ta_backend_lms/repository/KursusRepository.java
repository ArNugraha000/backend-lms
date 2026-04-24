package id.ac.astra.polytechnic.ta_backend_lms.repository;

import id.ac.astra.polytechnic.ta_backend_lms.model.Kursus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface KursusRepository extends JpaRepository<Kursus, Long> {

    List<Kursus> findByKrsStatus(Integer status);

    List<Kursus> findByKrsId(Long krsId);

    // Get only published courses (KRS_PUBLISH_STATUS = 2)
    @Query("SELECT k FROM Kursus k WHERE  k.krsStatus = 3")
    List<Kursus> findAllPublished();

    // Get unpublished (draft) courses (KRS_PUBLISH_STATUS = 1)
    @Query("SELECT k FROM Kursus k WHERE k.krsStatus = 2")
    List<Kursus> findAllUnpublished();

 /*   // Get only published courses (KRS_PUBLISH_STATUS = 2)
    @Query("SELECT k FROM Kursus k WHERE k.krsPublishStatus = 2 AND k.krsStatus = 0")
    List<Kursus> findAllPublished();

    // Get unpublished courses (KRS_PUBLISH_STATUS = 1)
    @Query("SELECT k FROM Kursus k WHERE k.krsPublishStatus = 1 AND k.krsStatus = 0")
    List<Kursus> findAllUnpublished();*/

    // Get all active courses (not soft deleted)
    @Query("SELECT k FROM Kursus k WHERE k.krsStatus != 0")
    List<Kursus> findAllActive();

    // Soft delete - update status to 1
    @Modifying
    @Query("UPDATE Kursus k SET k.krsStatus = 1, k.krsModifBy = :modifBy, k.krsModifDate = CURRENT_TIMESTAMP WHERE k.krsId = :id")
    int softDeleteById(@Param("id") Long id, @Param("modifBy") String modifBy);

    // Publish course - update publish status to 2
    @Modifying
    @Query("UPDATE Kursus k SET k.krsPublishStatus = 2, k.krsStatus = 3,  k.krsModifBy = :modifBy, k.krsModifDate = CURRENT_TIMESTAMP WHERE k.krsId = :id")
    int publishById(@Param("id") Long id, @Param("modifBy") String modifBy);


}
