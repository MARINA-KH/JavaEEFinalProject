package com.example.demo.controller;

import com.example.demo.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {



    @GetMapping("/")
    public String index() {
        return "login";
    }




    @GetMapping("/goods_list")
    public String goodsList() {
        return "goods_list";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


}
