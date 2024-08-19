package com.ohgiraffers.juhada.user.usermodel;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userNo;
    private String userName;
    private String password;
    private String email;
    private int age;
    private String gender;
    private String phoneNo;
    private String addressNo;
    private String addressBasic;
    private String addressDetail;

    public UserEntity() {
    }

    private UserEntity(UserEntityBuilder builder) {
        this.userNo = builder.userNo;
        this.userName = builder.userName;
        this.password = builder.password;
        this.email = builder.email;
        this.age = builder.age;
        this.gender = builder.gender;
        this.phoneNo = builder.phoneNo;
        this.addressNo = builder.addressNo;
        this.addressBasic = builder.addressBasic;
        this.addressDetail = builder.addressDetail;

    }

    public static class UserEntityBuilder {
        private int userNo;
        private String userName;
        private String password;
        private String email;
        private int age;
        private String gender;
        private String phoneNo;
        private String addressNo;
        private String addressBasic;
        private String addressDetail;

        public UserEntityBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserEntityBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserEntityBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserEntityBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserEntityBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public UserEntityBuilder phoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public UserEntityBuilder addressNo(String addressNo) {
            this.addressNo = addressNo;
            return this;
        }

        public UserEntityBuilder addressBasic(String addressBasic) {
            this.addressBasic = addressBasic;
            return this;
        }

        public UserEntityBuilder addressDetail(String addressDetail) {
            this.addressDetail = addressDetail;
            return this;
        }

        public UserEntity build() {
            return new UserEntity(this);
        }
    }

    public static UserEntityBuilder builder() {
        return new UserEntityBuilder();
    }





}
