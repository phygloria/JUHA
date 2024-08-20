package com.ohgiraffers.juhada.user.repository;

import com.ohgiraffers.juhada.user.usermodel.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    boolean existsByEmail(String email);
    boolean existsByUserId(Integer userNo);
}
