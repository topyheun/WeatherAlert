package com.example.Weather.repository;

import com.example.Weather.dto.UserDto;
import com.example.Weather.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findById(String id);
}
