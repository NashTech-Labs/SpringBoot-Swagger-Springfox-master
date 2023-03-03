package com.nashtech.springbootswaggerspringfox.service;

import com.nashtech.springbootswaggerspringfox.entity.User;
import java.util.List;

public interface UserService {

    public User createUser(User employee);
    public User updateUser(String username, User employee) throws Exception;
    public User getUserByUsername(String username);
    public List<User> getAllUser();
    public void deleteUserById(Long employeeId);

}
