package id.ac.astra.polytechnic.ta_backend_lms.rest;

import id.ac.astra.polytechnic.ta_backend_lms.model.User;
import id.ac.astra.polytechnic.ta_backend_lms.respone.DtoResponse;
import id.ac.astra.polytechnic.ta_backend_lms.service.KursusService;
import id.ac.astra.polytechnic.ta_backend_lms.service.UserService;
import id.ac.astra.polytechnic.ta_backend_lms.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/User")
public class UserRest {

    @Autowired
    private UserService userDBService;

    public UserRest(UserService userDBService){
        this.userDBService = userDBService;
    }

    @GetMapping("/getUser")
    public DtoResponse getUsers(){
        return userDBService.getAllUser();
    }

    @GetMapping("/by-id/{id}")
    public List<UserVo> getUserById(@PathVariable("id") Long id) {
        return userDBService.getUserById(id);
    }

    @PostMapping("/login")
    public List<UserVo> login(@RequestBody User user) {
        return userDBService.login(user.getUsrName(), user.getUsrPassword());
    }



//    @PostMapping("/saveEV")
//    public DtoResponse createPS(@RequestBody Kursus userDB){
//        return userDBService.addPS(userDB);
//    }
//
//    @PostMapping("/updateEV")
//    public DtoResponse updatePS(@RequestBody Kursus userDB){
//        return userDBService.editPS(userDB);
//    }

//    @PostMapping("/deletePS")
//    public DtoResponse deletePS(@RequestBody PS userDB){
//        return userDBService.deletePS(userDB);
//    }
}
