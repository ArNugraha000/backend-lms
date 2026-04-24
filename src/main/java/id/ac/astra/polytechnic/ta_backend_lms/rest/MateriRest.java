    package id.ac.astra.polytechnic.ta_backend_lms.rest;
    
    import id.ac.astra.polytechnic.ta_backend_lms.model.Materi;
    import id.ac.astra.polytechnic.ta_backend_lms.service.MateriService;
    import id.ac.astra.polytechnic.ta_backend_lms.vo.MateriVo;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.MediaType;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.multipart.MultipartFile;
    
    import java.util.HashMap;
    import java.util.List;  
    import java.util.Map;
    
    @RestController
    @RequestMapping("/api/materi")
    public class MateriRest {
    
        @Autowired
        private MateriService service;
    
        @GetMapping
        public List<Materi> getAll() {
            return service.getAll();
        }
    
        @GetMapping("/{id}")
        public Materi getById(@PathVariable Long id) {
            return service.getById(id);
        }
    
        // CREATE + FILE
        @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        public Materi create(
                @RequestPart("data") MateriVo vo,
                @RequestPart(value = "file", required = false) MultipartFile file,
                @RequestParam("userName") String userName) {
    
            return service.create(vo, file, userName);
        }
    
        // UPDATE + FILE
        @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        public Materi update(
                @PathVariable Long id,
                @RequestPart("data") MateriVo vo,
                @RequestPart(value = "file", required = false) MultipartFile file,
                @RequestParam("userName") String userName) {
    
            return service.update(id, vo, file, userName);
        }
    
        // SOFT DELETE
        @PutMapping("/delete/{id}")
        public Map<String, String> softDelete(
                @PathVariable Long id,
                @RequestParam("userName") String userName) {
    
            service.softDelete(id, userName);
    
            // Kembalikan JSON object, bukan string biasa
            Map<String, String> response = new HashMap<>();
            response.put("message", "Berhasil dihapus");
            response.put("status", "success");
            return response;
        }
    
    
    
    }
