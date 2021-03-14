package com.wwillers.workshop.services;

import java.util.List;
import java.util.Optional;

import com.wwillers.workshop.domain.User;
import com.wwillers.workshop.repository.UserRepository;
import com.wwillers.workshop.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository repo;

  public List<User> findAll() {
    return repo.findAll();
  }

  public User findById(String id) {
    Optional<User> obj = repo.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
  }

}
