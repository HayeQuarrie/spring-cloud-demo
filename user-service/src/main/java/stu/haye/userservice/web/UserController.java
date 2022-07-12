package stu.haye.userservice.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stu.haye.user.entity.UserInfo;

@RequestMapping("/user")
@RestController
public class UserController {

    private final ObjectMapper objectMapper;

    public UserController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping("{userId}")
    public UserInfo getUser(@PathVariable Long userId) throws JsonProcessingException {
        UserInfo user = new UserInfo();
        user.setUserId(userId);
        user.setAddress("Beijing");
        user.setName("haye");
        System.out.println(objectMapper.writeValueAsString(user));
        return user;
    }
}
