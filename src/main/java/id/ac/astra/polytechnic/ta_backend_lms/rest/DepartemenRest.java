package id.ac.astra.polytechnic.ta_backend_lms.rest;

import id.ac.astra.polytechnic.ta_backend_lms.model.Departemen;
import id.ac.astra.polytechnic.ta_backend_lms.model.Seksie;
import id.ac.astra.polytechnic.ta_backend_lms.respone.DtoResponse;
import id.ac.astra.polytechnic.ta_backend_lms.service.DepartemenService;
import id.ac.astra.polytechnic.ta_backend_lms.service.KursusService;
import id.ac.astra.polytechnic.ta_backend_lms.vo.DepartemenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departemen")
public class DepartemenRest {

    @Autowired
    private DepartemenService departemenDBService;

    public static class ToggleRequest {
        public String userName;
    }

    public DepartemenRest(DepartemenService departemenDBService){
        this.departemenDBService = departemenDBService;
    }

    @GetMapping("/getDepartemen")
    public DtoResponse getDepartemen(){
        return departemenDBService.getAll();
    }

    @GetMapping("/getDep")
    public List<DepartemenVo> getAlls() {
        return departemenDBService.getAlls();
    }

    @PostMapping
    public Departemen save(@RequestBody Departemen d) {
        return departemenDBService.save(d);
    }

    @PutMapping("/update")
    public DtoResponse update(@RequestBody DepartemenVo vo) {
        return departemenDBService.update(vo);
    }

    @PutMapping("/delete/{id}")
    public DtoResponse deleteDepartemen(@PathVariable Long id, @RequestBody ToggleRequest request){
        String userName = request != null && request.userName != null ? request.userName : "SYSTEM";
        return departemenDBService.softDelete(id, userName);
    }

}
