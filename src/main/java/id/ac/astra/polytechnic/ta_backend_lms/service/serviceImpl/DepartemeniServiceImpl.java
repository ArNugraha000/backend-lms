package id.ac.astra.polytechnic.ta_backend_lms.service.serviceImpl;



import id.ac.astra.polytechnic.ta_backend_lms.constant.KursusConstant;
import id.ac.astra.polytechnic.ta_backend_lms.dao.DepartemenDao;
import id.ac.astra.polytechnic.ta_backend_lms.dao.DivisiDao;
import id.ac.astra.polytechnic.ta_backend_lms.model.Departemen;
import id.ac.astra.polytechnic.ta_backend_lms.model.Divisi;
import id.ac.astra.polytechnic.ta_backend_lms.repository.DepartemenRepository;
import id.ac.astra.polytechnic.ta_backend_lms.repository.DivisiRepository;
import id.ac.astra.polytechnic.ta_backend_lms.respone.DtoResponse;
import id.ac.astra.polytechnic.ta_backend_lms.rest.DivisiRest;
import id.ac.astra.polytechnic.ta_backend_lms.service.DepartemenService;
import id.ac.astra.polytechnic.ta_backend_lms.vo.DepartemenVo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static id.ac.astra.polytechnic.ta_backend_lms.constant.KursusConstant.mEmptyData;


@Service
@Transactional
public class DepartemeniServiceImpl implements DepartemenService {

    @Autowired
    private DepartemenDao DepartemenDBDao;

    @Autowired
    private DivisiDao DivisiDBDao;

    @Autowired
    private DepartemenRepository departemenRepository ;
    @Autowired
    private DivisiRepository divisiRepository ;

    @Override
    public DtoResponse getAll() {
        List<DepartemenVo> departemenList = DepartemenDBDao.getAll();

        if (departemenList != null && !departemenList.isEmpty()) {
            return new DtoResponse(200, "Data berhasil ditemukan", departemenList);
        }
        return new DtoResponse(404, "Data tidak ditemukan", null);
    }

    @Override
    public Departemen save(Departemen d) {
        d.setDepCreateDate(new Date());
        return departemenRepository.save(d);
    }

    @Override
    public List<DepartemenVo> getAlls() {
        return departemenRepository.findAll()
                .stream()
                .map(dep -> new DepartemenVo(dep))
                .toList();
    }

    @Override
    public DtoResponse update(DepartemenVo vo) {
        Departemen s = departemenRepository.findById(vo.getDepId()).orElse(null);

        if (s == null) {
            return new DtoResponse(404, null, "Data tidak ditemukan");
        }

        try {
            s.setDepJudul(vo.getDepJudul());
            s.setDepNama(vo.getDepNama());
            s.setDepModifBy(vo.getDepModifBy());
            s.setDepModifDate(new Date());

            if (vo.getDivId() == null) {
                return new DtoResponse(400, null, "Divisi ID tidak boleh kosong");
            }

            Divisi d = divisiRepository.findById(vo.getDepId())
                    .orElseThrow(() -> new RuntimeException("Departemen tidak ditemukan"));

            s.setDivisi(d);

            departemenRepository.save(s);

            return new DtoResponse(200, KursusConstant.mSuccessUpdate, "Berhasil update");

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    @Override
    public DtoResponse softDelete(Long id, String userName) {
        try {
            Departemen d = DepartemenDBDao.findById(id);
            if(d == null) return new DtoResponse(404, null, "Data tidak ditemukan");

            d.setDepStatus("1".equals(d.getDepStatus()) ? "0" : "1");
            d.setDepModifDate(new Date());
            d.setDepModifBy(userName != null ? userName : "SYSTEM");
            DepartemenDBDao.save(d);

            return new DtoResponse(200, null, "Berhasil toggle status");
        } catch(Exception e) {
            return new DtoResponse(500, null, "Error: "+ e.getMessage());
        }
    }


//    @Override
//    public DtoResponse addPS(Kursus ps) {
//        try{
//            userDBRepository.save(ps);
//            // Inisialisasi encoder
//            //PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//            double tempweekday = ps.getWeekday_price() * 10 / 100;
//            ps.setWeekend_price((int) (ps.getWeekday_price() + tempweekday));
//
//            ps.setEvent_status(1);
//
//            // Simpan data user ke database
//            userDBRepository.save(ps);
//            return new DtoResponse(200,ps, mCreateSuccess);
//        }catch (Exception e){
//            return new DtoResponse(500,ps,mCreateFailed);
//        }
//    }

//    @Override
//    public DtoResponse editPS(Kursus ps) {
//        try {
//            // Cek apakah user ada di database
//            Optional<EV> existingData = userDBRepository.findById(ps.getEvent_id());
//
//
//            if (existingData.isPresent()) {
//                EV transaksiTemp = existingData.get();
//                transaksiTemp.setEvent_name(ps.getEvent_name());
//                transaksiTemp.setWeekday_price(ps.getWeekday_price());
//                double tempweekday = ps.getWeekday_price() * 10 / 100;
//                transaksiTemp.setWeekend_price((int) (ps.getWeekday_price() + tempweekday));
//                ps.setEvent_status(1);
//
//                //transaksiTemp.setWeekend_price(ps.getWeekend_price());
//                transaksiTemp.setEvent_status(1);
//                EV updated = userDBRepository.save(transaksiTemp);
//                return new DtoResponse(200, updated, mUpdateSuccess);
//            }else {
//                return new DtoResponse(404, null, mNotfound);
//
//            }
//        } catch (Exception e) {
//            return new DtoResponse(500, ps, mUpdateFail);
//        }
//    }

//    @Override
//    public DtoResponse deletePS(PS ps) {
//        try {
//            // Cek apakah user ada di database
//            Optional<Lap> existingData = userDBRepository.findById(Integer.valueOf(ps.getPs_id()));
//            if (existingData.isPresent()) {
//                Lap transaksiTemp = existingData.get();
//                transaksiTemp.setPs_status(0);
//                Lap updated = userDBRepository.save(transaksiTemp);
//                return new DtoResponse(200, updated, mUpdateSuccess);
//            }else {
//                return new DtoResponse(404, null, mNotfound);
//            }
//        } catch (Exception e) {
//            return new DtoResponse(500, ps, mUpdateFail);
//        }
//    }


}
