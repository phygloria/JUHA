package com.ohgiraffers.juhada.user.controller;

import com.ohgiraffers.juhada.user.service.UserService;
import com.ohgiraffers.juhada.user.usermodel.UserDTO;
import com.ohgiraffers.juhada.user.usermodel.UserEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserDTO userDTO) {
        // 사용자 이름이 3글자가 아니거나 null일 경우
        if (userDTO.getUserName() == null || !userDTO.getUserName().matches("^[가-힣]{3,}$")) {
            // 잘못된 요청으로, 400 Bad Request 반환
            return ResponseEntity.badRequest()
                    .body("사용자 이름은 3글자 이상의 한글이어야 합니다.");
        }

        if (userDTO.getAge() == 0 || userDTO.getAge() < 20) {
            // 0으로 한 이유 : int는 null값을 가질 수 없음.
            // DTO로 가서 integer로 바꾸거나, 여기서 0으로 처리하거나. 둘중 하나.

            return ResponseEntity.badRequest()
                    .body("나이는 필수 입력 항목이며, 20세 이상이어야 합니다");
        }

        // 등록 코드
            userService.registerUser(userDTO);


        return ResponseEntity.ok("사용자가 성공적으로 등록되었습니다.");
    }



}