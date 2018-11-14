package com.javalanguagezone.interviewtwitter.service.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserProfileDTO {
  private long numberOfTweets;
  private long numberOfFollowers;
  private long numberOfFollowings;

  public UserProfileDTO(long numberOfTweets, long numberOfFollowers, long numberOfFollowings) {
    this.numberOfTweets = numberOfTweets;
    this.numberOfFollowers = numberOfFollowers;
    this.numberOfFollowings = numberOfFollowings;
  }
}
