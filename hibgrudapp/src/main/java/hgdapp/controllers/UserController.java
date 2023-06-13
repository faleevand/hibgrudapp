package hgdapp.controllers;

import hgdapp.model.User;
import hgdapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping()
    public String allusers(Model model) {
        model.addAttribute("users", userService.allusers());
        return "users/allusers";
    }

    @RequestMapping("users/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "users/show";
    }

    @RequestMapping("users/new")
    public String newPerson(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @RequestMapping("/users")
    public String create(@Valid @ModelAttribute("user")  User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "users/new";

        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping("users/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.show(id));
        return "users/edit";
    }

    @RequestMapping("users/{id}/update")
    public String update( @Valid @ModelAttribute("user") User user, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "users/edit";

        userService.update(id, user);
        return "redirect:/";
    }

    @RequestMapping("users/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}
