package com.nashtech.springbootswaggerspringfox.entity;


import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


    @Entity
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long userId;

        @ApiModelProperty(notes = "name of the user", name = "user's name",required = true,value = "Deepak")
        private String username;

        @ApiModelProperty(notes = "password of the user", name = "password",required = true,value = "DK123@")
        private String password;

        //constructor
        public User(Long userId, String username, String password) {
            super();
            this.userId = userId;
            this.username = username;
            this.password = password;
        }
        //getter-setter
        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
        public User(){
            super();
            // TODO Auto-generated constructor stub
        }
    }
