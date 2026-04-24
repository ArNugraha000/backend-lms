package id.ac.astra.polytechnic.ta_backend_lms.service.serviceImpl;



import id.ac.astra.polytechnic.ta_backend_lms.constant.KursusConstant;
import id.ac.astra.polytechnic.ta_backend_lms.dao.DivisiDao;
import id.ac.astra.polytechnic.ta_backend_lms.model.Departemen;
import id.ac.astra.polytechnic.ta_backend_lms.model.Divisi;
import java.util.List;
import id.ac.astra.polytechnic.ta_backend_lms.repository.DivisiRepository;
import id.ac.astra.polytechnic.ta_backend_lms.respone.DtoResponse;
import id.ac.astra.polytechnic.ta_backend_lms.service.DivisiService;
import id.ac.astra.polytechnic.ta_backend_lms.vo.DepartemenVo;
import id.ac.astra.polytechnic.ta_backend_lms.vo.DivisiVo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static id.ac.astra.polytechnic.ta_backend_lms.constant.KursusConstant.mEmptyData;


@Service
@Transactional
public class DivisiServiceImpl implements DivisiService {

    @Autowired
    private DivisiDao DivisiDBDao;

    @Autowired
    private DivisiRepository divisiDBRepository;

    @Override
    public DtoResponse getAll() {
        List<DivisiVo> divisiList = DivisiDBDao.getAll();

        if (divisiList != null && !divisiList.isEmpty()) {
            return new DtoResponse(200, "Data berhasil ditemukan", divisiList);
        } else {
            return new DtoResponse(404, "Data tidak ditemukan", null);
        }
    }

    public List<Divisi> findAll() {
        return divisiDBRepository.findAll();
    }

    @Override
    public Divisi save(Divisi d) {
        d.setDivCreateDate(new Date());
        return divisiDBRepository.save(d);
    }

    public List<Divisi> getAlls() {
        return divisiDBRepository.findAll();
    }

    @Override
    public DtoResponse softDelete(Long id, String userName) {
        try {
            Divisi d = DivisiDBDao.findById(id);
            if(d == null) return new DtoResponse(404, null, "Data tidak ditemukan");

            d.setDivStatus("1".equals(d.getDivStatus()) ? "0" : "1");
            d.setDivModifDate(new Date());
            d.setDivModifBy(userName != null ? userName : "SYSTEM");
            DivisiDBDao.save(d);

            return new DtoResponse(200, null, "Berhasil toggle status");
        } catch(Exception e) {
            return new DtoResponse(500, null, "Error: "+ e.getMessage());
        }
    }

    @Override
    public DtoResponse update(DivisiVo vo) {
        Divisi d = divisiDBRepository.findById(vo.getDivId()).orElse(null);

        if (d == null) {
            return new DtoResponse(404, null, "Data tidak ditemukan");
        }

        try {
            d.setDivJudul(vo.getDivJudul());
            d.setDivNama(vo.getDivNama());
            d.setDivModifBy(vo.getDivModifBy());
            d.setDivModifDate(new Date());

            divisiDBRepository.save(d);

            return new DtoResponse(200, KursusConstant.mSuccessUpdate, "Berhasil update");

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
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
