package id.ac.astra.polytechnic.ta_backend_lms.dao.daoImpl;

import id.ac.astra.polytechnic.ta_backend_lms.dao.KursusDao;
import id.ac.astra.polytechnic.ta_backend_lms.model.Kursus;
import id.ac.astra.polytechnic.ta_backend_lms.repository.KursusRepository;
import id.ac.astra.polytechnic.ta_backend_lms.vo.KursusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class KursusDaoImpl implements KursusDao {

    @Autowired
    private KursusRepository kursusRepository;

    @Value("${upload.path:uploads}")
    private String uploadPath;

    private String saveFile(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return null;
        }

        Path uploadDir = Paths.get(uploadPath);
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }

        String originalFilename = file.getOriginalFilename();
        String extension = "";
        if (originalFilename != null && originalFilename.contains(".")) {
            extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        }

        String newFilename = UUID.randomUUID().toString() + extension;
        Path filePath = uploadDir.resolve(newFilename);
        Files.copy(file.getInputStream(), filePath);

        return newFilename;
    }

    private void deleteOldFile(String filename) {
        if (filename != null && !filename.isEmpty()) {
            try {
                Path filePath = Paths.get(uploadPath).resolve(filename);
                Files.deleteIfExists(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String buildImageUrl(String filename) {
        if (filename == null || filename.isEmpty()) {
            return null;
        }
        return "http://localhost:8080/uploads/" + filename;
    }

    @Override
    public List<KursusVo> getAllKursus() {
        return kursusRepository.findAllActive()
                .stream()
                .map(kursus -> {
                    KursusVo vo = new KursusVo(kursus);
                    vo.setKrsGambarUrl(buildImageUrl(vo.getKrsGambar()));
                    return vo;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<KursusVo> getAllPublishedKursus() {
        return kursusRepository.findAllPublished()
                .stream()
                .map(kursus -> {
                    KursusVo vo = new KursusVo(kursus);
                    vo.setKrsGambarUrl(buildImageUrl(vo.getKrsGambar()));
                    return vo;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<KursusVo> getAllUnpublishedKursus() {
        return kursusRepository.findAllUnpublished()
                .stream()
                .map(kursus -> {
                    KursusVo vo = new KursusVo(kursus);
                    vo.setKrsGambarUrl(buildImageUrl(vo.getKrsGambar()));
                    return vo;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Optional<KursusVo> getKursusById(Long id) {
        return kursusRepository.findById(id)  // ← Langsung pakai Long, tidak perlu konversi
                .map(kursus -> {
                    KursusVo vo = new KursusVo(kursus);
                    vo.setKrsGambarUrl(buildImageUrl(vo.getKrsGambar()));
                    return vo;
                });
    }

    @Override
    public KursusVo saveKursus(KursusVo kursusVo, MultipartFile file) {
        Kursus kursus = new Kursus();

        // Set fields
        kursus.setKrsNama(kursusVo.getKrsNama());
        kursus.setKrsJenis(kursusVo.getKrsJenis());
        kursus.setKrsDeskripsi(kursusVo.getKrsDeskripsi());
        kursus.setKrsStatus(0); // Active
        kursus.setKrsPublishStatus(1); // Draft/Not published

        // Handle file upload
        if (file != null && !file.isEmpty()) {
            try {
                String savedFilename = saveFile(file);
                kursus.setKrsGambar(savedFilename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        kursus.setKrsCreateBy(kursusVo.getKrsCreateBy() != null ? kursusVo.getKrsCreateBy() : "system");
        kursus.setKrsCreateDate(Timestamp.from(Instant.now()));
        kursus.setKrsModifBy(kursusVo.getKrsCreateBy() != null ? kursusVo.getKrsCreateBy() : "system");
        kursus.setKrsModifDate(Timestamp.from(Instant.now()));

        Kursus saved = kursusRepository.save(kursus);
        KursusVo result = new KursusVo(saved);
        result.setKrsGambarUrl(buildImageUrl(result.getKrsGambar()));
        return result;
    }

    @Override
    public KursusVo updateKursus(KursusVo kursusVo, MultipartFile file) {
        Optional<Kursus> existingOpt = kursusRepository.findById(kursusVo.getKrsId());  // ← Langsung pakai Long

        if (existingOpt.isPresent()) {
            Kursus kursus = existingOpt.get();

            kursus.setKrsNama(kursusVo.getKrsNama());
            kursus.setKrsJenis(kursusVo.getKrsJenis());
            kursus.setKrsDeskripsi(kursusVo.getKrsDeskripsi());

            // Handle file upload - replace old file if new file is provided
            if (file != null && !file.isEmpty()) {
                // Delete old file
                if (kursus.getKrsGambar() != null) {
                    deleteOldFile(kursus.getKrsGambar());
                }
                try {
                    String savedFilename = saveFile(file);
                    kursus.setKrsGambar(savedFilename);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            kursus.setKrsModifBy(kursusVo.getKrsModifBy() != null ? kursusVo.getKrsModifBy() : "system");
            kursus.setKrsModifDate(Timestamp.from(Instant.now()));

            Kursus saved = kursusRepository.save(kursus);
            KursusVo result = new KursusVo(saved);
            result.setKrsGambarUrl(buildImageUrl(result.getKrsGambar()));
            return result;
        }

        return null;
    }

    @Override
    public boolean softDeleteKursus(Long id, String modifier) {
        int result = kursusRepository.softDeleteById(id, modifier);
        return result > 0;
    }

    @Override
    public boolean publishKursus(Long id, String modifier) {
        int result = kursusRepository.publishById(id, modifier);
        return result > 0;
    }
}