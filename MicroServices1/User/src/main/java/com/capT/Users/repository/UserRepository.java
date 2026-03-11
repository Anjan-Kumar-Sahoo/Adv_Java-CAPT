package com.capT.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capT.Users.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
