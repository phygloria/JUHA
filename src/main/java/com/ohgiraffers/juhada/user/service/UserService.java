package com.ohgiraffers.juhada.user.service;

import com.ohgiraffers.juhada.user.repository.UserRepository;
import com.ohgiraffers.juhada.user.usermodel.UserDTO;
import com.ohgiraffers.juhada.user.usermodel.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO registerUser(UserDTO userDTO) {
        // 나이 검증
        if (userDTO.getAge() < 20) {
            return new UserDTO.Builder()
                    .userName(userDTO.getUserName())
                    .password(userDTO.getPassword())
                    .email(userDTO.getEmail())
                    .age(userDTO.getAge())
                    .gender(userDTO.getGender())
                    .phoneNo(userDTO.getPhoneNo())
                    .addressNo(userDTO.getAddressNo())
                    .addressBasic(userDTO.getAddressBasic())
                    .addressDetail(userDTO.getAddressDetail())
                    .errorMessage("가입 불가: 나이가 20세 미만입니다.")
                    .build();
        }

        // 이름 검증 (한글 3자 이상)
        if (userDTO.getUserName() == null || !userDTO.getUserName().matches("^[가-힣]{3,}$")) {
            return new UserDTO.Builder()
                    .userName(userDTO.getUserName())
                    .password(userDTO.getPassword())
                    .email(userDTO.getEmail())
                    .age(userDTO.getAge())
                    .gender(userDTO.getGender())
                    .phoneNo(userDTO.getPhoneNo())
                    .addressNo(userDTO.getAddressNo())
                    .addressBasic(userDTO.getAddressBasic())
                    .addressDetail(userDTO.getAddressDetail())
                    .errorMessage("이름은 한글로 3자 이상 입력해 주세요.")
                    .build();
        }

        // UserDTO를 UserEntity로 변환
        UserEntity userEntity = new UserEntity.Builder()
                .userName(userDTO.getUserName())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .age(userDTO.getAge())
                .gender(userDTO.getGender())
                .phoneNo(userDTO.getPhoneNo())
                .addressNo(userDTO.getAddressNo())
                .addressBasic(userDTO.getAddressBasic())
                .addressDetail(userDTO.getAddressDetail())
                .build();

        // UserEntity를 데이터베이스에 저장
        UserEntity savedUser = userRepository.save(userEntity);

        // 저장된 UserEntity를 UserDTO로 변환하여 반환
        return new UserDTO.Builder()
                .userNo(savedUser.getUserNo())
                .userName(savedUser.getUserName())
                .password(savedUser.getPassword())
                .email(savedUser.getEmail())
                .age(savedUser.getAge())
                .gender(savedUser.getGender())
                .phoneNo(savedUser.getPhoneNo())
                .addressNo(savedUser.getAddressNo())
                .addressBasic(savedUser.getAddressBasic())
                .addressDetail(savedUser.getAddressDetail())
                .build();
    }

}
