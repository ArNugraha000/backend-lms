package id.ac.astra.polytechnic.ta_backend_lms.rest;

// controller/QuizSoalController.java

import id.ac.astra.polytechnic.ta_backend_lms.respone.ResponseVo;
import id.ac.astra.polytechnic.ta_backend_lms.service.QuizPilihanService;
import id.ac.astra.polytechnic.ta_backend_lms.service.QuizSoalService;
import id.ac.astra.polytechnic.ta_backend_lms.vo.QuizPilihanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/quiz-pilihan")
@CrossOrigin(origins = "*")
public class QuizPilihanRest {

    @Autowired
    private QuizPilihanService quizPilihanService;

    @PostMapping("/create")
    public ResponseEntity<ResponseVo<QuizPilihanVo>> createPilihan(@RequestBody QuizPilihanVo quizPilihanVO) {
        ResponseVo<QuizPilihanVo> response = quizPilihanService.createPilihan(quizPilihanVO);
        if (response.isSuccess()) {
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseVo<QuizPilihanVo>> updatePilihan(@RequestBody QuizPilihanVo quizPilihanVO) {
        ResponseVo<QuizPilihanVo> response = quizPilihanService.updatePilihan(quizPilihanVO);
        if (response.isSuccess()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseVo<String>> deletePilihan(@PathVariable Long id) {
        ResponseVo<String> response = quizPilihanService.deletePilihan(id);
        if (response.isSuccess()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseVo<QuizPilihanVo>> getPilihanById(@PathVariable Long id) {
        ResponseVo<QuizPilihanVo> response = quizPilihanService.getPilihanById(id);
        if (response.isSuccess()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/soal/{soalId}")
    public ResponseEntity<ResponseVo<List<QuizPilihanVo>>> getPilihanBySoalId(@PathVariable Long soalId) {
        ResponseVo<List<QuizPilihanVo>> response = quizPilihanService.getPilihanBySoalId(soalId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseVo<List<QuizPilihanVo>>> getAllPilihan() {
        ResponseVo<List<QuizPilihanVo>> response = quizPilihanService.getAllPilihan();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/soal/{soalId}/batch")
    public ResponseEntity<ResponseVo<String>> saveAllPilihan(
            @PathVariable Long soalId,
            @RequestBody List<QuizPilihanVo> pilihanList) {
        ResponseVo<String> response = quizPilihanService.saveAllPilihan(pilihanList, soalId);
        if (response.isSuccess()) {
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}