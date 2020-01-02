package com.aht.aht_crud.controller;

import com.aht.aht_crud.dao.UserDAO;
import com.aht.aht_crud.dto.UserDTO;
import com.aht.aht_crud.model.User;
import com.aht.aht_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class WebController {

    @Autowired
    private UserService service;

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/index")
    public String home(){
        return "home";
    }

    @GetMapping("/list")
    public ModelAndView show (){
        ModelAndView view = new ModelAndView();
        UserDTO user = service.show();
        view.addObject("users",user);
        view.setViewName("list");
        return view;
    }

    @GetMapping("/add")
    public String insert(Model model){
        model.addAttribute("add", new User());
        return "insert";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("add") User user){
        service.them(user);
        return "redirect:/home/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") int id, Model model){
        User user = service.findById(id);
        model.addAttribute("edit",user);
        return "edit";
    }

    @PostMapping("/updated")
    public String updated(@ModelAttribute("edit") User user){
        service.updated(user);
        return "redirect:/home/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:/home/list";
    }
}
