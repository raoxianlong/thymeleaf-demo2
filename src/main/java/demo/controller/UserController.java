package demo.controller;

import demo.dao.UserDao;
import demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 002559 on 2018/7/20.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDao;

    /**
     * 查询所有用户
     */
    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList",userDao.findAll());
        model.addAttribute("title","用户列表");
        return new ModelAndView("users/list","userModel",model);
    }

    /**
     * 查看用户
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model){
        model.addAttribute("user",userDao.findOne(id));
        model.addAttribute("title","查看用户");
        return new ModelAndView("users/view","userModel",model);
    }

    @GetMapping("/form")
    public  ModelAndView createForm(Model model){
        model.addAttribute("user",new User(null, null, null, null));
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","userModel",model);
    }

    @PostMapping
    public  ModelAndView createUser(User user){
        userDao.save(user);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/delete/{id}")
    public  ModelAndView delete(@PathVariable("id") Long id){
        userDao.delete(id);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/modify/{id}")
    public  ModelAndView modify(@PathVariable("id") Long id,Model model){
        model.addAttribute("user",userDao.findOne(id));
        model.addAttribute("title","修改用户");
        return new ModelAndView("users/form","userModel",model);
    }







}

