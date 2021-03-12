package com.wwillers.workshop.services;

import java.util.List;

import com.wwillers.workshop.domain.User;
import com.wwillers.workshop.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository repo;

  public List<User> findAll() {
    return repo.findAll();
  }

}
