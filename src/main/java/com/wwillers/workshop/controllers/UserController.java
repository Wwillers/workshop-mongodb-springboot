package com.wwillers.workshop.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.wwillers.workshop.domain.User;
import com.wwillers.workshop.dto.UserDTO;
import com.wwillers.workshop.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

  @Autowired
  private UserService service;

  @GetMapping
  public ResponseEntity<List<UserDTO>> findAll() {
    List<User> list = service.findAll();
    List<UserDTO> listDto = list.stream().map(UserDTO::new).collect(Collectors.toList());
    return ResponseEntity.ok().body(listDto);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<UserDTO> findById(@PathVariable String id) {
    User obj = service.findById(id);

    return ResponseEntity.ok().body(new UserDTO(obj));
  }

}
