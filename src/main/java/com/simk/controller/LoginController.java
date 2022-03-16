package com.simk.controller;

import com.simk.entities.User;
import com.simk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserMapper userMapper;
    @PostMapping("/login")
    public String login(String username, String password, Map<String,Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
            User user = userMapper.getUserByUsername(username);
            if (user != null) {
                if (user.getPassword().equals(password)) {
                    session.setAttribute("loginUser", user);
                    return "redirect:main.html";
                }
            }
        }
        map.put("msg", "用户名或密码错误");
        return "main/login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginUser");
        session.invalidate();
        return "redirect:/index.html";
    }
}
