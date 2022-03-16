package com.simk.controller;

import com.simk.bean.Car;
import com.simk.entities.BillProvider;
import com.simk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {
    @Autowired
    Car car;

    @Autowired
    UserService userService;

    @GetMapping("getbillsimk")
    @ResponseBody
    public List<BillProvider> getBillsimk(){
        List<BillProvider> bills = userService.getBills(null);
        return bills;
    }
    //    @ResponseBody
    @RequestMapping("/hello.html")
    public String hello(Map<String, Object> map, Model model) {
        map.put("name", "simk");
        model.addAttribute("name1", "simk1");
        return "hello";
    }

    @RequestMapping("/hello1.html")
    public String hello1(Map map) {
        List list=new ArrayList();
        list.add(new Car("car1",100000));
        list.add(new Car("car2",100000));
        list.add(new Car("car3",100000));
        list.add(new Car("car4",100000));
        map.put("carList",list);
        return "hello";
    }
    @RequestMapping("/hello2.html")
    public String hello2(Model model) {
        List list=new ArrayList();
        list.add(new Car("car1",100000));
        list.add(new Car("car2",100000));
        list.add(new Car("car3",100000));
        list.add(new Car("car4",100000));
        model.addAttribute("carList",list);
        return "hello";
    }

    @RequestMapping("/hello3.html")
    public String hello3(Model model, HttpSession session) {

        List list=new ArrayList();
        list.add(new Car("car1 session",100000));
        list.add(new Car("car2",100000));
        list.add(new Car("car3",100000));
        list.add(new Car("car4",100000));
        session.setAttribute("carList",list);
        session.setAttribute("car",new Car("car s",999999));
        return "hello";
    }
}
