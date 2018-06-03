package com.tour.service;

import java.util.List;

import com.tour.model.User;

public interface UserService {
	public User getUserById(int userId);  
	  
    public void insertUser(User user);  
  
    public void addUser(User user);  
  
    public List<User> getAllUser();  
}
