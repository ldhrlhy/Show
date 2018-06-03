package com.tour.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tour.model.User;
import com.tour.service.UserService;

@Controller  
@RequestMapping("/user")  
public class UserController {  
    @Autowired  
    private UserService userService;  
      
    @ResponseBody
    @RequestMapping("/userList")  
    public Map<String,Object> userList(HttpServletRequest request,Model model){  
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	
    	
    	List<User> uList = userService.getAllUser();  
        resultMap.put("list", uList);
    	model.addAttribute("uList", uList);  
        return resultMap;  
    }  
      
    @RequestMapping("/showUser")  
    public String showUser(HttpServletRequest request,Model model){  
        int userId = Integer.parseInt(request.getParameter("id"));  
        User user = userService.getUserById(userId);  
        model.addAttribute("user", user);  
        return "showUser";  
    }  
      
    @RequestMapping("/addUserUI")  
    public String addUserUI(){  
        return "addUser";  
    }  
      
    @RequestMapping("/addUser")  
    public String addUser(HttpServletRequest request,Model model){  
        User user = new User();  
        user.setName(String.valueOf(request.getParameter("name")));  
        user.setPassword(String.valueOf(request.getParameter("password")));  
        user.setAge(Integer.parseInt(String.valueOf(request.getParameter("age"))));  
        userService.addUser(user);  
        return "redirect:/user/userList";  
    }  
}  
