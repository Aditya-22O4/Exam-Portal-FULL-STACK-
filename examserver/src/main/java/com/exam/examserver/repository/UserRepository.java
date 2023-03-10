package com.exam.examserver.repository;

import com.exam.examserver.model.Role;
import com.exam.examserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUserName(String username);
}