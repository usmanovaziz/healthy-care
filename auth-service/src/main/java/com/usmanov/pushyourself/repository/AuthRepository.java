package com.usmanov.pushyourself.repository;

import com.usmanov.pushyourself.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthRepository extends JpaRepository<User, UUID> {

}
