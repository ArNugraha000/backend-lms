package id.ac.astra.polytechnic.ta_backend_lms.rest;

import id.ac.astra.polytechnic.ta_backend_lms.model.Departemen;
import id.ac.astra.polytechnic.ta_backend_lms.model.Divisi;
import id.ac.astra.polytechnic.ta_backend_lms.respone.DtoResponse;
import id.ac.astra.polytechnic.ta_backend_lms.service.DivisiService;
import id.ac.astra.polytechnic.ta_backend_lms.service.KursusService;
import id.ac.astra.polytechnic.ta_backend_lms.vo.DivisiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/divisi")
public class DivisiRest {

    @Autowired
    private DivisiService divisiDBService;

    public static class ToggleRequest {
        public String userName;
    }

    public DivisiRest(DivisiService divisiDBService){
        this.divisiDBService = divisiDBService;
    }

    @GetMapping("/getDivisi")
    public DtoResponse getDivisi(){
        return divisiDBService.getAll();
    }


    @GetMapping("/getDiv")
    public List<DivisiVo> getAll() {
        return divisiDBService.findAll()
                .stream()
                .map(DivisiVo::new)
                .toList();
    }

    @PostMapping
    public Divisi save(@RequestBody Divisi d) {
        return divisiDBService.save(d);
    }


    @PutMapping("/update")
    public DtoResponse update(@RequestBody DivisiVo vo) {
        return divisiDBService.update(vo);
    }

    @PutMapping("/delete/{id}")
    public DtoResponse deleteDivisi(@PathVariable Long id, @RequestBody ToggleRequest request){
        String userName = request != null && request.userName != null ? request.userName : "SYSTEM";
        return divisiDBService.softDelete(id, userName);
    }



}
