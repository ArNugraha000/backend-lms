package id.ac.astra.polytechnic.ta_backend_lms.service.serviceImpl;


import id.ac.astra.polytechnic.ta_backend_lms.dao.MateriDao;
import id.ac.astra.polytechnic.ta_backend_lms.model.Materi;
import id.ac.astra.polytechnic.ta_backend_lms.service.MateriService;
import id.ac.astra.polytechnic.ta_backend_lms.vo.MateriVo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import static id.ac.astra.polytechnic.ta_backend_lms.constant.KursusConstant.mEmptyData;


@Service
@Transactional
public class MateriServiceImpl implements MateriService {

    @Autowired
    private MateriDao dao;

    @Value("${file.upload-dir}")
    private String uploadDir;

    private String saveFile(MultipartFile file) {
        try {
            if (file == null || file.isEmpty()) return null;

            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path path = Paths.get(uploadDir);

            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            Path filePath = path.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (Exception e) {
            throw new RuntimeException("Gagal upload file");
        }
    }

    @Override
    public Materi create(MateriVo vo, MultipartFile file, String userName) {
        Materi m = new Materi();

        m.setJenisMateri(vo.jenisMateri);
        m.setJudulMateri(vo.judulMateri);
        m.setIsiMateri(vo.isiMateri);
        m.setInformasiMateri(vo.informasiMateri);
        m.setAdaLink(vo.adaLink);
        m.setWaktuMelihat(vo.waktuMelihat);
        m.setWaktuQuiz(vo.waktuQuiz);

        String fileName = saveFile(file);
        m.setFileDokumen(fileName);

        m.setStatus(0);
        m.setCreateBy(userName);   // ✅ TAMBAH INI
        m.setCreateDate(new Date());

        return dao.save(m);
    }

    @Override
    public Materi update(Long id, MateriVo vo, MultipartFile file, String userName) {
        Materi m = dao.getById(id);

        m.setJenisMateri(vo.jenisMateri);
        m.setJudulMateri(vo.judulMateri);
        m.setIsiMateri(vo.isiMateri);
        m.setInformasiMateri(vo.informasiMateri);
        m.setAdaLink(vo.adaLink);
        m.setWaktuMelihat(vo.waktuMelihat);
        m.setWaktuQuiz(vo.waktuQuiz);

        if (file != null && !file.isEmpty()) {
            String fileName = saveFile(file);
            m.setFileDokumen(fileName);
        }

        m.setModifBy(userName);
        m.setModifDate(new Date());

        return dao.save(m);
    }

    @Override
    public void softDelete(Long id, String userName) {
        Materi m = dao.getById(id);

        m.setStatus(1);           // hapus sekali
        m.setModifBy(userName);   // ✅ TAMBAH INI
        m.setModifDate(new Date());

        dao.save(m);
    }

    @Override
    public List<Materi> getAll() {
        return dao.getAll();
    }

    @Override
    public Materi getById(Long id) {
        return dao.getById(id);
    }

}
