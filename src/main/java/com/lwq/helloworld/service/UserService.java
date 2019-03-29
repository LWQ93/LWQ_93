package com.lwq.helloworld.service;

import com.lwq.helloworld.domain.User;
import com.lwq.helloworld.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserService  {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Transactional
    public User getOne(Long id) {
        return userRepository.getOne(id);
    }

    @Transactional
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    @Transactional
    public void save(User user){
        userRepository.save(user);
    }
}


