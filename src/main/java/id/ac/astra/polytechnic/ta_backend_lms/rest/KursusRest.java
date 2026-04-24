package id.ac.astra.polytechnic.ta_backend_lms.rest;

import id.ac.astra.polytechnic.ta_backend_lms.respone.DtoResponse;
import id.ac.astra.polytechnic.ta_backend_lms.service.KursusService;
import id.ac.astra.polytechnic.ta_backend_lms.vo.KursusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/kursus")  // ← BASE URL
public class KursusRest {

    @Autowired
    private KursusService kursusService;

    // GET all kursus
    @GetMapping("/getAll")  // ← FULL URL: /api/kursus/getAll
    public ResponseEntity<DtoResponse> getAllKursus() {
        DtoResponse response = kursusService.getAllKursus();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @GetMapping("/getPublished")
    public ResponseEntity<DtoResponse> getPublishedKursus() {
        DtoResponse response = kursusService.getAllPublishedKursus();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @GetMapping("/getUnpublished")
    public ResponseEntity<DtoResponse> getUnpublishedKursus() {
        DtoResponse response = kursusService.getAllUnpublishedKursus();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DtoResponse> getKursusById(@PathVariable Long id) {
        DtoResponse response = kursusService.getKursusById(id);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @PostMapping("/create")
    public ResponseEntity<DtoResponse> createKursus(
            @RequestPart("kursus") KursusVo kursusVo,
            @RequestPart(value = "file", required = false) MultipartFile file) {
        DtoResponse response = kursusService.saveKursus(kursusVo, file);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @PutMapping("/update")
    public ResponseEntity<DtoResponse> updateKursus(
            @RequestPart("kursus") KursusVo kursusVo,
            @RequestPart(value = "file", required = false) MultipartFile file) {
        DtoResponse response = kursusService.updateKursus(kursusVo, file);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DtoResponse> deleteKursus(
            @PathVariable Long id,
            @RequestParam(defaultValue = "system") String modifier) {
        DtoResponse response = kursusService.softDeleteKursus(id, modifier);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @PutMapping("/publish/{id}")
    public ResponseEntity<DtoResponse> publishKursus(
            @PathVariable Long id,
            @RequestParam(defaultValue = "system") String modifier) {
        DtoResponse response = kursusService.publishKursus(id, modifier);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }
}