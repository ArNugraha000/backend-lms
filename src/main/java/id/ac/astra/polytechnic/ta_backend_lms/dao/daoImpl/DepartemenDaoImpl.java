package id.ac.astra.polytechnic.ta_backend_lms.dao.daoImpl;

import id.ac.astra.polytechnic.ta_backend_lms.dao.DepartemenDao;
import id.ac.astra.polytechnic.ta_backend_lms.dao.UserDao;
import id.ac.astra.polytechnic.ta_backend_lms.model.Departemen;
import id.ac.astra.polytechnic.ta_backend_lms.model.Seksie;
import id.ac.astra.polytechnic.ta_backend_lms.model.User;
import id.ac.astra.polytechnic.ta_backend_lms.repository.DepartemenRepository;
import id.ac.astra.polytechnic.ta_backend_lms.repository.UserRepository;
import id.ac.astra.polytechnic.ta_backend_lms.vo.DepartemenVo;
import id.ac.astra.polytechnic.ta_backend_lms.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartemenDaoImpl implements DepartemenDao {

    @Autowired
    private DepartemenRepository DepartemenRepository;

    @Override
    public List<DepartemenVo> getAll() {
        return List.of();
    }

    @Override
    public Departemen findById(Long id) {
        return DepartemenRepository.findById(id).orElse(null);
    }

    @Override
    public Departemen save(Departemen s) {
        return DepartemenRepository.save(s);
    }
}

