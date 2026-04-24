package id.ac.astra.polytechnic.ta_backend_lms.dao.daoImpl;

import id.ac.astra.polytechnic.ta_backend_lms.dao.DepartemenDao;
import id.ac.astra.polytechnic.ta_backend_lms.dao.MateriDao;
import id.ac.astra.polytechnic.ta_backend_lms.model.Departemen;
import id.ac.astra.polytechnic.ta_backend_lms.model.Materi;
import id.ac.astra.polytechnic.ta_backend_lms.repository.DepartemenRepository;
import id.ac.astra.polytechnic.ta_backend_lms.repository.MateriRepository;
import id.ac.astra.polytechnic.ta_backend_lms.vo.DepartemenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MateriDaoImpl implements MateriDao {


    @Autowired
    private MateriRepository repo;

    @Override
    public List<Materi> getAll() {
        return repo.findAll();
    }

    @Override
    public Materi getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Materi save(Materi materi) {
        return repo.save(materi);
    }

    @Override
    public void delete(Materi materi) {
        repo.save(materi);
    }
}

