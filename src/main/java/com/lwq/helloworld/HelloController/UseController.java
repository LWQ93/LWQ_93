package com.lwq.helloworld.HelloController;

import com.lwq.helloworld.domain.User;
import com.lwq.helloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UseController {

    //bean注入
    @Autowired
    private UserService userService;

    @RequestMapping ("/{id}")
    public User getUser(@PathVariable ("id") Long id){
        return new User(id,"lwq",27);
    }

    //获取所有的数据
    @GetMapping("/userlist")
    public ModelAndView userList(Model model){
        model.addAttribute("userList",userService.findAll());
        model.addAttribute("title","用戶管理");
        return new ModelAndView("user/list","userModel",model);
    }

    //根据id值查询用户数据
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model){
        model.addAttribute("user",userService.getOne(id));
        model.addAttribute("title","用戶查看");
        return new ModelAndView("user/view","userModel",model);
    }

    //获取创建表单页面
    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User(null,null,null));
        model.addAttribute("title","创建用戶");
        return new ModelAndView("user/form","userModel",model);
    }

    //保存用户
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user){
        userService.save(user);
        return new ModelAndView("redirect:/user/userlist");
    }

    //根据id值来删除具体用户
    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){
        userService.deleteById(id);
        return new ModelAndView("redirect:/user/userlist");
    }

    //修改用户界面
    @GetMapping(value = "edit/{id}")
    public ModelAndView editForm(@PathVariable("id") Long id,Model model){
        model.addAttribute("user",userService.getOne(id));
        model.addAttribute("title","编辑用户");
        return new ModelAndView("user/form" ,"userModel",model);
    }
}
