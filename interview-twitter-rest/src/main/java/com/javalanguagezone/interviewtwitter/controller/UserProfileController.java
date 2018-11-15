package com.javalanguagezone.interviewtwitter.controller;

import com.javalanguagezone.interviewtwitter.service.UserProfileService;
import com.javalanguagezone.interviewtwitter.service.dto.UserProfileDTO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequestMapping("/userprofile")
@Slf4j
public class UserProfileController {
  private UserProfileService userProfileService;

  public UserProfileController(UserProfileService userProfileService) {
    this.userProfileService = userProfileService;
  }

  @GetMapping
  public UserProfileDTO getUserProfileDetails(Principal principal) {
    return userProfileService.getUserProfileDetails(principal);
  }

}
