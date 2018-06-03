package com.tour.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.dao.UserDao;
import com.tour.model.User;
import com.tour.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired  
    private UserDao userDao;  
      
    public User getUserById(int userId) {  
        return userDao.queryByPrimaryKey(userId);  
    }  
  
    public void insertUser(User user) {  
        userDao.insertUser(user);  
    }  
  
    public void addUser(User user) {  
        userDao.insertUser(user);  
    }  
  
    public List<User> getAllUser() {  
        return userDao.getAllUser();  
    }  
}	
