package com.ohgiraffers.juhada.user.service;

import com.ohgiraffers.juhada.user.repository.UserRepository;
import com.ohgiraffers.juhada.user.usermodel.UserDTO;
import com.ohgiraffers.juhada.user.usermodel.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

//
//    public boolean isUserIdAvailable(Integer userNo) {
//        return !userRepository.existsByUserId(userNo);
//    }

    @Transactional
    public UserEntity registerUser(UserDTO userDTO) {

//        // ID 중복 체크
//        if (userDTO.getUserNo() == null || userDTO.getUserNo() = ) {
//            return ResponseEntity.badRequest()
//                    .body("Id가 없거나 ");
//        }

//        // 3. 이메일 중복 체크
//        if (userRepository.existsByEmail(userDTO.getEmail())) {
//            throw new DuplicateEmailException("이미 등록된 이메일입니다.");
//        }

        // 4. 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());

        // 5. UserEntity 생성
        UserEntity newUser = new UserEntity.UserEntityBuilder()
                .userName(userDTO.getUserName())
                .email(userDTO.getEmail())
                .password(encodedPassword)
                .age(userDTO.getAge())
                .gender(userDTO.getGender())
                .phoneNo(userDTO.getPhoneNo())
                .addressNo(userDTO.getAddressNo())
                .addressBasic(userDTO.getAddressBasic())
                .addressDetail(userDTO.getAddressDetail())
                .build();

        // 6. 사용자 저장
        UserEntity savedUser = userRepository.save(newUser);


        return savedUser;
    }

}



