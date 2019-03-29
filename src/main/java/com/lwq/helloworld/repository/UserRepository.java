package com.lwq.helloworld.repository;

import com.lwq.helloworld.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
