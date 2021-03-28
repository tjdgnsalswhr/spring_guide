package com.example.demo.user.core.port_infra.persistent;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.user.core.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	public Optional<User> findByUName(String uName);

}
