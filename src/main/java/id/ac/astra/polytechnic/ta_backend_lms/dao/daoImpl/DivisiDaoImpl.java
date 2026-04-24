package id.ac.astra.polytechnic.ta_backend_lms.dao.daoImpl;

import id.ac.astra.polytechnic.ta_backend_lms.dao.DivisiDao;
import id.ac.astra.polytechnic.ta_backend_lms.dao.UserDao;
import id.ac.astra.polytechnic.ta_backend_lms.model.Departemen;
import id.ac.astra.polytechnic.ta_backend_lms.model.Divisi;
import id.ac.astra.polytechnic.ta_backend_lms.model.User;
import id.ac.astra.polytechnic.ta_backend_lms.repository.DivisiRepository;
import id.ac.astra.polytechnic.ta_backend_lms.repository.UserRepository;
import id.ac.astra.polytechnic.ta_backend_lms.vo.DivisiVo;
import id.ac.astra.polytechnic.ta_backend_lms.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DivisiDaoImpl implements DivisiDao {

    @Autowired
    private DivisiRepository divisiRepository;

    @Override
    public List<DivisiVo> getAll() {
        return List.of();
    }

    @Override
    public Divisi findById(Long id) {
        return divisiRepository.findById(id).orElse(null);
    }

    @Override
    public Divisi save(Divisi s) {
        return divisiRepository.save(s);
    }
}