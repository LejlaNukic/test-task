package com.javalanguagezone.interviewtwitter.controller;

import com.javalanguagezone.interviewtwitter.domain.User;
import com.javalanguagezone.interviewtwitter.service.UserService;
import com.javalanguagezone.interviewtwitter.service.dto.UserDTO;
import com.javalanguagezone.interviewtwitter.service.dto.UserRegistrationDTO;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class UserController {

  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/followers")
  public Collection<UserDTO> followers(Principal principal) {
    return userService.getUsersFollowers(principal);
  }

  @GetMapping("/following")
  public Collection<UserDTO> following(Principal principal) {
    return userService.getUsersFollowing(principal);
  }

  @GetMapping("/countfollowers")
  public long countUserFollowers(Principal principal) {return userService.countUserFollowers(principal); }

  @GetMapping("/countfollowings")
  public long countUserFollowings(Principal principal) {return  userService.countUserFollowings(principal); }

  @PostMapping(path = "/register")
  @ResponseStatus(CREATED)
  public UserRegistrationDTO registerUser(@RequestBody UserRegistrationDTO user) {
    System.out.print("OBJEKAT KREIRAN");
    System.out.print(user);
    return userService.registerUser(user);
  }
}
