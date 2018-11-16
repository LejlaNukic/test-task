package com.javalanguagezone.interviewtwitter.service;

import com.javalanguagezone.interviewtwitter.domain.User;
import com.javalanguagezone.interviewtwitter.repository.UserRepository;
import com.javalanguagezone.interviewtwitter.service.dto.UserDTO;
import com.javalanguagezone.interviewtwitter.service.dto.UserRegistrationDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Service
public class UserService implements UserDetailsService {

  private UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = getUser(username);
    if(user == null)
      throw new UsernameNotFoundException(username);
    return user;
  }

  @Transactional
  public Collection<UserDTO> getUsersFollowing(Principal principal) {
    User user = getUser(principal.getName());
    return convertUsersToDTOs(user.getFollowing());
  }

  @Transactional
  public Collection<UserDTO> getUsersFollowers(Principal principal) {
    User user = getUser(principal.getName());
    return convertUsersToDTOs(user.getFollowers());
  }

  @Transactional
  public UserRegistrationDTO registerUser(UserRegistrationDTO user) throws InvalidUserException {
    User newUser = new User(user.getUsername(),user.getPassword(),user.getFullname());
    if (!newUser.isValid() || getUser(user.getUsername()) != null)
      throw new InvalidUserException(user);
    User saved = userRepository.save(newUser);
    return new UserRegistrationDTO(saved);
  }

  public long countUserFollowers(Principal principal) {
    User user = getUser(principal.getName());
    return userRepository.countUsersByFollowingIsContaining(user);
  }

  public long countUserFollowings(Principal principal) {
    User user = getUser(principal.getName());
    return userRepository.countUsersByFollowersIsContaining(user);
  }

  private User getUser(String username) {
    return userRepository.findOneByUsername(username);
  }

  private List<UserDTO> convertUsersToDTOs(Set<User> users) {
    return users.stream().map(UserDTO::new).collect(toList());
  }

  public static class InvalidUserException extends RuntimeException {

    private InvalidUserException(UserRegistrationDTO user) {
      super("'" +  user.getUsername() + "'");
    }
  }
}
