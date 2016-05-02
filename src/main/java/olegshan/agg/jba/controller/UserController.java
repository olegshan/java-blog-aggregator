package olegshan.agg.jba.controller;

import olegshan.agg.jba.entity.Blog;
import olegshan.agg.jba.entity.User;
import olegshan.agg.jba.service.BlogService;
import olegshan.agg.jba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by Bors on 25.04.2016.
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @ModelAttribute("blog")
    public Blog constructBlog() {
        return new Blog();
    }

    @RequestMapping("/account")
    public String account(Model model, Principal principal) {
        String name = principal.getName();
        model.addAttribute("user", userService.findOneWithBlogs(name));
        return "account";
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String doAddBlog(Model model, @Valid @ModelAttribute("blog") Blog blog, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return account(model, principal);
        }
        String name = principal.getName();
        blogService.save(blog, name);
        return "redirect:/account.html";
    }

    @RequestMapping("/blog/remove/{id}")
    public String removeBlog(@PathVariable int id) {
        Blog blog = blogService.findOne(id);
        blogService.delete(blog);
        return "redirect:/account.html";
    }
}













