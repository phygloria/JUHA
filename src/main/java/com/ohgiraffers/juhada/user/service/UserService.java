package com.ohgiraffers.juhada.user.service;

import com.ohgiraffers.juhada.user.repository.UserRepository;
import com.ohgiraffers.juhada.user.usermodel.UserDTO;
import com.ohgiraffers.juhada.user.usermodel.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUsers() {
        List<UserEntity> entities = userRepository.findAll();
        return entities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }




    @Transactional
    public UserDTO registerUser(UserDTO userDTO) {

//        // ID 중복 체크
//        if (userDTO.getUserNo() == null || userDTO.getUserNo() = ) {
//            return ResponseEntity.badRequest()
//                    .body("Id가 없거나 ");
//        }

//        // 3. 이메일 중복 체크
//        if (userRepository.existsByEmail(userDTO.getEmail())) {
//            throw new DuplicateEmailException("이미 등록된 이메일입니다.");
//        }

//        // 4. 비밀번호 암호화
//        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());

        // 5. UserEntity 생성
        UserEntity newUser = new UserEntity.UserEntityBuilder()
                .userName(userDTO.getUserName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .age(userDTO.getAge())
                .gender(userDTO.getGender())
                .phoneNo(userDTO.getPhoneNo())
                .addressNo(userDTO.getAddressNo())
                .addressBasic(userDTO.getAddressBasic())
                .addressDetail(userDTO.getAddressDetail())
                .build();

        // 6. 사용자 저장
        UserEntity savedUser = userRepository.save(newUser);


        return convertToDTO(savedUser);
    }

    public UserDTO convertToDTO(UserEntity newUser) {
        // Entity에서 DTO로 변환하여 리턴
        return UserDTO.builder()
                .userNo(newUser.getUserNo())
                .userName(newUser.getUserName())
                .password(newUser.getPassword())
                .age(newUser.getAge())
                .gender(newUser.getGender())
                .phoneNo(newUser.getPhoneNo())
                .addressNo(newUser.getAddressNo())
                .addressBasic(newUser.getAddressBasic())
                .addressDetail(newUser.getAddressDetail())
                .build();
    }

    public UserEntity getUserByNo(Integer userNo) {
        // userRepository의 findById 메서드를 사용해 userNo에 해당하는 사용자 조회
        return userRepository.findById(userNo)
                .orElse(null); // 사용자가 존재하지 않으면 null을 반환
    }


    public UserDTO updateUser(Integer userNo, UserDTO userDTO) {
        UserEntity userEntity = getUserByNo(userNo);
        userRepository.findById(userNo)
                .orElse(null);

        // 기존 사용자 정보 업데이트 (빌더 패턴 사용)
        UserEntity updatedUser = UserEntity.builder()
                .userNo(userDTO.getUserNo()) // 기존의 userNo를 유지
                .userName(userDTO.getUserName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .age(userDTO.getAge())
                .gender(userDTO.getGender())
                .phoneNo(userDTO.getPhoneNo())
                .addressNo(userDTO.getAddressNo())
                .addressBasic(userDTO.getAddressBasic())
                .addressDetail(userDTO.getAddressDetail())
                .build();

        updatedUser = userRepository.save(updatedUser);
        // Entity에서 DTO로 변환하여 리턴
        return UserDTO.builder()
                .userNo(updatedUser.getUserNo())
                .userName(updatedUser.getUserName())
                .email(updatedUser.getEmail())
                .password(updatedUser.getPassword())
                .age(updatedUser.getAge())
                .gender(updatedUser.getGender())
                .phoneNo(updatedUser.getPhoneNo())
                .addressNo(updatedUser.getAddressNo())
                .addressBasic(updatedUser.getAddressBasic())
                .addressDetail(updatedUser.getAddressDetail())
                .build();
    }

    // 사용자 삭제 메서드
    public void deleteUser(Integer userNo) {
        // userNo에 해당하는 사용자가 존재하는지 확인
        UserEntity existingUser = userRepository.findById(userNo)
                .orElseThrow(() -> new IllegalArgumentException("해당 번호로 사용자를 찾을 수 없습니다."));

        // 사용자 삭제
        userRepository.delete(existingUser);
    }

    }






