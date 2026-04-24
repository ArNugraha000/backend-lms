package id.ac.astra.polytechnic.ta_backend_lms.rest;

// controller/QuizSoalController.java
import id.ac.astra.polytechnic.ta_backend_lms.respone.ResponseVo;
import id.ac.astra.polytechnic.ta_backend_lms.service.QuizSoalService;
import id.ac.astra.polytechnic.ta_backend_lms.vo.QuizSoalDetailVo;
import id.ac.astra.polytechnic.ta_backend_lms.vo.QuizSoalVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/quiz-soal")
@CrossOrigin(origins = "*")
public class QuizSoalRest {

    @Autowired
    private QuizSoalService quizSoalService;

    @PostMapping("/create")
    public ResponseEntity<ResponseVo<QuizSoalVo>> createSoal(@RequestBody QuizSoalVo quizSoalVO) {
        ResponseVo<QuizSoalVo> response = quizSoalService.createSoal(quizSoalVO);
        if (response.isSuccess()) {
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseVo<QuizSoalVo>> updateSoal(@RequestBody QuizSoalVo quizSoalVO) {
        ResponseVo<QuizSoalVo> response = quizSoalService.updateSoal(quizSoalVO);
        if (response.isSuccess()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseVo<String>> deleteSoal(@PathVariable Long id) {
        ResponseVo<String> response = quizSoalService.deleteSoal(id);
        if (response.isSuccess()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseVo<QuizSoalVo>> getSoalById(@PathVariable Long id) {
        ResponseVo<QuizSoalVo> response = quizSoalService.getSoalById(id);
        if (response.isSuccess()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/materi/{materiId}")
    public ResponseEntity<ResponseVo<List<QuizSoalVo>>> getSoalByMateriId(@PathVariable Long materiId) {
        ResponseVo<List<QuizSoalVo>> response = quizSoalService.getSoalByMateriId(materiId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseVo<List<QuizSoalVo>>> getAllSoal() {
        ResponseVo<List<QuizSoalVo>> response = quizSoalService.getAllSoal();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/detail/{soalId}")
    public ResponseEntity<ResponseVo<QuizSoalDetailVo>> getSoalWithPilihan(@PathVariable Long soalId) {
        ResponseVo<QuizSoalDetailVo> response = quizSoalService.getSoalWithPilihan(soalId);
        if (response.isSuccess()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/materi/{materiId}/full")
    public ResponseEntity<ResponseVo<List<QuizSoalDetailVo>>> getAllSoalWithPilihanByMateri(@PathVariable Long materiId) {
        ResponseVo<List<QuizSoalDetailVo>> response = quizSoalService.getAllSoalWithPilihanByMateri(materiId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/materi/{materiId}/jenis/{jenis}")
    public ResponseEntity<ResponseVo<List<QuizSoalVo>>> getSoalByMateriIdAndJenis(
            @PathVariable Long materiId,
            @PathVariable String jenis) {
        ResponseVo<List<QuizSoalVo>> response = quizSoalService.getSoalByMateriIdAndJenis(materiId, jenis);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/materi/{materiId}/full/jenis/{jenis}")
    public ResponseEntity<ResponseVo<List<QuizSoalDetailVo>>> getAllSoalWithPilihanByMateriAndJenis(
            @PathVariable Long materiId,
            @PathVariable String jenis) {
        ResponseVo<List<QuizSoalDetailVo>> response = quizSoalService.getAllSoalWithPilihanByMateriAndJenis(materiId, jenis);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/materi/{materiId}/count")
    public ResponseEntity<ResponseVo<Integer>> getTotalSoalByMateri(@PathVariable Long materiId) {
        ResponseVo<Integer> response = quizSoalService.getTotalSoalByMateri(materiId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}