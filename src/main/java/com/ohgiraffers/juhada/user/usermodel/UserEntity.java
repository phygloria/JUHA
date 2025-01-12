package com.ohgiraffers.juhada.user.usermodel;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "juhada-user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private Integer userNo;

    @NotBlank(message = "사용자 이름은 필수 입력 사항입니다.")
    @Column(name = "user_name")
    private String userName;

    @NotBlank(message = "비밀번호는 필수 입력 사항입니다.")
    @Size(min = 6, message = "비밀번호는 최소 6자 이상이어야 합니다.")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "이메일은 필수 입력 사항입니다.")
    @Email(message = "유효한 이메일 주소를 입력하세요.")
    @Column(name = "email")
    private String email;
    @Min(value = 20, message = "나이는 20세 이상이어야 합니다.")
    @Column(name = "age")
    private int age;
    @Column(name = "gender")
    private String gender;
    @Column(name = "phone_no")
    private String phoneNo;

    @NotBlank(message = "우편번호는 필수 입력 사항입니다.")
    @Size(min = 6, message = "우편번호는 최소 6자 이상이어야 합니다.")
    @Column(name = "address_no")
    private String addressNo;
    @Column(name = "address_basic")
    private String addressBasic;
    @Column(name = "address_detail")
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

    // Getter 메서드들
    public Integer getUserNo() { return userNo; }
    public String getUserName() { return userName; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getPhoneNo() { return phoneNo; }
    public String getAddressNo() { return addressNo; }
    public String getAddressBasic() { return addressBasic; }
    public String getAddressDetail() { return addressDetail; }



    public static class UserEntityBuilder {
        private Integer userNo;
        private String userName;
        private String password;
        private String email;
        private int age;
        private String gender;
        private String phoneNo;
        private String addressNo;
        private String addressBasic;
        private String addressDetail;


        public UserEntityBuilder userNo(Integer userNo) {
            this.userNo = userNo;
            return this;
        }

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
