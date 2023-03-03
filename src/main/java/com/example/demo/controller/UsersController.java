package com.example.demo.controller;

import com.example.demo.models.Users;
import com.example.demo.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;




@Controller
@RequestMapping("/users")
public class UsersController {
    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping()
    public String printUsers(ModelMap model) {
        model.addAttribute("users", usersService.getAllUsers());
        return "index";
    }

    @GetMapping("/addUser")
    public String newPerson(@ModelAttribute("user") Users users) {
        return "addUser";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") Users users) {
        usersService.addUser(users);
        return "redirect:/users";
    }

    @GetMapping("/{id}/show")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("edited_user", usersService.findOne(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("edited_user") Users users,
                         @PathVariable("id") int id) {
        usersService.update(id, users);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}/show")
    public String delete(@PathVariable("id") int id){
        usersService.removeUser(id);
        return "redirect:/users";
    }

}

