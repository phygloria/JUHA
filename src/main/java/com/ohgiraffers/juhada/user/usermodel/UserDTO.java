package com.ohgiraffers.juhada.user.usermodel;

public class UserDTO {

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

    public UserDTO() {
    }

    public UserDTO(int userNo, String userName, String password, String email, int age, String gender, String phoneNo, String addressNo, String addressBasic, String addressDetail) {
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

    // getter

    public int getUserNo() {
        return userNo;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getAddressNo() {
        return addressNo;
    }

    public String getAddressBasic() {
        return addressBasic;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

}




//회원가입한다.
//회원번호
//이름
//이메일
//나이
//젠더
//폰넘버
//우편번호
//기본주소
//상세주소