package com.ohgiraffers.juhada.user.usermodel;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userNo;

    @NotBlank(message = "사용자 이름은 필수 입력 사항입니다.")
    private String userName;

    @NotBlank(message = "비밀번호는 필수 입력 사항입니다.")
    @Size(min = 6, message = "비밀번호는 최소 6자 이상이어야 합니다.")
    private String password;

    @NotBlank(message = "이메일은 필수 입력 사항입니다.")
    @Email(message = "유효한 이메일 주소를 입력하세요.")
    private String email;
    @Min(value = 20, message = "나이는 20세 이상이어야 합니다.")
    private int age;
    private String gender;
    private String phoneNo;

    @NotBlank(message = "우편번호는 필수 입력 사항입니다.")
    @Size(min = 6, message = "우편번호는 최소 6자 이상이어야 합니다.")
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
