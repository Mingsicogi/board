package mins.study.board.app.controller;

import mins.study.board.app.vo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * user 데이터로 관리 페이지 샘플
 *
 * @author minssogi
 */
@Controller
public class UserManage {

    // make sample data for view test
    private final static List<User> userList = new ArrayList<>();
    public UserManage() {
        userList.add(new User("MIN", "JEON", "minssogi"));
        userList.add(new User("BOB", "CHOI", "hot-summer"));
        userList.add(new User("JUN", "PARK", "kai"));
        userList.add(new User("MIKE", "KIM", "rose"));
    }

    /**
     * user 관리 페이지
     *
     * @param model Model
     * @return page
     */
    @GetMapping("/userList")
    public String list(Model model) {
        model.addAttribute("userList", userList);
        return "userList";
    }

    /**
     * user 추가
     *
     * @param user User
     * @return ResponseEntity
     */
    @PostMapping("/userAdd")
    @ResponseBody
    public ResponseEntity<Object> add(User user) {
        try {
            userList.add(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Occur some error while processing...");
        }
        return ResponseEntity.ok("success");
    }
}