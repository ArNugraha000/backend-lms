package id.ac.astra.polytechnic.ta_backend_lms.dao.daoImpl;

import id.ac.astra.polytechnic.ta_backend_lms.dao.SeksieDao;
import id.ac.astra.polytechnic.ta_backend_lms.dao.UserDao;
import id.ac.astra.polytechnic.ta_backend_lms.model.Seksie;
import id.ac.astra.polytechnic.ta_backend_lms.model.User;
import id.ac.astra.polytechnic.ta_backend_lms.repository.SeksieRepository;
import id.ac.astra.polytechnic.ta_backend_lms.repository.UserRepository;
import id.ac.astra.polytechnic.ta_backend_lms.vo.SeksieVo;
import id.ac.astra.polytechnic.ta_backend_lms.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SeksieDaoImpl implements SeksieDao {

    @Autowired
    private SeksieRepository seksieRepository;

    @Override
    public List<SeksieVo> getAll() {
        return seksieRepository.findAll()
                .stream()
                .map(s -> {
                    SeksieVo vo = new SeksieVo();
                    vo.setSekId(s.getSekId());
                    vo.setSekNama(s.getSekNama());
                    vo.setSekJudul(s.getSekJudul());

                    // 🔥 INI BAGIAN PENTING
                    if ("0".equals(s.getSekStatus())) {
                        vo.setSekStatus("AKTIF");
                    } else if ("1".equals(s.getSekStatus())) {
                        vo.setSekStatus("NONAKTIF");
                    } else {
                        vo.setSekStatus("UNKNOWN");
                    }

                    return vo;
                })
                .toList();
    }


    @Override
    public Seksie findById(Long id) {
        return seksieRepository.findById(id).orElse(null);
    }

    @Override
    public Seksie save(Seksie s) {
        return seksieRepository.save(s);
    }
}