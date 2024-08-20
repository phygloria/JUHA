package com.ohgiraffers.juhada.user.usermodel;

import javax.validation.constraints.*;

public class UserDTO {
    // 필드 선언
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

    // 기본 생성자
    public UserDTO() {}

    // 모든 필드를 포함한 생성자
    public UserDTO(Integer userNo, String userName, String password, String email, int age, String gender,
                   String phoneNo, String addressNo, String addressBasic, String addressDetail) {
        this.userNo = userNo;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.addressNo = addressNo;
        this.addressBasic = addressBasic;
        this.addressDetail = addressDetail;
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

    // Setter 메서드들
    public void setUserNo(Integer userNo) { this.userNo = userNo; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setPassword(String password) { this.password = password; }
    public void setEmail(String email) { this.email = email; }
    public void setAge(int age) { this.age = age; }
    public void setGender(String gender) { this.gender = gender; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
    public void setAddressNo(String addressNo) { this.addressNo = addressNo; }
    public void setAddressBasic(String addressBasic) { this.addressBasic = addressBasic; }
    public void setAddressDetail(String addressDetail) { this.addressDetail = addressDetail; }

    // 빌더 클래스
    public static class Builder {
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

        public Builder() {}

        public Builder userNo(Integer userNo) { this.userNo = userNo; return this; }
        public Builder userName(String userName) { this.userName = userName; return this; }
        public Builder password(String password) { this.password = password; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder age(int age) { this.age = age; return this; }
        public Builder gender(String gender) { this.gender = gender; return this; }
        public Builder phoneNo(String phoneNo) { this.phoneNo = phoneNo; return this; }
        public Builder addressNo(String addressNo) { this.addressNo = addressNo; return this; }
        public Builder addressBasic(String addressBasic) { this.addressBasic = addressBasic; return this; }
        public Builder addressDetail(String addressDetail) { this.addressDetail = addressDetail; return this; }

        public UserDTO build() {
            return new UserDTO(userNo, userName, password, email, age, gender, phoneNo, addressNo, addressBasic, addressDetail);
        }
    }

    // 빌더 생성 메서드
    public static Builder builder() {
        return new Builder();
    }
}