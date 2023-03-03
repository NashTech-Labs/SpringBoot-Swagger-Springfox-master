package com.nashtech.springbootswaggerspringfox.controller;

import com.nashtech.springbootswaggerspringfox.entity.User;
import com.nashtech.springbootswaggerspringfox.service.UserServiceImplement;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/api/v1")
    @Api(value = "/api/v1", tags = "User API Controller")
    public class UserController {

        @Autowired
        private UserServiceImplement serviceImplement;

        @PostMapping("/create")
        @ApiOperation(value = "Create User", notes = "Create new User", tags = {"USER CREATE"})
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "User created successfully!!"),
                @ApiResponse(code = 404, message = "Invalid Data"),
                @ApiResponse(code = 500, message = "Internal Server Error"),
        })
        public ResponseEntity<User> createEmployee(@RequestBody User employee){
            return ResponseEntity.ok(this.serviceImplement.createUser(employee));
        }

        @PutMapping("/update/{username}")
        @ApiOperation(value = "Update User", notes = "Update existing user", tags = {"USER UPDATE"})
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "User updated successfully!!"),
                @ApiResponse(code = 404, message = "Try with other username"),
                @ApiResponse(code = 500, message = "Internal Server Error"),
        })
        public ResponseEntity<User> updateEmployee
                (@PathVariable("username") String username , @RequestBody User user)
                throws Exception
        {
            return ResponseEntity.ok(this.serviceImplement.updateUser(username, user));
        }

        @GetMapping("/get/{username}")
        @ApiOperation(value = "Get User by username", notes = "get user by username if exist", tags = {"USER GET BY ID"})
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "User fetch successfully!!"),
                @ApiResponse(code = 404, message = "Invalid Data"),
                @ApiResponse(code = 500, message = "Internal Server Error"),
        })
        public User getUserByUsername(@PathVariable("username") String username) {
            return this.serviceImplement.getUserByUsername(username);
        }

        @ApiOperation(value = "Fetch all user's detail", notes = "get all user", tags = {"USER GET ALL"})
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "User fetched successfully!!"),
                @ApiResponse(code = 404, message = "Invalid Data"),
                @ApiResponse(code = 500, message = "Internal Server Error"),
        })
        @GetMapping("/getAllUser")
        public List<User> getAllUser(){
            return this.serviceImplement.getAllUser();
        }

        @DeleteMapping("/delete/{userId}")
        @ApiOperation(value = "Delete User", notes = "delete existing user", tags = {"USER DELETE"})
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "User deleted successfully!!"),
                @ApiResponse(code = 404, message = "Invalid Data"),
                @ApiResponse(code = 500, message = "Internal Server Error"),
        })
        public void deleteUserById(@PathVariable("userId") Long id) {
            this.serviceImplement.deleteUserById(id);
        }
}
