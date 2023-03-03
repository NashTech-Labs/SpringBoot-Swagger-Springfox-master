package com.nashtech.springbootswaggerspringfox.service;

import com.nashtech.springbootswaggerspringfox.Repository.UserRepository;
import com.nashtech.springbootswaggerspringfox.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService{

        @Autowired
        private UserRepository userRepository;

        @Override
        public User createUser(User user) {
            User local = userRepository.findByUsername(user.getUsername());
            if (local == null) {
                System.out.println("Username already taken, \n Try with other username");
            }else {
                local = this.userRepository.save(user);
            }
            return this.userRepository.save(user);
        }

        @Override
        public User updateUser(String username ,User employee) throws Exception {
            User local = userRepository.findByUsername(username);
            if (local != null) {
                User local1 = userRepository.findByUsername(employee.getUsername());
                if (local1 != null) {
                    throw new Exception("Try with another username for signup \n Thank You!!");
                }else {
                    local.setUsername(employee.getUsername());
                    local.setPassword(employee.getPassword());
                }


            }else {
                System.out.println("Please record is founded in our database");
            }
            assert local != null;
            return this.userRepository.save(local);
        }

        @Override
        public User getUserByUsername(String username) {
            return this.userRepository.findByUsername(username);
        }

        @Override
        public List<User> getAllUser() {
            return this.userRepository.findAll();
        }

        @Override
        public void deleteUserById(Long employeeId) {
            this.userRepository.deleteById(employeeId);

        }

    }


