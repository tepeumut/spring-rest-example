package com.umuttepe.restexample.repository;

import com.umuttepe.restexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
