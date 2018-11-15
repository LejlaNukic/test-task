package com.javalanguagezone.interviewtwitter.service.dto;

import com.javalanguagezone.interviewtwitter.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Getter
@NoArgsConstructor(access = PRIVATE)
public class UserRegistrationDTO {
  private Long id;
  private String username;
  private String fullname;
  private String password;

  public UserRegistrationDTO(User user) {
    this.id = user.getId();
    this.username = user.getUsername();
    this.fullname = user.getFullname();
    this.password = user.getPassword();
  }
}
