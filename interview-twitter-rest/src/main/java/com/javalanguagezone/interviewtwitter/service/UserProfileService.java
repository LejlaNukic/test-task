package com.javalanguagezone.interviewtwitter.service;

import com.javalanguagezone.interviewtwitter.service.dto.UserProfileDTO;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserProfileService {
  private UserService userService;
  private TweetService tweetService;

  public UserProfileService(UserService userService, TweetService tweetService) {
    this.userService = userService;
    this.tweetService = tweetService;
  }

  public UserProfileDTO getUserProfileDetails(Principal principal) {
    long numberOfTweets = tweetService.countTweetsFromUser(principal);
    long numberOfFollowers = userService.countUserFollowers(principal);
    long numberOfFollowings = userService.countUserFollowings(principal);

    UserProfileDTO userProfileDTO = new UserProfileDTO(numberOfTweets, numberOfFollowers, numberOfFollowings);
    return userProfileDTO;
  }
}

