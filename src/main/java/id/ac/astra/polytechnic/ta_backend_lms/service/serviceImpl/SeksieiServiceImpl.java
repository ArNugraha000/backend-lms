package id.ac.astra.polytechnic.ta_backend_lms.service.serviceImpl;



import id.ac.astra.polytechnic.ta_backend_lms.constant.KursusConstant;
import id.ac.astra.polytechnic.ta_backend_lms.dao.KursusDao;
import id.ac.astra.polytechnic.ta_backend_lms.dao.SeksieDao;
import id.ac.astra.polytechnic.ta_backend_lms.model.Departemen;
import id.ac.astra.polytechnic.ta_backend_lms.model.Seksie;
import id.ac.astra.polytechnic.ta_backend_lms.repository.DepartemenRepository;
import id.ac.astra.polytechnic.ta_backend_lms.repository.KursusRepository;
import id.ac.astra.polytechnic.ta_backend_lms.repository.SeksieRepository;
import id.ac.astra.polytechnic.ta_backend_lms.respone.DtoResponse;
import id.ac.astra.polytechnic.ta_backend_lms.service.DepartemenService;
import id.ac.astra.polytechnic.ta_backend_lms.service.KursusService;
import id.ac.astra.polytechnic.ta_backend_lms.service.SeksieService;
import id.ac.astra.polytechnic.ta_backend_lms.vo.SeksieVo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static id.ac.astra.polytechnic.ta_backend_lms.constant.KursusConstant.mEmptyData;


@Service
@Transactional
public class SeksieiServiceImpl implements SeksieService {

    @Autowired
    private SeksieDao seksieDBDao;

    @Autowired
    private SeksieRepository seksieDBRepository;

    @Autowired
    private DepartemenRepository departemenRepository;

    @Override
    public DtoResponse getAll() {
        List<SeksieVo> seksiList = seksieDBDao.getAll();

        if (seksiList != null && !seksiList.isEmpty()) {
            return new DtoResponse(200, "Data berhasil ditemukan", seksiList);
        }
        return new DtoResponse(404, "Data tidak ditemukan", null);
    }

    public List<Seksie> getAlls() {
        return seksieDBRepository.findAll();
    }

    public Seksie save(Seksie s) {
        s.setSekCreateDate(new Date());
        return seksieDBRepository.save(s);
    }


    @Override
    public DtoResponse update(SeksieVo vo) {
        Seksie s = seksieDBDao.findById(vo.getSekId());

        if (s == null) {
            return new DtoResponse(404, null, "Data tidak ditemukan");
        }

        try {
            s.setSekJudul(vo.getSekJudul());
            s.setSekNama(vo.getSekNama());
            s.setSekModifDate(new Date());
            s.setSekModifBy(vo.getSekModifBy());

            if (vo.getDepId() == null) {
                return new DtoResponse(400, null, "Departemen ID tidak boleh kosong");
            }

            Departemen d = departemenRepository.findById(vo.getDepId())
                    .orElseThrow(() -> new RuntimeException("Departemen tidak ditemukan"));

            s.setDepartemen(d);

            seksieDBDao.save(s);

            return new DtoResponse(200,  KursusConstant.mSuccessUpdate, "Berhasil update");

        } catch (Exception e) {
            e.printStackTrace(); // 🔥 penting biar kelihatan error asli
            throw e; // 🔥 jangan ditutup!
        }
    }


    @Override
    public DtoResponse softDelete(Long id, String userName) {
        try {
            Seksie s = seksieDBDao.findById(id);
            if (s == null) return new DtoResponse(404, null, "Data tidak ditemukan");

            // Toggle status
            s.setSekStatus("1".equals(s.getSekStatus()) ? "0" : "1");

            // Catat tanggal dan user yang memodifikasi
            s.setSekModifDate(new Date());
            s.setSekModifBy(userName != null ? userName : "SYSTEM");

            seksieDBDao.save(s);

            return new DtoResponse(200, null, "Berhasil toggle status");
        } catch (Exception e) {
            return new DtoResponse(500, null, "Error: " + e.getMessage());
        }
    }


}
