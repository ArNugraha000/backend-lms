package id.ac.astra.polytechnic.ta_backend_lms.rest;


import id.ac.astra.polytechnic.ta_backend_lms.model.Seksie;
import id.ac.astra.polytechnic.ta_backend_lms.respone.DtoResponse;
import id.ac.astra.polytechnic.ta_backend_lms.service.SeksieService;
import id.ac.astra.polytechnic.ta_backend_lms.vo.SeksieVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seksie")
public class SeksieRest {

    @Autowired
    private SeksieService seksieDBService;

    public static class ToggleRequest {
        public String userName;
    }

    public SeksieRest(SeksieService userDBService){
        this.seksieDBService = userDBService;
    }

    @GetMapping("/getSeksie")
    public DtoResponse getallseksie(){
        return seksieDBService.getAll();
    }

    @GetMapping("/getSek")
    public List<SeksieVo> getAlls() {
        return seksieDBService.getAlls()
                .stream()
                .map(SeksieVo::new)
                .toList();
    }
    @PostMapping
    public Seksie save(@RequestBody Seksie d) { 
        return seksieDBService.save(d);
    }

    @PutMapping("/update")
    public DtoResponse update(@RequestBody SeksieVo vo) {
        return seksieDBService.update(vo);
    }

    @PutMapping("/delete/{id}")
    public DtoResponse delete(
            @PathVariable Long id,
            @RequestBody ToggleRequest request) {
        String userName = request != null && request.userName != null ? request.userName : "SYSTEM";
        return seksieDBService.softDelete(id, userName);
    }







}
