package com.ohgiraffers.juhada.user.controller;

import com.ohgiraffers.juhada.user.service.UserService;
import com.ohgiraffers.juhada.user.usermodel.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody @Validated UserDTO userDTO) {
        UserDTO result = userService.registerUser(userDTO);

        // 오류 메시지가 있을 경우 BAD_REQUEST 응답
        if (result.getErrorMessage() != null) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        // 정상적으로 등록된 경우 CREATED 응답
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
