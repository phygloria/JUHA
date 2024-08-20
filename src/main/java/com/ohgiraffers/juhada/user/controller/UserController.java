package com.ohgiraffers.juhada.user.controller;

import com.ohgiraffers.juhada.user.service.UserService;
import com.ohgiraffers.juhada.user.usermodel.UserDTO;
import com.ohgiraffers.juhada.user.usermodel.UserEntity;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }


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

        // 전체조회
        @GetMapping
        public ResponseEntity<List<UserDTO>> getAllUsers() {
            List<UserDTO> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        }

        // 상세조회
        @GetMapping
        public ResponseEntity<UserEntity> getUserByNo(@PathVariable Integer userNo) {
            UserEntity user = userService.getUserByNo(userNo);
            return ResponseEntity.ok(user);
        }

        // 수정

        @PutMapping
        public ResponseEntity<?> updateUser(@PathVariable Integer userNo,
                                            @Valid @RequestBody UserDTO userDTO,
                                            BindingResult bindingResult) {
//            if (bindingResult.hasErrors()) {
//                List<String> errors = bindingResult.getAllErrors().stream()
//                        .map(ObjectError::getDefaultMessage)
//                        .collect(Collectors.toList());
//                return ResponseEntity.badRequest().body(errors);
//            }
            try {
                UserDTO updatedUser = userService.updateUser(userNo, userDTO);
                return ResponseEntity.ok(updatedUser);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }


        // 삭제

        @DeleteMapping("/{userNo}")
        public ResponseEntity<Void> deleteUser(@PathVariable Integer userNo) {
            userService.deleteUser(userNo);
            return ResponseEntity.noContent().build();
        }
    }


