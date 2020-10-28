package mins.study.board.app.controller;

import lombok.extern.slf4j.Slf4j;
import mins.study.board.app.dto.SignUpUserDTO;
import mins.study.board.app.repository.UserRepository;
import mins.study.board.app.vo.Hobby;
import mins.study.board.app.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
public class Index {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/userInfo")
    @ResponseBody
    public ResponseEntity<Object> getUser(String username) {
        mins.study.board.app.entity.User byUserName = userRepository.findByUserName(username);
        log.info(byUserName.toString());
        return ResponseEntity.ok("User saved!!");
    }



    @PostMapping(value = "/signUpUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> addUser(@RequestBody @Valid SignUpUserDTO user, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.toString());
        }

        mins.study.board.app.entity.User userEntity = new mins.study.board.app.entity.User(user.getFirstName(), user.getLastName(), user.getUsername());
        userRepository.save(userEntity);

        return ResponseEntity.ok("User saved!!");
    }

    @PutMapping("/test")
    @ResponseBody
    public ResponseEntity<Object> updateUser(User user) {

        if (user.getFirstName() == null || "".equals(user.getFirstName())) {
            return ResponseEntity.badRequest().body("first name is empty or null.");
            // equals string 비교 메소드를 사용할땐, 항상 상수가 먼저 시작되어야해요.
            // "".equals(user.getFirstName())
            // user.getFirstName().equals("");
        }

        log.info(user.toString());

        return ResponseEntity.ok("User saved!!");
    }

    @DeleteMapping("/test")
    @ResponseBody
    public ResponseEntity<Object> removeUser(User user) {

        if (user.getFirstName() == null || "".equals(user.getFirstName())) {
            return ResponseEntity.badRequest().body("first name is empty or null.");
            // equals string 비교 메소드를 사용할땐, 항상 상수가 먼저 시작되어야해요.
            // "".equals(user.getFirstName())
            // user.getFirstName().equals("");
        }

        log.info(user.toString());

        return ResponseEntity.ok("User saved!!");
    }
}
